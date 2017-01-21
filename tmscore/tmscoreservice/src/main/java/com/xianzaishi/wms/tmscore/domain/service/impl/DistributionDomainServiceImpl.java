package com.xianzaishi.wms.tmscore.domain.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.itemcenter.client.itemsku.SkuService;
import com.xianzaishi.itemcenter.client.itemsku.dto.ItemCommoditySkuDTO;
import com.xianzaishi.itemcenter.client.itemsku.query.SkuQuery;
import com.xianzaishi.itemcenter.client.value.ValueService;
//import com.xianzaishi.tms.opdock.action.DistributionAction;
import com.xianzaishi.trade.client.LocationService;
import com.xianzaishi.trade.client.OrderService;
import com.xianzaishi.trade.client.Result;
import com.xianzaishi.trade.client.vo.DeliveryAddressVO;
import com.xianzaishi.trade.client.vo.OrderItemVO;
import com.xianzaishi.trade.client.vo.OrderVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.QueryResultVO;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.hive.domain.client.itf.IInventoryDomainClient;
import com.xianzaishi.wms.hive.vo.InventoryVO;
import com.xianzaishi.wms.job.domain.client.itf.IJobDomainClient;
import com.xianzaishi.wms.job.vo.JobVO;
import com.xianzaishi.wms.tmscore.domain.service.itf.IDistributionDomainService;
import com.xianzaishi.wms.tmscore.domain.service.itf.IWaveDomainService;
import com.xianzaishi.wms.tmscore.service.itf.IAddressAreaMappingService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionAreaService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionDetailService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionWaitSeqService;
import com.xianzaishi.wms.tmscore.service.itf.IPickService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingBasketStatuService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionStatuService;
import com.xianzaishi.wms.tmscore.service.itf.ITimingDistributionWatiSeqService;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingQueryVO;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;
import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqVO;
import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqQueryVO;
import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqVO;
import com.xianzaishi.wms.track.domain.client.itf.IOutgoingSaleDomainClient;
import com.xianzaishi.wms.track.vo.OutgoingSaleDetailVO;
import com.xianzaishi.wms.track.vo.OutgoingSaleVO;

public class DistributionDomainServiceImpl implements IDistributionDomainService {
	@Autowired
	private IDistributionService distributionService = null;
	@Autowired
	private IDistributionDetailService distributionDetailService = null;
	@Autowired
	private IPickingBasketStatuService pickingBasketStatuService = null;
	@Autowired
	private IPickService pickService = null;
	@Autowired
	private IPickingWallPositionStatuService pickingWallPositionStatuService = null;
	@Autowired
	private IPickingWallPositionService pickingWallPositionService = null;
	@Autowired
	private IDistributionWaitSeqService distributionWaitSeqService = null;
	@Autowired
	private ITimingDistributionWatiSeqService timingDistributionWatiSeqService = null;
	@Autowired
	private IDistributionAreaService distributionAreaService = null;
	@Autowired
	private IAddressAreaMappingService addressAreaMappingService = null;
	@Autowired
	private IJobDomainClient jobDomainClient = null;
	@Autowired
	private OrderService orderService = null;
	@Autowired
	private LocationService locationService = null;
	@Autowired
	private IOutgoingSaleDomainClient outgoingSaleDomainClient = null;
	@Autowired
	private IInventoryDomainClient inventoryDomainClient = null;
	@Autowired
	private IWaveDomainService waveDomainService = null;
	@Autowired
	private SkuService skuService = null;
	@Autowired
	private ValueService valueService = null;

	private static final Logger logger = Logger.getLogger(DistributionDomainServiceImpl.class);

	public Boolean createDistributionDomain(DistributionVO distributionVO) {
		if (distributionVO.getDetails() == null || distributionVO.getDetails().isEmpty()) {
			throw new BizException("请填充入库明细！");
		}
		distributionVO.init();
		Long distributionID = distributionService.addDistributionVO(distributionVO);

		distributionVO.setId(distributionID);

		initDetails(distributionID, distributionVO.getDetails());

		distributionDetailService.batchAddDistributionDetailVO(distributionVO.getDetails());
		// start or suspend

		if (check(distributionVO)) {
			start(distributionID);
		}
		return true;
	}

	public DistributionVO getDistributionDomainByID(Long distributionID) {
		if (distributionID == null || distributionID <= 0) {
			throw new BizException("id error");
		}

		DistributionVO distributionVO = distributionService.getDistributionVOByID(distributionID);

		distributionVO.setDetails(distributionDetailService.getDistributionDetailVOByDistributionID(distributionID));

		return distributionVO;
	}

	public Boolean deleteDistributionDomain(Long distributionID) {
		if (distributionID == null || distributionID <= 0) {
			throw new BizException("id error");
		}

		List<DistributionDetailVO> distributionDetailVOs = distributionDetailService
				.getDistributionDetailVOByDistributionID(distributionID);

		distributionDetailService.batchDeleteDistributionDetailVO(distributionDetailVOs);

		distributionService.deleteDistributionVOByID(distributionID);

		return true;
	}

	public Boolean addDistributionVO(DistributionVO distributionVO) {
		if (null == distributionVO) {
			return false;
		}
		distributionVO.init();
		distributionService.addDistributionVO(distributionVO);
		return true;
	}

	public List<DistributionVO> queryDistributionVOList(DistributionQueryVO distributionQueryVO) {
		return distributionService.queryDistributionVOList(distributionQueryVO);
	}

	public QueryResultVO<DistributionVO> queryDistributionVOListByPage(DistributionQueryVO distributionQueryVO) {
		QueryResultVO<DistributionVO> queryResultVO = new QueryResultVO<>();
		if (null == distributionQueryVO) {
			logger.error("参数为空");
			distributionQueryVO = new DistributionQueryVO();
		}

		logger.error("开始时间=" + distributionQueryVO.getBegin() + "=" + "== 截止时间=" + distributionQueryVO.getEnd());

		if (("").equals(distributionQueryVO.getBeginTime()) == true
				|| ("").equals(distributionQueryVO.getEndTime()) == true) {
			throw new BizException("beginTime or endTime is error");
		}

		queryResultVO.setPage(distributionQueryVO.getPage());
		queryResultVO.setSize(distributionQueryVO.getSize());

		queryResultVO.setItems(distributionService.queryDistributionVOList(distributionQueryVO));
		queryResultVO.setTotalCount(distributionService.queryDistributionCount(distributionQueryVO));

		List<DistributionVO> items = queryResultVO.getItems();
		
		Result<OrderVO> order2 = orderService.getOrder(12710L);
		logger.error("attribute = "+order2.getModel().getAttribute());

		for (int i = 0; i < items.size(); i++) {
			Long orderId = items.get(i).getOrderId();
			
			Result<OrderVO> orders = orderService.getOrder(orderId);

			if (orders != null && orders.isSuccess()) {

				OrderVO order = orders.getModel();
				DistributionVO distributionVO = items.get(i);
				distributionVO.setDesOrder(order.getAttribute());
				
			}
		}

		return queryResultVO;
	}

	public DistributionVO getDistributionVOByID(Long id) {
		return distributionService.getDistributionVOByID(id);
	}

	public Boolean modifyDistributionVO(DistributionVO distributionVO) {
		distributionVO.init();
		return distributionService.modifyDistributionVO(distributionVO);
	}

	public Boolean deleteDistributionVO(Long id) {
		return distributionService.deleteDistributionVOByID(id);
	}

	public Boolean createDistributionDetailVO(DistributionDetailVO distributionDetailVO) {
		distributionDetailVO.init();
		return distributionDetailService.addDistributionDetailVO(distributionDetailVO);
	}

	public Boolean batchCreateDistributionDetailVO(List<DistributionDetailVO> distributionDetailVOs) {
		for (DistributionDetailVO distributionDetailVO : distributionDetailVOs) {
			distributionDetailVO.init();
		}
		return distributionDetailService.batchAddDistributionDetailVO(distributionDetailVOs);
	}

	public List<DistributionDetailVO> queryDistributionDetailVOList(
			DistributionDetailQueryVO distributionDetailQueryVO) {
		return distributionDetailService.queryDistributionDetailVOList(distributionDetailQueryVO);
	}

	public List<DistributionDetailVO> getDistributionDetailVOListByDistributionID(Long distributionID) {
		return distributionDetailService.getDistributionDetailVOByDistributionID(distributionID);
	}

	public DistributionDetailVO getDistributionDetailVOByID(Long id) {
		return distributionDetailService.getDistributionDetailVOByID(id);
	}

	public Boolean modifyDistributionDetailVO(DistributionDetailVO distributionDetailVO) {
		distributionDetailVO.init();
		return distributionDetailService.modifyDistributionDetailVO(distributionDetailVO);
	}

	public Boolean batchModifyDistributionDetailVOs(List<DistributionDetailVO> distributionDetailVOs) {
		for (DistributionDetailVO distributionDetailVO : distributionDetailVOs) {
			distributionDetailVO.init();
		}
		return distributionDetailService.batchModifyDistributionDetailVO(distributionDetailVOs);
	}

	public Boolean deleteDistributionDetailVO(Long id) {
		return distributionDetailService.deleteDistributionDetailVOByID(id);
	}

	public Boolean deleteDistributionDetailVOByDistributionID(Long distributionID) {
		if (distributionID == null || distributionID <= 0) {
			throw new BizException("id error");
		}

		List<DistributionDetailVO> distributionDetailVOs = distributionDetailService
				.getDistributionDetailVOByDistributionID(distributionID);

		distributionDetailService.batchDeleteDistributionDetailVO(distributionDetailVOs);

		return true;
	}

	public Boolean batchDeleteDistributionDetailVOByDistributionID(List<Long> storyDetailIDs) {
		return distributionDetailService.batchDeleteDistributionDetailVOByID(storyDetailIDs);
	}

	private void initDetails(Long id, List<DistributionDetailVO> distributionDetailVOs) {
		for (int i = 0; i < distributionDetailVOs.size(); i++) {
			distributionDetailVOs.get(i).setDistributionId(id);
		}
	}

	public IDistributionService getDistributionService() {
		return distributionService;
	}

	public void setDistributionService(IDistributionService distributionService) {
		this.distributionService = distributionService;
	}

	public IDistributionDetailService getDistributionDetailService() {
		return distributionDetailService;
	}

	public void setDistributionDetailService(IDistributionDetailService distributionDetailService) {
		this.distributionDetailService = distributionDetailService;
	}

	public Boolean suspendDistribution(Long id) {
		return distributionService.suspendDistribution(id);
	}

	public Boolean reset(Long id) {
		distributionService.reset(id);
		start(id);
		return true;
	}

	private void start(Long id) {
		DistributionVO distributionVO = distributionService.getDistributionVOByID(id);
		if (distributionVO.getDeliveryAging() == 0) {
			DistributionWaitSeqVO distributionWaitSeqVO = new DistributionWaitSeqVO();
			distributionWaitSeqVO.setDistributionId(distributionVO.getId());
			distributionWaitSeqVO.setAgencyId(distributionVO.getAgencyId());
			distributionWaitSeqVO.setStatu(0);
			distributionWaitSeqService.addDistributionWaitSeqVO(distributionWaitSeqVO);
		} else {
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO = new TimingDistributionWatiSeqVO();
			timingDistributionWatiSeqVO.setAgencyId(distributionVO.getAgencyId());
			timingDistributionWatiSeqVO.setDistributionId(distributionVO.getId());
			timingDistributionWatiSeqVO.setDeliveryTime(
					Long.parseLong(new SimpleDateFormat("yyyyMMddHHmm").format(distributionVO.getAppointTime())));
			timingDistributionWatiSeqVO.setStatu(0);
			timingDistributionWatiSeqService.addTimingDistributionWatiSeqVO(timingDistributionWatiSeqVO);
		}
		distributionVO.setStatu(1);
		distributionService.modifyDistributionVO(distributionVO);
	}

	public void pickStart(Long id) {
		distributionService.pickStart(id);
	}

	public void picked(Long id) {
		distributionService.picked(id);
	}

	public void packStart(Long id) {
		distributionService.packStart(id);
	}

	public void packed(Long id) {
		distributionService.packed(id);
	}

	public void deilverStart(Long id) {
		distributionService.deilverStart(id);
	}

	public Boolean arrived(DistributionVO distributionVO) {
		distributionService.arrived(distributionVO.getId());
		waveDomainService.onDistributionRemove(distributionVO.getId());
		if (distributionVO.getDetails() != null && !distributionVO.getDetails().isEmpty()) {
			batchModifyDistributionDetailVOs(distributionVO.getDetails());

			orderService.updateOrderStatus(getDistributionVOByID(distributionVO.getId()).getOrderId(),
					Short.parseShort("7"));
		}
		DistributionVO tmp = getDistributionDomainByID(distributionVO.getId());
		if (tmp != null) {
			DecimalFormat df = new DecimalFormat("######0");
			OutgoingSaleVO outgoingSaleVO = new OutgoingSaleVO();
			List<OutgoingSaleDetailVO> details = new LinkedList<OutgoingSaleDetailVO>();

			outgoingSaleVO.setAgencyId(tmp.getAgencyId());
			outgoingSaleVO.setOpTime(new Date());
			outgoingSaleVO.setStatu(0);
			outgoingSaleVO.setOrderId(tmp.getOrderId());

			for (DistributionDetailVO distributionDetailVO : tmp.getDetails()) {
				OutgoingSaleDetailVO detail = new OutgoingSaleDetailVO();
				detail.setSkuId(distributionDetailVO.getSkuId());
				detail.setSkuName(distributionDetailVO.getSkuName());
				ItemCommoditySkuDTO itemCommoditySkuDTO = skuService
						.queryItemSku(SkuQuery.queryBaseSkuBySku(distributionDetailVO.getSkuId())).getModule();
				detail.setSaleUnit(valueService.queryValueNameByValueId(itemCommoditySkuDTO.getSkuUnit()).getModule());

				detail.setSaleUnitId(new Long(itemCommoditySkuDTO.getSkuUnit()));
				detail.setSaleUnitType(new Integer(itemCommoditySkuDTO.querySaleUnitType()));
				if (distributionDetailVO.getSaleUnitId() != null
						&& !distributionDetailVO.getSaleUnitId().equals(new Long(itemCommoditySkuDTO.getSkuUnit()))) {
					detail.setNumberReal(distributionDetailVO.getAllNoReal() * distributionDetailVO.getSpec() / 1000);
				} else {
					detail.setNumberReal(distributionDetailVO.getAllNoReal());
				}
				detail.setSpec(itemCommoditySkuDTO.getSkuSpecificationNum());
				detail.setSpecUnit(valueService.queryValueNameByValueId(itemCommoditySkuDTO.getSkuSpecificationUnit())
						.getModule());
				detail.setSpecUnitId(new Long(itemCommoditySkuDTO.getSkuSpecificationUnit()));
				InventoryVO inventory = inventoryDomainClient.getSkuStand(1l, distributionDetailVO.getSkuId())
						.getTarget();
				if (inventory == null) {
					JobVO jobVO = new JobVO();
					jobVO.setType(4);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("id", distributionDetailVO.getDistributionId());
					jsonObject.put("reason", "check sku-position config , skuID:" + distributionDetailVO.getSkuId());
					jobVO.setParameter(jsonObject.toString());
					jobVO.setStatu(0);
					SimpleResultVO<Boolean> flag = jobDomainClient.addJob(jobVO);
					if (!flag.isSuccess() || !flag.getTarget()) {
						throw new BizException("工单创建失败");
					}
					throw new BizException("没有找到对应的库存信息");
				}
				detail.setPositionId(inventory.getPositionId());
				detail.setPositionCode(inventory.getPositionCode());
				details.add(detail);
			}

			outgoingSaleVO.setDetails(details);
			outgoingSaleDomainClient.createAndAccountedOutgoingSaleDomain(outgoingSaleVO);
		}
		return true;
	}

	public Boolean rejected(Long id) {
		distributionService.rejected(id);
		return true;
	}

	private boolean check(DistributionVO distributionVO) {
		Boolean flag = true;
		if (distributionVO.getAreaId() == null) {
			OrderVO orderVO = orderService.getOrder(distributionVO.getOrderId()).getModel();
			DeliveryAddressVO deliveryAddressVO = locationService.getDeliveryAddressById(orderVO.getUserAddressId())
					.getModel();
			if (deliveryAddressVO == null) {
				flag = false;
				JobVO jobVO = new JobVO();
				jobVO.setType(1);
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", distributionVO.getId());
				jobVO.setParameter(jsonObject.toString());
				jobVO.setStatu(0);
				jobDomainClient.addJob(jobVO);
				flag = false;
			} else {
				DistributionAreaQueryVO distributionAreaQueryVO = new DistributionAreaQueryVO();
				distributionAreaQueryVO.setLat((int) (deliveryAddressVO.getLatitude() * 1000000));
				distributionAreaQueryVO.setLng((int) (deliveryAddressVO.getLongitude() * 1000000));
				List<DistributionAreaVO> distributionAreaVOs = distributionAreaService.getArea(distributionAreaQueryVO);
				if (distributionAreaVOs == null || !distributionAreaVOs.isEmpty()) {
					AddressAreaMappingVO addressAreaMappingVO = new AddressAreaMappingVO();
					addressAreaMappingVO.setAddressId(orderVO.getUserAddressId());
					addressAreaMappingVO.setAreaId(distributionAreaVOs.get(0).getId());
					addressAreaMappingService.addAddressAreaMappingVO(addressAreaMappingVO);
					setDistributionArea(distributionVO.getId(), distributionAreaVOs.get(0).getId());
				} else {
					JobVO jobVO = new JobVO();
					jobVO.setType(1);
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("id", distributionVO.getId());
					jobVO.setParameter(jsonObject.toString());
					jobVO.setStatu(0);
					jobDomainClient.addJob(jobVO);
					flag = false;
				}
			}
		}
		if (!flag) {
			distributionService.suspendDistribution(distributionVO.getId());
		}
		return flag;
	}

	public Boolean setDistributionArea(Long id, Long area) {
		DistributionVO distributionVO = distributionService.getDistributionVOByID(id);
		distributionVO.setAreaId(area);
		return distributionService.modifyDistributionVO(distributionVO);
	}

	public ITimingDistributionWatiSeqService getTimingDistributionWatiSeqService() {
		return timingDistributionWatiSeqService;
	}

	public void setTimingDistributionWatiSeqService(
			ITimingDistributionWatiSeqService timingDistributionWatiSeqService) {
		this.timingDistributionWatiSeqService = timingDistributionWatiSeqService;
	}

	public List<DistributionVO> assignNormal(String assign) {
		List<DistributionVO> distributionVOs = new LinkedList<DistributionVO>();
		DistributionWaitSeqVO distributionWaitSeqVO = new DistributionWaitSeqVO();
		distributionWaitSeqVO.setAssign(assign);
		if (distributionWaitSeqService.assign(distributionWaitSeqVO)) {
			DistributionWaitSeqQueryVO queryVO = new DistributionWaitSeqQueryVO();
			queryVO.setStatu(99);
			queryVO.setAssign(assign);
			List<DistributionWaitSeqVO> waitSeqVOs = distributionWaitSeqService.queryDistributionWaitSeqVOList(queryVO);
			for (int i = 0; i < waitSeqVOs.size(); i++) {
				distributionVOs.add(distributionService.getDistributionVOByID(waitSeqVOs.get(i).getDistributionId()));
			}
		}

		distributionWaitSeqService.assignToNormal(distributionWaitSeqVO);
		return distributionVOs;
	}

	public List<DistributionVO> assignTiming(String assign) {
		List<DistributionVO> distributionVOs = new LinkedList<DistributionVO>();
		TimingDistributionWatiSeqVO timingDistributionWatiSeqVO = new TimingDistributionWatiSeqVO();
		timingDistributionWatiSeqVO
				.setDeliveryTime(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmm").format(new Date())) + 30);
		timingDistributionWatiSeqVO.setAssign(assign);
		if (timingDistributionWatiSeqService.assign(timingDistributionWatiSeqVO)) {
			TimingDistributionWatiSeqQueryVO queryVO = new TimingDistributionWatiSeqQueryVO();
			queryVO.setStatu(99);
			queryVO.setAssign(assign);
			List<TimingDistributionWatiSeqVO> waitSeqVOs = timingDistributionWatiSeqService
					.queryTimingDistributionWatiSeqVOList(queryVO);
			for (int i = 0; i < waitSeqVOs.size(); i++) {
				distributionVOs.add(distributionService.getDistributionVOByID(waitSeqVOs.get(i).getDistributionId()));
			}
		}

		timingDistributionWatiSeqService.assignToNormal(timingDistributionWatiSeqVO);
		return distributionVOs;
	}

	public IPickingBasketStatuService getPickingBasketStatuService() {
		return pickingBasketStatuService;
	}

	public void setPickingBasketStatuService(IPickingBasketStatuService pickingBasketStatuService) {
		this.pickingBasketStatuService = pickingBasketStatuService;
	}

	public IPickService getPickService() {
		return pickService;
	}

	public void setPickService(IPickService pickService) {
		this.pickService = pickService;
	}

	public IPickingWallPositionStatuService getPickingWallPositionStatuService() {
		return pickingWallPositionStatuService;
	}

	public void setPickingWallPositionStatuService(IPickingWallPositionStatuService pickingWallPositionStatuService) {
		this.pickingWallPositionStatuService = pickingWallPositionStatuService;
	}

	public IPickingWallPositionService getPickingWallPositionService() {
		return pickingWallPositionService;
	}

	public void setPickingWallPositionService(IPickingWallPositionService pickingWallPositionService) {
		this.pickingWallPositionService = pickingWallPositionService;
	}

	public IDistributionWaitSeqService getDistributionWaitSeqService() {
		return distributionWaitSeqService;
	}

	public void setDistributionWaitSeqService(IDistributionWaitSeqService distributionWaitSeqService) {
		this.distributionWaitSeqService = distributionWaitSeqService;
	}

	public DistributionAreaVO getDistributionAreaByAddressID(Long agencyID, Long addressID) {
		AddressAreaMappingQueryVO mappingQueryVO = new AddressAreaMappingQueryVO();
		mappingQueryVO.setAddressId(addressID);
		List<AddressAreaMappingVO> mappingVO = addressAreaMappingService.queryAddressAreaMappingVOList(mappingQueryVO);
		if (mappingVO != null && !mappingVO.isEmpty()) {
			DistributionAreaQueryVO areaQueryVO = new DistributionAreaQueryVO();
			areaQueryVO.setAgency(agencyID);
			areaQueryVO.setId(mappingVO.get(0).getAreaId());
			List<DistributionAreaVO> areas = distributionAreaService.queryDistributionAreaVOList(areaQueryVO);
			if (areas != null && areas.size() > 0) {
				return areas.get(0);
			}
		}
		return null;
	}

	public IDistributionAreaService getDistributionAreaService() {
		return distributionAreaService;
	}

	public void setDistributionAreaService(IDistributionAreaService distributionAreaService) {
		this.distributionAreaService = distributionAreaService;
	}

	public IAddressAreaMappingService getAddressAreaMappingService() {
		return addressAreaMappingService;
	}

	public void setAddressAreaMappingService(IAddressAreaMappingService addressAreaMappingService) {
		this.addressAreaMappingService = addressAreaMappingService;
	}

	public IJobDomainClient getJobDomainClient() {
		return jobDomainClient;
	}

	public void setJobDomainClient(IJobDomainClient jobDomainClient) {
		this.jobDomainClient = jobDomainClient;
	}

	private Boolean isStandard(ItemCommoditySkuDTO itemCommoditySkuDTO) {
		Boolean flag = true;
		if (itemCommoditySkuDTO.querySaleUnitType() == 4) {
			flag = false;
		}
		return flag;
	}

	public static void main(String[] args) {
		System.out.println(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmm").format(new Date())) + 30);
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public IOutgoingSaleDomainClient getOutgoingSaleDomainClient() {
		return outgoingSaleDomainClient;
	}

	public void setOutgoingSaleDomainClient(IOutgoingSaleDomainClient outgoingSaleDomainClient) {
		this.outgoingSaleDomainClient = outgoingSaleDomainClient;
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public IInventoryDomainClient getInventoryDomainClient() {
		return inventoryDomainClient;
	}

	public void setInventoryDomainClient(IInventoryDomainClient inventoryDomainClient) {
		this.inventoryDomainClient = inventoryDomainClient;
	}

	public List<DistributionVO> getDistributionByOrderID(Long orderID) {
		DistributionQueryVO queryVO = new DistributionQueryVO();
		queryVO.setOrderId(orderID);
		queryVO.setDr(Short.parseShort("0"));
		return distributionService.queryDistributionVOList(queryVO);
	}

	public Boolean closeDistribution(DistributionVO distributionVO) {
		distributionVO.init();
		waveDomainService.onDistributionRemove(distributionVO.getId());
		return distributionService.closeDistribution(distributionVO);
	}

	public IWaveDomainService getWaveDomainService() {
		return waveDomainService;
	}

	public void setWaveDomainService(IWaveDomainService waveDomainService) {
		this.waveDomainService = waveDomainService;
	}

	public SkuService getSkuService() {
		return skuService;
	}

	public void setSkuService(SkuService skuService) {
		this.skuService = skuService;
	}

	public ValueService getValueService() {
		return valueService;
	}

	public void setValueService(ValueService valueService) {
		this.valueService = valueService;
	}
}

package com.xianzaishi.wms.tmscore.domain.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.trade.client.OrderService;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.hive.domain.client.itf.IAgencyDomainClient;
import com.xianzaishi.wms.hive.domain.client.itf.IInventoryConfigDomainClient;
import com.xianzaishi.wms.hive.domain.client.itf.IInventoryDomainClient;
import com.xianzaishi.wms.hive.domain.client.itf.IPositionDomainClient;
import com.xianzaishi.wms.hive.vo.InventoryVO;
import com.xianzaishi.wms.hive.vo.PositionDetailVO;
import com.xianzaishi.wms.hive.vo.PositionVO;
import com.xianzaishi.wms.job.domain.client.itf.IJobDomainClient;
import com.xianzaishi.wms.job.vo.JobVO;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickDomainService;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickingWallPositionDomainService;
import com.xianzaishi.wms.tmscore.domain.service.itf.IWaveDomainService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionDetailService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionWaitSeqService;
import com.xianzaishi.wms.tmscore.service.itf.IPickDetailService;
import com.xianzaishi.wms.tmscore.service.itf.IPickService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingBasketStatuService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionStatuService;
import com.xianzaishi.wms.tmscore.service.itf.ITimingDistributionWatiSeqService;
import com.xianzaishi.wms.tmscore.service.itf.IWaveDetailService;
import com.xianzaishi.wms.tmscore.service.itf.IWaveService;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;
import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;
import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public class WaveDomainServiceImpl implements IWaveDomainService {
	private static final Integer MAX_WAVE_POOL_DETAIL_SIZE = 3;

	private static final Integer WAVE_WAIT_TIME = 3;
	@Autowired
	private IWaveService waveService = null;
	@Autowired
	private IWaveDetailService waveDetailService = null;
	@Autowired
	private IPickingBasketStatuService pickingBasketStatuService = null;
	@Autowired
	private IPickService pickService = null;
	@Autowired
	private IPickDomainService pickDomainService = null;
	@Autowired
	private IPickDetailService pickDetailService = null;
	@Autowired
	private IPickingWallPositionStatuService pickingWallPositionStatuService = null;
	@Autowired
	private IPickingWallPositionService pickingWallPositionService = null;
	@Autowired
	private IPickingWallPositionDomainService pickingWallPositionDomainService = null;
	@Autowired
	private OrderService orderService = null;
	@Autowired
	private IDistributionService distributionService = null;
	@Autowired
	private IDistributionDetailService distributionDetailService = null;
	@Autowired
	private IInventoryDomainClient inventoryDomainClient = null;
	@Autowired
	private IDistributionWaitSeqService distributionWaitSeqService = null;
	@Autowired
	private ITimingDistributionWatiSeqService timingDistributionWatiSeqService = null;
	@Autowired
	private IAgencyDomainClient agencyDomainClient = null;
	@Autowired
	private IInventoryConfigDomainClient inventoryConfigDomainClient = null;
	@Autowired
	private IJobDomainClient jobDomainClient = null;
	@Autowired
	private IPositionDomainClient positionDomainClient = null;

	public Boolean createWaveDomain(WaveVO waveVO) {
		if (waveVO.getDetails() == null || waveVO.getDetails().isEmpty()) {
			throw new BizException("请填充入库明细！");
		}

		Long waveID = waveService.addWaveVO(waveVO);

		initDetails(waveID, waveVO.getDetails());

		waveDetailService.batchAddWaveDetailVO(waveVO.getDetails());

		return true;
	}

	public WaveVO getWaveDomainByID(Long waveID) {
		if (waveID == null || waveID <= 0) {
			throw new BizException("id error");
		}

		WaveVO waveVO = waveService.getWaveVOByID(waveID);

		waveVO.setDetails(waveDetailService.getWaveDetailVOByWaveID(waveID));

		return waveVO;
	}

	public Boolean deleteWaveDomain(Long waveID) {
		if (waveID == null || waveID <= 0) {
			throw new BizException("id error");
		}

		List<WaveDetailVO> waveDetailVOs = waveDetailService
				.getWaveDetailVOByWaveID(waveID);

		waveDetailService.batchDeleteWaveDetailVO(waveDetailVOs);

		waveService.deleteWaveVOByID(waveID);

		return true;
	}

	public Boolean addWaveVO(WaveVO waveVO) {
		waveService.addWaveVO(waveVO);
		return true;
	}

	public List<WaveVO> queryWaveVOList(WaveQueryVO waveQueryVO) {
		return waveService.queryWaveVOList(waveQueryVO);
	}

	public WaveVO getWaveVOByID(Long id) {
		return waveService.getWaveVOByID(id);
	}

	public Boolean modifyWaveVO(WaveVO waveVO) {
		return waveService.modifyWaveVO(waveVO);
	}

	public Boolean deleteWaveVO(Long id) {
		return waveService.deleteWaveVOByID(id);
	}

	public Boolean createWaveDetailVO(WaveDetailVO waveDetailVO) {
		return waveDetailService.addWaveDetailVO(waveDetailVO);
	}

	public Boolean batchCreateWaveDetailVO(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailService.batchAddWaveDetailVO(waveDetailVOs);
	}

	public List<WaveDetailVO> queryWaveDetailVOList(
			WaveDetailQueryVO waveDetailQueryVO) {
		return waveDetailService.queryWaveDetailVOList(waveDetailQueryVO);
	}

	public List<WaveDetailVO> getWaveDetailVOListByWaveID(Long waveID) {
		return waveDetailService.getWaveDetailVOByWaveID(waveID);
	}

	public WaveDetailVO getWaveDetailVOByID(Long id) {
		return waveDetailService.getWaveDetailVOByID(id);
	}

	public Boolean modifyWaveDetailVO(WaveDetailVO waveDetailVO) {
		return waveDetailService.modifyWaveDetailVO(waveDetailVO);
	}

	public Boolean batchModifyWaveDetailVOs(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailService.batchModifyWaveDetailVO(waveDetailVOs);
	}

	public Boolean deleteWaveDetailVO(Long id) {
		return waveDetailService.deleteWaveDetailVOByID(id);
	}

	public Boolean deleteWaveDetailVOByWaveID(Long waveID) {
		if (waveID == null || waveID <= 0) {
			throw new BizException("id error");
		}

		List<WaveDetailVO> waveDetailVOs = waveDetailService
				.getWaveDetailVOByWaveID(waveID);

		waveDetailService.batchDeleteWaveDetailVO(waveDetailVOs);

		return true;
	}

	public Boolean batchDeleteWaveDetailVOByWaveID(List<Long> storyDetailIDs) {
		return waveDetailService.batchDeleteWaveDetailVOByID(storyDetailIDs);
	}

	private void initDetails(Long id, List<WaveDetailVO> waveDetailVOs) {
		for (int i = 0; i < waveDetailVOs.size(); i++) {
			waveDetailVOs.get(i).setWaveId(id);
		}
	}

	public IWaveService getWaveService() {
		return waveService;
	}

	public void setWaveService(IWaveService waveService) {
		this.waveService = waveService;
	}

	public IWaveDetailService getWaveDetailService() {
		return waveDetailService;
	}

	public void setWaveDetailService(IWaveDetailService waveDetailService) {
		this.waveDetailService = waveDetailService;
	}

	@Override
	public WaveVO getWaveByPickingBasketID(Long pickingBasketID) {
		PickingBasketStatuQueryVO pickingBasketStatuQueryVO = new PickingBasketStatuQueryVO();
		pickingBasketStatuQueryVO.setBasketId(pickingBasketID);
		List<PickingBasketStatuVO> pickingBasketStatuVOs = pickingBasketStatuService
				.queryPickingBasketStatuVOList(pickingBasketStatuQueryVO);
		PickVO pickVO = pickService.getPickVOByID(pickingBasketStatuVOs.get(0)
				.getAssignmentId());
		WaveVO waveVO = waveService.getWaveVOByID(pickVO.getWaveId());
		PickQueryVO pickQueryVO = new PickQueryVO();
		pickQueryVO.setWaveId(waveVO.getId());
		waveVO.setPickVOs(pickService.queryPickVOList(pickQueryVO));
		waveVO.setPickingWallPositions(pickingWallPositionDomainService
				.getPickingWallPositionByWaveID(waveVO.getId()));
		List<PickDetailVO> pickDetails = new LinkedList<>();
		for (PickVO tmpVO : waveVO.getPickVOs()) {
			pickDetails.addAll(pickDetailService.getPickDetailVOByPickID(tmpVO
					.getId()));
		}
		waveVO.setPickDetails(pickDetails);
		return waveVO;
	}

	public IPickingBasketStatuService getPickingBasketStatuService() {
		return pickingBasketStatuService;
	}

	public void setPickingBasketStatuService(
			IPickingBasketStatuService pickingBasketStatuService) {
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

	public void setPickingWallPositionStatuService(
			IPickingWallPositionStatuService pickingWallPositionStatuService) {
		this.pickingWallPositionStatuService = pickingWallPositionStatuService;
	}

	public Boolean assignPickingWallPosition(Long waveID,
			Long pickingWallPositionID) {
		pickingWallPositionStatuService.assign(waveID, pickingWallPositionID);
		return true;
	}

	@Override
	public WaveVO getWaveByWallPositionBarcode(String wallPositionBarcode) {
		PickingWallPositionQueryVO pickingWallPositionQueryVO = new PickingWallPositionQueryVO();
		pickingWallPositionQueryVO.setBarcode(wallPositionBarcode);
		PickingWallPositionStatuQueryVO pickingWallPositionStatuQueryVO = new PickingWallPositionStatuQueryVO();
		pickingWallPositionStatuQueryVO
				.setWallPositionId(pickingWallPositionService
						.queryPickingWallPositionVOList(
								pickingWallPositionQueryVO).get(0).getId());
		WaveVO waveVO = waveService
				.getWaveVOByID(pickingWallPositionStatuService
						.queryPickingWallPositionStatuVOList(
								pickingWallPositionStatuQueryVO).get(0)
						.getAssignmentId());
		PickQueryVO pickQueryVO = new PickQueryVO();
		pickQueryVO.setWaveId(waveVO.getId());
		waveVO.setPickVOs(pickService.queryPickVOList(pickQueryVO));
		waveVO.setPickingWallPositions(pickingWallPositionDomainService
				.getPickingWallPositionByWaveID(waveVO.getId()));
		List<PickDetailVO> pickDetails = new LinkedList<>();
		for (PickVO pickVO : waveVO.getPickVOs()) {
			pickDetails.addAll(pickDetailService.getPickDetailVOByPickID(pickVO
					.getId()));
		}
		waveVO.setPickDetails(pickDetails);
		return waveVO;
	}

	public IPickingWallPositionService getPickingWallPositionService() {
		return pickingWallPositionService;
	}

	public void setPickingWallPositionService(
			IPickingWallPositionService pickingWallPositionService) {
		this.pickingWallPositionService = pickingWallPositionService;
	}

	public WaveVO assignWaveTask(Long agencyID, Long operator) {
		WaveQueryVO queryVO = new WaveQueryVO();
		queryVO.setAgencyId(agencyID);
		queryVO.setStatu(1);
		List<WaveVO> waveVOs = waveService.queryWaveVOList(queryVO);
		for (int i = 0; i < waveVOs.size(); i++) {
			waveVOs.get(i).setOperator(operator);
			waveVOs.get(i).setStatu(2);
			WaveVO waveVO = waveService.assign(waveVOs.get(i));
			if (waveVO != null) {
				List<WaveDetailVO> waveDetails = waveDetailService
						.getWaveDetailVOByWaveID(waveVOs.get(i).getId());
				for (WaveDetailVO waveDetailVO : waveDetails) {
					distributionService.packStart(waveDetailVO
							.getDistributionId());
				}
				return waveVO;
			}
		}
		return null;
	}

	public Boolean createWaveByDistribution(DistributionVO distributionVO) {
		throw new BizException(" no implements");
	}

	public Boolean waveFinished(Long waveID) {
		List<WaveDetailVO> waveDetails = waveDetailService
				.getWaveDetailVOByWaveID(waveID);
		for (WaveDetailVO waveDetailVO : waveDetails) {
			distributionService.picked(waveDetailVO.getDistributionId());
		}
		return waveService.waveFinished(waveID);
	}

	private Boolean createPick(WaveVO waveVO) {
		try {
			Map<Long, PickVO> areaMaps = new HashMap<Long, PickVO>();
			Map<Long, PickDetailVO> skuMaps = new HashMap<Long, PickDetailVO>();
			List<DistributionDetailVO> distributionDetailVOs = null;
			PositionVO positionVO = null;
			PickVO pickVO = null;
			PickDetailVO pickDetailVO = null;
			for (int i = 0; i < waveVO.getDetails().size(); i++) {
				distributionDetailVOs = distributionDetailService
						.getDistributionDetailVOByDistributionID(waveVO
								.getDetails().get(i).getDistributionId());
				for (int j = 0; j < distributionDetailVOs.size(); j++) {
					positionVO = getPickPosition(waveVO.getAgencyId(),
							distributionDetailVOs.get(j).getSkuId());
					if (areaMaps.containsKey(positionVO.getAreaId())) {
						pickVO = areaMaps.get(positionVO.getAreaId());
						if (!skuMaps.containsKey(distributionDetailVOs.get(j)
								.getSkuId())) {
							pickDetailVO = new PickDetailVO();
							pickDetailVO.setSkuId(distributionDetailVOs.get(j)
									.getSkuId());
							pickDetailVO.setSkuName(distributionDetailVOs
									.get(j).getSkuName());
							pickDetailVO.setOrderNoReal(distributionDetailVOs
									.get(j).getDelivNoReal());
							pickDetailVO.setPositionId(positionVO.getId());
							pickDetailVO.setPositionCode(positionVO.getCode());
							pickDetailVO.setSaleUnit(distributionDetailVOs.get(
									j).getSaleUnit());
							pickDetailVO.setSaleUnitId(distributionDetailVOs
									.get(j).getSaleUnitId());
							pickDetailVO.setSaleUnitType(distributionDetailVOs
									.get(j).getSaleUnitType());
							pickDetailVO.setSpec(distributionDetailVOs.get(j)
									.getSpec());
							pickDetailVO.setSpecUnit(distributionDetailVOs.get(
									j).getSpecUnit());
							pickDetailVO.setSpecUnitId(distributionDetailVOs
									.get(j).getSpecUnitId());
							addPickDetail(pickVO, pickDetailVO);
							skuMaps.put(pickDetailVO.getSkuId(), pickDetailVO);
						} else {
							pickDetailVO = skuMaps.get(distributionDetailVOs
									.get(j).getSkuId());
							pickDetailVO.setOrderNo(pickDetailVO.getOrderNo()
									+ distributionDetailVOs.get(j)
											.getDelivNoReal());
						}
					} else {
						pickVO = new PickVO();
						areaMaps.put(positionVO.getAreaId(), pickVO);

						pickVO.setAreaId(positionVO.getAreaId());
						pickVO.setAgencyId(positionVO.getAgencyId());
						pickVO.setStatu(Short.parseShort("0"));
						pickVO.setWaveId(waveVO.getId());

						pickDetailVO = new PickDetailVO();
						pickDetailVO.setSkuId(distributionDetailVOs.get(j)
								.getSkuId());
						pickDetailVO.setSkuName(distributionDetailVOs.get(j)
								.getSkuName());
						pickDetailVO.setOrderNoReal(distributionDetailVOs
								.get(j).getDelivNoReal());
						pickDetailVO.setPositionId(positionVO.getId());
						pickDetailVO.setPositionCode(positionVO.getCode());
						pickDetailVO.setSaleUnit(distributionDetailVOs.get(j)
								.getSaleUnit());
						pickDetailVO.setSaleUnitId(distributionDetailVOs.get(j)
								.getSaleUnitId());
						pickDetailVO.setSaleUnitType(distributionDetailVOs.get(
								j).getSaleUnitType());
						pickDetailVO.setSpec(distributionDetailVOs.get(j)
								.getSpec());
						pickDetailVO.setSpecUnit(distributionDetailVOs.get(j)
								.getSpecUnit());
						pickDetailVO.setSpecUnitId(distributionDetailVOs.get(j)
								.getSpecUnitId());
						addPickDetail(pickVO, pickDetailVO);
						skuMaps.put(pickDetailVO.getSkuId(), pickDetailVO);
					}
				}
			}
			for (PickVO pickItem : areaMaps.values()) {
				pickDomainService.createPickDomain(pickItem);
			}
			for (WaveDetailVO waveDetail : waveVO.getDetails()) {
				orderService.updateOrderStatus(distributionService
						.getDistributionVOByID(waveDetail.getDistributionId())
						.getOrderId(), Short.parseShort("5"));
			}
		} catch (Exception e) {
			JobVO jobVO = new JobVO();
			jobVO.setType(3);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", waveVO.getId());
			jsonObject.put("reason", e.getMessage());
			jobVO.setParameter(jsonObject.toString());
			jobVO.setStatu(0);
			SimpleResultVO<Boolean> flag = jobDomainClient.addJob(jobVO);
			if (!flag.isSuccess() || !flag.getTarget()) {
				throw new BizException("工单创建失败");
			}
		}
		return true;
	}

	private PositionVO getPickPosition(Long agencyID, Long skuID) {
		PositionVO positionVO = null;
		// 针对店
		if (agencyDomainClient.getAgencyByID(agencyID).getTarget().getType() == 1) {
			List<PositionDetailVO> positionDetailVOs = inventoryConfigDomainClient
					.getPositionDetailBySkuID(agencyID, skuID).getTarget();
			if (positionDetailVOs == null || positionDetailVOs.isEmpty()) {
				throw new BizException("check sku-position config , skuID:"
						+ skuID);
			}
			Long positionID = positionDetailVOs.get(0).getPositionId();
			positionVO = positionDomainClient.getPositionVOByID(positionID)
					.getTarget();
			// 针对仓
		} else {
			SimpleResultVO<List<InventoryVO>> inventories = inventoryDomainClient
					.getInventoryBySKUID(agencyID, skuID);
			if (!inventories.isSuccess()) {
				throw new BizException(inventories.getMessage());
			}
			InventoryVO inventory = choiceInventory(inventories.getTarget());
			Long positionID = inventory.getPositionId();
			positionVO = positionDomainClient.getPositionVOByID(positionID)
					.getTarget();
		}
		return positionVO;
	}

	private void addPickDetail(PickVO pickVO, PickDetailVO pickDetailVO) {
		if (pickVO.getDetails() == null) {
			pickVO.setDetails(new LinkedList<PickDetailVO>());
		}
		pickVO.getDetails().add(pickDetailVO);
	}

	private InventoryVO choiceInventory(List<InventoryVO> inventories) {
		for (InventoryVO inventoryVO : inventories) {
			if (inventoryVO.getNumberReal() > 0)
				return inventoryVO;
		}
		throw new BizException("缺货中，请核查库存。");
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

	public void setDistributionDetailService(
			IDistributionDetailService distributionDetailService) {
		this.distributionDetailService = distributionDetailService;
	}

	public IInventoryDomainClient getInventoryDomainClient() {
		return inventoryDomainClient;
	}

	public void setInventoryDomainClient(
			IInventoryDomainClient inventoryDomainClient) {
		this.inventoryDomainClient = inventoryDomainClient;
	}

	public IPickDomainService getPickDomainService() {
		return pickDomainService;
	}

	public void setPickDomainService(IPickDomainService pickDomainService) {
		this.pickDomainService = pickDomainService;
	}

	public IDistributionWaitSeqService getDistributionWaitSeqService() {
		return distributionWaitSeqService;
	}

	public void setDistributionWaitSeqService(
			IDistributionWaitSeqService distributionWaitSeqService) {
		this.distributionWaitSeqService = distributionWaitSeqService;
	}

	public ITimingDistributionWatiSeqService getTimingDistributionWatiSeqService() {
		return timingDistributionWatiSeqService;
	}

	public void setTimingDistributionWatiSeqService(
			ITimingDistributionWatiSeqService timingDistributionWatiSeqService) {
		this.timingDistributionWatiSeqService = timingDistributionWatiSeqService;
	}

	public IAgencyDomainClient getAgencyDomainClient() {
		return agencyDomainClient;
	}

	public void setAgencyDomainClient(IAgencyDomainClient agencyDomainClient) {
		this.agencyDomainClient = agencyDomainClient;
	}

	public IInventoryConfigDomainClient getInventoryConfigDomainClient() {
		return inventoryConfigDomainClient;
	}

	public void setInventoryConfigDomainClient(
			IInventoryConfigDomainClient inventoryConfigDomainClient) {
		this.inventoryConfigDomainClient = inventoryConfigDomainClient;
	}

	public IPickDetailService getPickDetailService() {
		return pickDetailService;
	}

	public void setPickDetailService(IPickDetailService pickDetailService) {
		this.pickDetailService = pickDetailService;
	}

	public IPickingWallPositionDomainService getPickingWallPositionDomainService() {
		return pickingWallPositionDomainService;
	}

	public void setPickingWallPositionDomainService(
			IPickingWallPositionDomainService pickingWallPositionDomainService) {
		this.pickingWallPositionDomainService = pickingWallPositionDomainService;
	}

	public IJobDomainClient getJobDomainClient() {
		return jobDomainClient;
	}

	public void setJobDomainClient(IJobDomainClient jobDomainClient) {
		this.jobDomainClient = jobDomainClient;
	}

	public Boolean releaseWaveTask(Long waveID) {
		return waveService.releaseWaveTask(waveID);
	}

	public IPositionDomainClient getPositionDomainClient() {
		return positionDomainClient;
	}

	public void setPositionDomainClient(
			IPositionDomainClient positionDomainClient) {
		this.positionDomainClient = positionDomainClient;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public Boolean reset(Long id) {
		WaveVO waveVO = getWaveDomainByID(id);

		return createPick(waveVO);
	}

	public Boolean onDistributionRemove(Long distributionID) {
		WaveDetailQueryVO waveDetailQueryVO = new WaveDetailQueryVO();
		waveDetailQueryVO.setDistributionId(distributionID);
		List<WaveDetailVO> waveDetailVOs = waveDetailService
				.queryWaveDetailVOList(waveDetailQueryVO);
		if (waveDetailVOs != null && waveDetailVOs.size() > 0) {
			WaveVO waveVO = waveService.getWaveVOByID(waveDetailVOs.get(0)
					.getWaveId());
			if (waveVO != null && waveVO.getStatu() < 3) {
				for (WaveDetailVO waveDetailItem : waveDetailVOs) {
					waveDetailService.deleteWaveDetailVOByID(waveDetailItem
							.getId());
				}
				waveDetailVOs = waveDetailService
						.getWaveDetailVOByWaveID(waveVO.getId());
				if (waveDetailVOs == null || waveDetailVOs.size() == 0) {
					waveVO.setStatu(3);
					waveService.modifyWaveVO(waveVO);
					// pick
					PickQueryVO pickQueryVO = new PickQueryVO();
					pickQueryVO.setWaveId(waveVO.getId());
					List<PickVO> pickVOs = pickService
							.queryPickVOList(pickQueryVO);
					if (pickVOs != null && !pickVOs.isEmpty()) {
						for (PickVO pickVO : pickVOs) {
							pickService.cancelPickTask(pickVO.getId());
						}
					}
				}
			}
		}
		return true;
	}
}

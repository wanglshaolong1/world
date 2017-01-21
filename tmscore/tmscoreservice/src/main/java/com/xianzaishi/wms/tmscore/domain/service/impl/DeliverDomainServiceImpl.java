package com.xianzaishi.wms.tmscore.domain.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.trade.client.OrderService;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.domain.service.itf.IDeliverDomainService;
import com.xianzaishi.wms.tmscore.service.itf.IDeliverDetailService;
import com.xianzaishi.wms.tmscore.service.itf.IDeliverDistributionService;
import com.xianzaishi.wms.tmscore.service.itf.IDeliverService;
import com.xianzaishi.wms.tmscore.service.itf.IDeliveryAreaService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionBoxService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionBoxStatuService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionService;
import com.xianzaishi.wms.tmscore.service.itf.IWaveService;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;
import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public class DeliverDomainServiceImpl implements IDeliverDomainService {
	private static final Logger logger = Logger
			.getLogger(DeliverDomainServiceImpl.class);
	@Autowired
	private IDeliverService deliverService = null;
	@Autowired
	private IDeliverDetailService deliverDetailService = null;
	@Autowired
	private IDeliverDistributionService deliverDistributionService = null;
	@Autowired
	private IDistributionBoxStatuService distributionBoxStatuService = null;
	@Autowired
	private IDistributionBoxService distributionBoxService = null;
	@Autowired
	private IDistributionService distributionService = null;
	@Autowired
	private IWaveService waveService = null;
	@Autowired
	private OrderService orderService = null;
	@Autowired
	private IDeliveryAreaService deliveryAreaService = null;

	public Boolean createDeliverDomain(DeliverVO deliverVO) {
		if (deliverVO.getDetails() == null || deliverVO.getDetails().isEmpty()) {
			throw new BizException("请填充入库明细！");
		}

		Long deliverID = deliverService.addDeliverVO(deliverVO);

		initDetails(deliverID, deliverVO.getDetails());

		deliverDetailService.batchAddDeliverDetailVO(deliverVO.getDetails());

		return true;
	}

	public DeliverVO getDeliverDomainByID(Long deliverID) {
		if (deliverID == null || deliverID <= 0) {
			throw new BizException("id error");
		}

		DeliverVO deliverVO = deliverService.getDeliverVOByID(deliverID);

		deliverVO.setDetails(deliverDetailService
				.getDeliverDetailVOByDeliverID(deliverID));

		return deliverVO;
	}

	public Boolean deleteDeliverDomain(Long deliverID) {
		if (deliverID == null || deliverID <= 0) {
			throw new BizException("id error");
		}

		List<DeliverDetailVO> deliverDetailVOs = deliverDetailService
				.getDeliverDetailVOByDeliverID(deliverID);

		deliverDetailService.batchDeleteDeliverDetailVO(deliverDetailVOs);

		deliverService.deleteDeliverVOByID(deliverID);

		return true;
	}

	public Boolean addDeliverVO(DeliverVO deliverVO) {
		deliverService.addDeliverVO(deliverVO);
		return true;
	}

	public List<DeliverVO> queryDeliverVOList(DeliverQueryVO deliverQueryVO) {
		return deliverService.queryDeliverVOList(deliverQueryVO);
	}

	public DeliverVO getDeliverVOByID(Long id) {
		return deliverService.getDeliverVOByID(id);
	}

	public Boolean modifyDeliverVO(DeliverVO deliverVO) {
		return deliverService.modifyDeliverVO(deliverVO);
	}

	public Boolean deleteDeliverVO(Long id) {
		return deliverService.deleteDeliverVOByID(id);
	}

	public Boolean createDeliverDetailVO(DeliverDetailVO deliverDetailVO) {
		deliverDetailVO.init();
		return deliverDetailService.addDeliverDetailVO(deliverDetailVO);
	}

	public Boolean batchCreateDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		for (DeliverDetailVO deliverDetailVO : deliverDetailVOs) {
			deliverDetailVO.init();
		}
		return deliverDetailService.batchAddDeliverDetailVO(deliverDetailVOs);
	}

	public List<DeliverDetailVO> queryDeliverDetailVOList(
			DeliverDetailQueryVO deliverDetailQueryVO) {
		return deliverDetailService
				.queryDeliverDetailVOList(deliverDetailQueryVO);
	}

	public List<DeliverDetailVO> getDeliverDetailVOListByDeliverID(
			Long deliverID) {
		return deliverDetailService.getDeliverDetailVOByDeliverID(deliverID);
	}

	public DeliverDetailVO getDeliverDetailVOByID(Long id) {
		return deliverDetailService.getDeliverDetailVOByID(id);
	}

	public Boolean modifyDeliverDetailVO(DeliverDetailVO deliverDetailVO) {
		deliverDetailVO.init();
		return deliverDetailService.modifyDeliverDetailVO(deliverDetailVO);
	}

	public Boolean batchModifyDeliverDetailVOs(
			List<DeliverDetailVO> deliverDetailVOs) {
		for (DeliverDetailVO deliverDetailVO : deliverDetailVOs) {
			deliverDetailVO.init();
		}
		return deliverDetailService
				.batchModifyDeliverDetailVO(deliverDetailVOs);
	}

	public Boolean deleteDeliverDetailVO(Long id) {
		return deliverDetailService.deleteDeliverDetailVOByID(id);
	}

	public Boolean deleteDeliverDetailVOByDeliverID(Long deliverID) {
		if (deliverID == null || deliverID <= 0) {
			throw new BizException("id error");
		}

		List<DeliverDetailVO> deliverDetailVOs = deliverDetailService
				.getDeliverDetailVOByDeliverID(deliverID);

		deliverDetailService.batchDeleteDeliverDetailVO(deliverDetailVOs);

		return true;
	}

	public Boolean batchDeleteDeliverDetailVOByDeliverID(
			List<Long> storyDetailIDs) {
		return deliverDetailService
				.batchDeleteDeliverDetailVOByID(storyDetailIDs);
	}

	private void initDetails(Long id, List<DeliverDetailVO> deliverDetailVOs) {
		for (int i = 0; i < deliverDetailVOs.size(); i++) {
			deliverDetailVOs.get(i).setDelivId(id);
			deliverDetailVOs.get(i).init();
		}
	}

	public IDeliverService getDeliverService() {
		return deliverService;
	}

	public void setDeliverService(IDeliverService deliverService) {
		this.deliverService = deliverService;
	}

	public IDeliverDetailService getDeliverDetailService() {
		return deliverDetailService;
	}

	public void setDeliverDetailService(
			IDeliverDetailService deliverDetailService) {
		this.deliverDetailService = deliverDetailService;
	}

	public Boolean submitDeliver(DeliverVO deliverVO) {
		deliverVO.setStatu(0);
		Long deliverID = deliverService.addDeliverVO(deliverVO);

		initDetails(deliverID, deliverVO.getDetails());
		deliverDetailService.batchAddDeliverDetailVO(deliverVO.getDetails());
		for (int i = 0; i < deliverVO.getDistributions().size(); i++) {
			((DeliverDistributionVO) deliverVO.getDistributions().get(i))
					.setDeliverId(deliverID);
			distributionService.packed(((DeliverDistributionVO) deliverVO
					.getDistributions().get(i)).getDistributionId());
			orderService.updateOrderStatus(
					distributionService.getDistributionVOByID(
							((DeliverDistributionVO) deliverVO
									.getDistributions().get(i))
									.getDistributionId()).getOrderId(), Short
							.parseShort("5"));
		}
		deliverDistributionService.batchAddDeliverDistributionVO(deliverVO
				.getDistributions());

		List<Long> boxIDs = new LinkedList<Long>();
		for (int i = 0; i < deliverVO.getDetails().size(); i++) {
			Long boxId = ((DeliverDetailVO) deliverVO.getDetails().get(i))
					.getBoxId();
			if (!boxIDs.contains(boxId)) {
				distributionBoxStatuService.assign(deliverID, boxId);
				boxIDs.add(boxId);
			}
		}
		waveService.packFinished(deliverVO.getWaveId());
		return true;
	}

	public IDeliverDistributionService getDeliverDistributionService() {
		return deliverDistributionService;
	}

	public void setDeliverDistributionService(
			IDeliverDistributionService deliverDistributionService) {
		this.deliverDistributionService = deliverDistributionService;
	}

	public IDistributionBoxStatuService getDistributionBoxStatuService() {
		return distributionBoxStatuService;
	}

	public void setDistributionBoxStatuService(
			IDistributionBoxStatuService distributionBoxStatuService) {
		this.distributionBoxStatuService = distributionBoxStatuService;
	}

	public DeliverVO assignDeliverVO(Long agencyID, Long operator) {
		DeliveryAreaQueryVO deliveryAreaQueryVO = new DeliveryAreaQueryVO();
		deliveryAreaQueryVO.setDeiliverierId(operator);
		List<DeliveryAreaVO> deliveryAreaVOs = deliveryAreaService
				.queryDeliveryAreaVOList(deliveryAreaQueryVO);
		if (deliveryAreaVOs == null || deliveryAreaVOs.isEmpty()) {
			throw new BizException(
					"delivery area is empty,please check config!");
		}
		DeliverQueryVO queryVO = new DeliverQueryVO();
		queryVO.setAgencyId(agencyID);
		queryVO.setStatu(0);
		queryVO.setAreaId(deliveryAreaVOs.get(0).getAreaId());
		List<DeliverVO> deliverVOs = deliverService.queryDeliverVOList(queryVO);
		for (int i = 0; i < deliverVOs.size(); i++) {
			deliverVOs.get(i).setOperator(operator);
			deliverVOs.get(i).setStatu(1);
			DeliverVO deliverVO = deliverService.assign(deliverVOs.get(i));
			if (deliverVO != null) {
				return deliverVO;
			}
		}
		return null;
	}

	public IWaveService getWaveService() {
		return waveService;
	}

	public void setWaveService(IWaveService waveService) {
		this.waveService = waveService;
	}

	public List<DeliverDistributionVO> getDeliverDistributionVOByDeliverID(
			Long deliverID) {
		DeliverDistributionQueryVO queryVO = new DeliverDistributionQueryVO();
		queryVO.setDeliverId(deliverID);
		return deliverDistributionService
				.queryDeliverDistributionVOList(queryVO);
	}

	public DistributionBoxVO getDistriButionBoxVOByBoxID(Long boxID) {
		return distributionBoxService.getDistributionBoxVOByID(boxID);
	}

	public IDistributionBoxService getDistributionBoxService() {
		return distributionBoxService;
	}

	public void setDistributionBoxService(
			IDistributionBoxService distributionBoxService) {
		this.distributionBoxService = distributionBoxService;
	}

	public Boolean releaseDistriButionBoxes(
			List<DistributionBoxStatuVO> distributionBoxes) {
		for (int i = 0; i < distributionBoxes.size(); i++) {
			distributionBoxStatuService.release(distributionBoxes.get(i));
		}
		return true;
	}

	public Boolean handOverDeliver(Long diliverID) {
		DeliverVO deliverVO = new DeliverVO();
		deliverVO.setStatu(2);
		deliverVO.setId(diliverID);
		modifyDeliverVO(deliverVO);
		List<DeliverDistributionVO> deliverDistributionVOs = deliverDistributionService
				.getDeliverDistributionVOByDeliverID(diliverID);
		for (DeliverDistributionVO deliverDistributionVO : deliverDistributionVOs) {
			orderService.updateOrderStatus(
					distributionService.getDistributionVOByID(
							deliverDistributionVO.getDistributionId())
							.getOrderId(), Short.parseShort("6"));
			distributionService.deilverStart(deliverDistributionVO
					.getDistributionId());
		}
		return true;
	}

	public Boolean deliverBoxReturn(DeliverVO deliverVO) {
		deliverVO.setStatu(3);
		modifyDeliverVO(deliverVO);
		batchModifyDeliverDetailVOs(deliverVO.getDetails());
		releaseDistriButionBoxes(deliverVO.getBoxes());
		return true;
	}

	public IDistributionService getDistributionService() {
		return distributionService;
	}

	public void setDistributionService(IDistributionService distributionService) {
		this.distributionService = distributionService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public IDeliveryAreaService getDeliveryAreaService() {
		return deliveryAreaService;
	}

	public void setDeliveryAreaService(IDeliveryAreaService deliveryAreaService) {
		this.deliveryAreaService = deliveryAreaService;
	}

	public List<DistributionVO> getDeliverDistributions(Long deliverID) {
		List<DistributionVO> distributionVOs = new LinkedList<DistributionVO>();
		List<DeliverDistributionVO> deliverDistributionVOs = deliverDistributionService
				.getDeliverDistributionVOByDeliverID(deliverID);
		for (DeliverDistributionVO deliverDistributionVO : deliverDistributionVOs) {
			distributionVOs.add(distributionService
					.getDistributionVOByID(deliverDistributionVO
							.getDistributionId()));
		}
		return distributionVOs;
	}
}

package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IDeliverDistributionManage;
import com.xianzaishi.wms.tmscore.service.itf.IDeliverDistributionService;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;

public class DeliverDistributionServiceImpl implements
		IDeliverDistributionService {
	@Autowired
	private IDeliverDistributionManage deliverDistributionManage = null;

	public IDeliverDistributionManage getDeliverDistributionManage() {
		return deliverDistributionManage;
	}

	public void setDeliverDistributionManage(
			IDeliverDistributionManage deliverDistributionManage) {
		this.deliverDistributionManage = deliverDistributionManage;
	}

	public Boolean addDeliverDistributionVO(
			DeliverDistributionVO deliverDistributionVO) {
		deliverDistributionManage
				.addDeliverDistributionVO(deliverDistributionVO);
		return true;
	}

	public List<DeliverDistributionVO> queryDeliverDistributionVOList(
			DeliverDistributionQueryVO deliverDistributionQueryVO) {
		return deliverDistributionManage
				.queryDeliverDistributionVOList(deliverDistributionQueryVO);
	}

	public DeliverDistributionVO getDeliverDistributionVOByID(Long id) {
		return (DeliverDistributionVO) deliverDistributionManage
				.getDeliverDistributionVOByID(id);
	}

	public Boolean modifyDeliverDistributionVO(
			DeliverDistributionVO deliverDistributionVO) {
		return deliverDistributionManage
				.modifyDeliverDistributionVO(deliverDistributionVO);
	}

	public Boolean deleteDeliverDistributionVOByID(Long id) {
		return deliverDistributionManage.deleteDeliverDistributionVOByID(id);
	}

	public List<DeliverDistributionVO> getDeliverDistributionVOByDeliverID(
			Long id) {
		return deliverDistributionManage
				.getDeliverDistributionVOByOutgoingID(id);
	}

	public Boolean batchAddDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs) {
		return deliverDistributionManage
				.batchAddDeliverDistributionVO(deliverDistributionVOs);
	}

	public Boolean batchModifyDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs) {
		return deliverDistributionManage
				.batchModifyDeliverDistributionVO(deliverDistributionVOs);
	}

	public Boolean batchDeleteDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs) {
		return deliverDistributionManage
				.batchDeleteDeliverDistributionVO(deliverDistributionVOs);
	}

	public Boolean batchDeleteDeliverDistributionVOByID(
			List<Long> deliverDistributionIDs) {
		return deliverDistributionManage
				.batchDeleteDeliverDistributionVOByID(deliverDistributionIDs);
	}
}

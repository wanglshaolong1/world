package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IDeliverDetailManage;
import com.xianzaishi.wms.tmscore.service.itf.IDeliverDetailService;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;

public class DeliverDetailServiceImpl implements IDeliverDetailService {
	@Autowired
	private IDeliverDetailManage deliverDetailManage = null;

	public IDeliverDetailManage getDeliverDetailManage() {
		return deliverDetailManage;
	}

	public void setDeliverDetailManage(IDeliverDetailManage deliverDetailManage) {
		this.deliverDetailManage = deliverDetailManage;
	}

	public Boolean addDeliverDetailVO(DeliverDetailVO deliverDetailVO) {
		deliverDetailManage.addDeliverDetailVO(deliverDetailVO);
		return true;
	}

	public List<DeliverDetailVO> queryDeliverDetailVOList(
			DeliverDetailQueryVO deliverDetailQueryVO) {
		return deliverDetailManage
				.queryDeliverDetailVOList(deliverDetailQueryVO);
	}

	public DeliverDetailVO getDeliverDetailVOByID(Long id) {
		return (DeliverDetailVO) deliverDetailManage.getDeliverDetailVOByID(id);
	}

	public Boolean modifyDeliverDetailVO(DeliverDetailVO deliverDetailVO) {
		return deliverDetailManage.modifyDeliverDetailVO(deliverDetailVO);
	}

	public Boolean deleteDeliverDetailVOByID(Long id) {
		return deliverDetailManage.deleteDeliverDetailVOByID(id);
	}

	public List<DeliverDetailVO> getDeliverDetailVOByDeliverID(Long id) {
		return deliverDetailManage.getDeliverDetailVOByOutgoingID(id);
	}

	public Boolean batchAddDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		return deliverDetailManage.batchAddDeliverDetailVO(deliverDetailVOs);
	}

	public Boolean batchModifyDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		return deliverDetailManage.batchModifyDeliverDetailVO(deliverDetailVOs);
	}

	public Boolean batchDeleteDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		return deliverDetailManage.batchDeleteDeliverDetailVO(deliverDetailVOs);
	}

	public Boolean batchDeleteDeliverDetailVOByID(List<Long> storyDetailIDs) {
		return deliverDetailManage
				.batchDeleteDeliverDetailVOByID(storyDetailIDs);
	}

}

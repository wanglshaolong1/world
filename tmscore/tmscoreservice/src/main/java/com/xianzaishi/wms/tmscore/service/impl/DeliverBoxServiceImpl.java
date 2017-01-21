package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IDeliverBoxManage;
import com.xianzaishi.wms.tmscore.service.itf.IDeliverBoxService;
import com.xianzaishi.wms.tmscore.vo.DeliverBoxQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverBoxVO;

public class DeliverBoxServiceImpl implements IDeliverBoxService {
	@Autowired
	private IDeliverBoxManage deliverBoxManage = null;

	public IDeliverBoxManage getDeliverBoxManage() {
		return deliverBoxManage;
	}

	public void setDeliverBoxManage(IDeliverBoxManage deliverBoxManage) {
		this.deliverBoxManage = deliverBoxManage;
	}

	public Boolean addDeliverBoxVO(DeliverBoxVO deliverBoxVO) {
		deliverBoxManage.addDeliverBoxVO(deliverBoxVO);
		return true;
	}

	public List<DeliverBoxVO> queryDeliverBoxVOList(
			DeliverBoxQueryVO deliverBoxQueryVO) {
		return deliverBoxManage.queryDeliverBoxVOList(deliverBoxQueryVO);
	}

	public DeliverBoxVO getDeliverBoxVOByID(Long id) {
		return (DeliverBoxVO) deliverBoxManage.getDeliverBoxVOByID(id);
	}

	public Boolean modifyDeliverBoxVO(DeliverBoxVO deliverBoxVO) {
		return deliverBoxManage.modifyDeliverBoxVO(deliverBoxVO);
	}

	public Boolean deleteDeliverBoxVOByID(Long id) {
		return deliverBoxManage.deleteDeliverBoxVOByID(id);
	}

	public List<DeliverBoxVO> getDeliverBoxVOByOutgoingID(Long id) {
		return deliverBoxManage.getDeliverBoxVOByOutgoingID(id);
	}

	public Boolean batchAddDeliverBoxVO(List<DeliverBoxVO> deliverBoxVOs) {
		return deliverBoxManage.batchAddDeliverBoxVO(deliverBoxVOs);
	}

	public Boolean batchModifyDeliverBoxVO(List<DeliverBoxVO> deliverBoxVOs) {
		return deliverBoxManage.batchModifyDeliverBoxVO(deliverBoxVOs);
	}

	public Boolean batchDeleteDeliverBoxVO(List<DeliverBoxVO> deliverBoxVOs) {
		return deliverBoxManage.batchDeleteDeliverBoxVO(deliverBoxVOs);
	}

	public Boolean batchDeleteDeliverBoxVOByID(List<Long> storyDetailIDs) {
		return deliverBoxManage.batchDeleteDeliverBoxVOByID(storyDetailIDs);
	}
}

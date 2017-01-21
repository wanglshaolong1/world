package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IDeliverManage;
import com.xianzaishi.wms.tmscore.service.itf.IDeliverService;
import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;

public class DeliverServiceImpl implements IDeliverService {
	@Autowired
	private IDeliverManage deliverManage = null;

	public IDeliverManage getDeliverManage() {
		return deliverManage;
	}

	public void setDeliverManage(IDeliverManage deliverManage) {
		this.deliverManage = deliverManage;
	}

	public Long addDeliverVO(DeliverVO deliverVO) {
		return deliverManage.addDeliverVO(deliverVO);
	}

	public List<DeliverVO> queryDeliverVOList(DeliverQueryVO deliverQueryVO) {
		return deliverManage.queryDeliverVOList(deliverQueryVO);
	}

	public DeliverVO getDeliverVOByID(Long id) {
		return (DeliverVO) deliverManage.getDeliverVOByID(id);
	}

	public Boolean modifyDeliverVO(DeliverVO deliverVO) {
		return deliverManage.modifyDeliverVO(deliverVO);
	}

	public Boolean deleteDeliverVOByID(Long id) {
		return deliverManage.deleteDeliverVOByID(id);
	}

	public DeliverVO assign(DeliverVO deliverVO) {
		return deliverManage.assign(deliverVO);
	}
}

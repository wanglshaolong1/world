package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DeliveryAreaVO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IDeliveryAreaService;
import com.xianzaishi.wms.tmscore.manage.itf.IDeliveryAreaManage;

public class DeliveryAreaServiceImpl implements IDeliveryAreaService {
	@Autowired
	private IDeliveryAreaManage deliveryAreaManage = null;

	public IDeliveryAreaManage getDeliveryAreaManage() {
		return deliveryAreaManage;
	}

	public void setDeliveryAreaManage(IDeliveryAreaManage deliveryAreaManage) {
		this.deliveryAreaManage = deliveryAreaManage;
	}
	
	public Boolean addDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO) {
		deliveryAreaManage.addDeliveryAreaVO(deliveryAreaVO);
		return true;
	}

	public List<DeliveryAreaVO> queryDeliveryAreaVOList(DeliveryAreaQueryVO deliveryAreaQueryVO) {
		return deliveryAreaManage.queryDeliveryAreaVOList(deliveryAreaQueryVO);
	}

	public DeliveryAreaVO getDeliveryAreaVOByID(Long id) {
		return (DeliveryAreaVO) deliveryAreaManage.getDeliveryAreaVOByID(id);
	}

	public Boolean modifyDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO) {
		return deliveryAreaManage.modifyDeliveryAreaVO(deliveryAreaVO);
	}

	public Boolean deleteDeliveryAreaVOByID(Long id) {
		return deliveryAreaManage.deleteDeliveryAreaVOByID(id);
	}
}

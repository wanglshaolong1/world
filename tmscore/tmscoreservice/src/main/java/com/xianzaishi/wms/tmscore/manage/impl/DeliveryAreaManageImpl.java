package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DeliveryAreaVO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaDO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.manage.itf.IDeliveryAreaManage;

import com.xianzaishi.wms.tmscore.dao.itf.IDeliveryAreaDao;

public class DeliveryAreaManageImpl implements IDeliveryAreaManage {
	@Autowired
	private IDeliveryAreaDao deliveryAreaDao = null;

	private void validate(DeliveryAreaDO deliveryAreaDO) {
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}
	
	public IDeliveryAreaDao getDeliveryAreaDao() {
		return deliveryAreaDao;
	}

	public void setDeliveryAreaDao(IDeliveryAreaDao deliveryAreaDao) {
		this.deliveryAreaDao = deliveryAreaDao;
	}
	
	public Boolean addDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO) {
		deliveryAreaDao.addDO(deliveryAreaVO);
		return true;
	}

	public List<DeliveryAreaVO> queryDeliveryAreaVOList(DeliveryAreaQueryVO deliveryAreaQueryVO) {
		return deliveryAreaDao.queryDO(deliveryAreaQueryVO);
	}

	public DeliveryAreaVO getDeliveryAreaVOByID(Long id) {
		return (DeliveryAreaVO) deliveryAreaDao.getDOByID(id);
	}

	public Boolean modifyDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO) {
		return deliveryAreaDao.updateDO(deliveryAreaVO);
	}

	public Boolean deleteDeliveryAreaVOByID(Long id) {
		return deliveryAreaDao.delDO(id);
	}
}

package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDeliverDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDeliverManage;
import com.xianzaishi.wms.tmscore.vo.DeliverDO;
import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;

public class DeliverManageImpl implements IDeliverManage {
	@Autowired
	private IDeliverDao deliverDao = null;

	private void validate(DeliverVO deliverVO) {
		if (deliverVO.getAgencyId() == null || deliverVO.getAgencyId() <= 0) {
			throw new BizException("agencyID error：" + deliverVO.getAgencyId());
		}
		if (deliverVO.getAreaId() == null || deliverVO.getAreaId() <= 0) {
			throw new BizException("areaID error：" + deliverVO.getAreaId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDeliverDao getDeliverDao() {
		return deliverDao;
	}

	public void setDeliverDao(IDeliverDao deliverDao) {
		this.deliverDao = deliverDao;
	}

	public Long addDeliverVO(DeliverVO deliverVO) {
		validate(deliverVO);
		return (Long) deliverDao.addDO(deliverVO);
	}

	public List<DeliverVO> queryDeliverVOList(DeliverQueryVO deliverQueryVO) {
		return deliverDao.queryDO(deliverQueryVO);
	}

	public DeliverVO getDeliverVOByID(Long id) {
		return (DeliverVO) deliverDao.getDOByID(id);
	}

	public Boolean modifyDeliverVO(DeliverVO deliverVO) {
		return deliverDao.updateDO(deliverVO);
	}

	public Boolean deleteDeliverVOByID(Long id) {
		return deliverDao.delDO(id);
	}

	public DeliverVO assign(DeliverVO deliverVO) {
		return deliverDao.assign(deliverVO);
	}
}

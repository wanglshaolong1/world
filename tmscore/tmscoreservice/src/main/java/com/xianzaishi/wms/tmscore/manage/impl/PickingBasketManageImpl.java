package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickingBasketDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingBasketManage;
import com.xianzaishi.wms.tmscore.vo.PickingBasketQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public class PickingBasketManageImpl implements IPickingBasketManage {
	@Autowired
	private IPickingBasketDao pickingBasketDao = null;

	private void validate(PickingBasketVO pickingBasketVO) {
		if (pickingBasketVO.getAgencyId() == null
				|| pickingBasketVO.getAgencyId() <= 0) {
			throw new BizException("agencyID error："
					+ pickingBasketVO.getAgencyId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickingBasketDao getPickingBasketDao() {
		return pickingBasketDao;
	}

	public void setPickingBasketDao(IPickingBasketDao pickingBasketDao) {
		this.pickingBasketDao = pickingBasketDao;
	}

	public Boolean addPickingBasketVO(PickingBasketVO pickingBasketVO) {
		pickingBasketDao.addDO(pickingBasketVO);
		return true;
	}

	public List<PickingBasketVO> queryPickingBasketVOList(
			PickingBasketQueryVO pickingBasketQueryVO) {
		return pickingBasketDao.queryDO(pickingBasketQueryVO);
	}

	public PickingBasketVO getPickingBasketVOByID(Long id) {
		return (PickingBasketVO) pickingBasketDao.getDOByID(id);
	}

	public Boolean modifyPickingBasketVO(PickingBasketVO pickingBasketVO) {
		return pickingBasketDao.updateDO(pickingBasketVO);
	}

	public Boolean deletePickingBasketVOByID(Long id) {
		return pickingBasketDao.delDO(id);
	}
}

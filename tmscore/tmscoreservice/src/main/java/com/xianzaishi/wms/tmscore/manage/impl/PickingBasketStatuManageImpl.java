package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickingBasketStatuDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingBasketStatuManage;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuVO;

public class PickingBasketStatuManageImpl implements IPickingBasketStatuManage {
	@Autowired
	private IPickingBasketStatuDao pickingBasketStatuDao = null;

	private void validate(PickingBasketStatuVO pickingBasketStatuVO) {
		if (pickingBasketStatuVO.getBasketId() == null
				|| pickingBasketStatuVO.getBasketId() <= 0) {
			throw new BizException("basketID error："
					+ pickingBasketStatuVO.getBasketId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickingBasketStatuDao getPickingBasketStatuDao() {
		return pickingBasketStatuDao;
	}

	public void setPickingBasketStatuDao(
			IPickingBasketStatuDao pickingBasketStatuDao) {
		this.pickingBasketStatuDao = pickingBasketStatuDao;
	}

	public Boolean addPickingBasketStatuVO(
			PickingBasketStatuVO pickingBasketStatuVO) {
		validate(pickingBasketStatuVO);
		pickingBasketStatuDao.addDO(pickingBasketStatuVO);
		return true;
	}

	public List<PickingBasketStatuVO> queryPickingBasketStatuVOList(
			PickingBasketStatuQueryVO pickingBasketStatuQueryVO) {
		return pickingBasketStatuDao.queryDO(pickingBasketStatuQueryVO);
	}

	public PickingBasketStatuVO getPickingBasketStatuVOByID(Long id) {
		return (PickingBasketStatuVO) pickingBasketStatuDao.getDOByID(id);
	}

	public Boolean modifyPickingBasketStatuVO(
			PickingBasketStatuVO pickingBasketStatuVO) {
		return pickingBasketStatuDao.updateDO(pickingBasketStatuVO);
	}

	public Boolean deletePickingBasketStatuVOByID(Long id) {
		return pickingBasketStatuDao.delDO(id);
	}

	public void assign(Long pickID, List<Long> basketIDs) {
		pickingBasketStatuDao.assign(pickID, basketIDs);
	}
}

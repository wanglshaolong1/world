package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickingWallDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingWallManage;
import com.xianzaishi.wms.tmscore.vo.PickingWallQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallVO;

public class PickingWallManageImpl implements IPickingWallManage {
	@Autowired
	private IPickingWallDao pickingWallDao = null;

	private void validate(PickingWallVO pickingWallVO) {
		if (pickingWallVO.getAgencyId() == null
				|| pickingWallVO.getAgencyId() <= 0) {
			throw new BizException("agencyID error："
					+ pickingWallVO.getAgencyId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickingWallDao getPickingWallDao() {
		return pickingWallDao;
	}

	public void setPickingWallDao(IPickingWallDao pickingWallDao) {
		this.pickingWallDao = pickingWallDao;
	}

	public Boolean addPickingWallVO(PickingWallVO pickingWallVO) {
		validate(pickingWallVO);
		pickingWallDao.addDO(pickingWallVO);
		return true;
	}

	public List<PickingWallVO> queryPickingWallVOList(
			PickingWallQueryVO pickingWallQueryVO) {
		return pickingWallDao.queryDO(pickingWallQueryVO);
	}

	public PickingWallVO getPickingWallVOByID(Long id) {
		return (PickingWallVO) pickingWallDao.getDOByID(id);
	}

	public Boolean modifyPickingWallVO(PickingWallVO pickingWallVO) {
		return pickingWallDao.updateDO(pickingWallVO);
	}

	public Boolean deletePickingWallVOByID(Long id) {
		return pickingWallDao.delDO(id);
	}
}

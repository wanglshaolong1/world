package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickingWallPositionStatuDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingWallPositionStatuManage;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuVO;

public class PickingWallPositionStatuManageImpl implements
		IPickingWallPositionStatuManage {
	@Autowired
	private IPickingWallPositionStatuDao pickingWallPositionStatuDao = null;

	private void validate(PickingWallPositionStatuVO pickingWallPositionStatuVO) {
		if (pickingWallPositionStatuVO.getWallPositionId() == null
				|| pickingWallPositionStatuVO.getWallPositionId() <= 0) {
			throw new BizException("wallPositionID error："
					+ pickingWallPositionStatuVO.getWallPositionId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickingWallPositionStatuDao getPickingWallPositionStatuDao() {
		return pickingWallPositionStatuDao;
	}

	public void setPickingWallPositionStatuDao(
			IPickingWallPositionStatuDao pickingWallPositionStatuDao) {
		this.pickingWallPositionStatuDao = pickingWallPositionStatuDao;
	}

	public Boolean addPickingWallPositionStatuVO(
			PickingWallPositionStatuVO pickingWallPositionStatuVO) {
		validate(pickingWallPositionStatuVO);
		pickingWallPositionStatuDao.addDO(pickingWallPositionStatuVO);
		return true;
	}

	public List<PickingWallPositionStatuVO> queryPickingWallPositionStatuVOList(
			PickingWallPositionStatuQueryVO pickingWallPositionStatuQueryVO) {
		return pickingWallPositionStatuDao
				.queryDO(pickingWallPositionStatuQueryVO);
	}

	public PickingWallPositionStatuVO getPickingWallPositionStatuVOByID(Long id) {
		return (PickingWallPositionStatuVO) pickingWallPositionStatuDao
				.getDOByID(id);
	}

	public Boolean modifyPickingWallPositionStatuVO(
			PickingWallPositionStatuVO pickingWallPositionStatuVO) {
		return pickingWallPositionStatuDao.updateDO(pickingWallPositionStatuVO);
	}

	public Boolean deletePickingWallPositionStatuVOByID(Long id) {
		return pickingWallPositionStatuDao.delDO(id);
	}

	public void assign(Long waveID, Long positionID) {
		pickingWallPositionStatuDao.assign(waveID, positionID);
	}
}

package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickingWallPositionDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingWallPositionManage;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;

public class PickingWallPositionManageImpl implements
		IPickingWallPositionManage {
	@Autowired
	private IPickingWallPositionDao pickingWallPositionDao = null;

	private void validate(PickingWallPositionVO pickingWallPositionVO) {
		if (pickingWallPositionVO.getBarcode() == null
				|| pickingWallPositionVO.getBarcode().isEmpty()) {
			throw new BizException("barcode error："
					+ pickingWallPositionVO.getBarcode().isEmpty());
		}
		if (pickingWallPositionVO.getCode() == null
				|| pickingWallPositionVO.getCode().isEmpty()) {
			throw new BizException("code error："
					+ pickingWallPositionVO.getCode());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickingWallPositionDao getPickingWallPositionDao() {
		return pickingWallPositionDao;
	}

	public void setPickingWallPositionDao(
			IPickingWallPositionDao pickingWallPositionDao) {
		this.pickingWallPositionDao = pickingWallPositionDao;
	}

	public Boolean addPickingWallPositionVO(
			PickingWallPositionVO pickingWallPositionVO) {
		validate(pickingWallPositionVO);
		pickingWallPositionDao.addDO(pickingWallPositionVO);
		return true;
	}

	public List<PickingWallPositionVO> queryPickingWallPositionVOList(
			PickingWallPositionQueryVO pickingWallPositionQueryVO) {
		return pickingWallPositionDao.queryDO(pickingWallPositionQueryVO);
	}

	public PickingWallPositionVO getPickingWallPositionVOByID(Long id) {
		return (PickingWallPositionVO) pickingWallPositionDao.getDOByID(id);
	}

	public Boolean modifyPickingWallPositionVO(
			PickingWallPositionVO pickingWallPositionVO) {
		return pickingWallPositionDao.updateDO(pickingWallPositionVO);
	}

	public Boolean deletePickingWallPositionVOByID(Long id) {
		return pickingWallPositionDao.delDO(id);
	}
}

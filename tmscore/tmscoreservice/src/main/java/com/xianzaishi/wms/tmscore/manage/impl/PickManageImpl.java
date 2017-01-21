package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickDao;
import com.xianzaishi.wms.tmscore.manage.itf.IPickManage;
import com.xianzaishi.wms.tmscore.vo.PickDO;
import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;

public class PickManageImpl implements IPickManage {
	@Autowired
	private IPickDao pickDao = null;

	private void validate(PickVO pickVO) {
		if (pickVO.getAgencyId() == null || pickVO.getAgencyId() <= 0) {
			throw new BizException("agencyID error：" + pickVO.getAgencyId());
		}
		if (pickVO.getAreaId() == null || pickVO.getAreaId() <= 0) {
			throw new BizException("area error：" + pickVO.getAreaId());
		}
		if (pickVO.getWaveId() == null || pickVO.getWaveId() <= 0) {
			throw new BizException("waveID error：" + pickVO.getWaveId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IPickDao getPickDao() {
		return pickDao;
	}

	public void setPickDao(IPickDao pickDao) {
		this.pickDao = pickDao;
	}

	public Long addPickVO(PickVO pickVO) {
		validate(pickVO);
		return (Long) pickDao.addDO(pickVO);
	}

	public List<PickVO> queryPickVOList(PickQueryVO pickQueryVO) {
		return pickDao.queryDO(pickQueryVO);
	}

	public PickVO getPickVOByID(Long id) {
		return (PickVO) pickDao.getDOByID(id);
	}

	public Boolean modifyPickVO(PickVO pickVO) {
		return pickDao.updateDO(pickVO);
	}

	public Boolean deletePickVOByID(Long id) {
		return pickDao.delDO(id);
	}

	public PickVO assign(PickVO pickVO) {
		return pickDao.assign(pickVO);
	}
}

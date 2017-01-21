package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IWaveDao;
import com.xianzaishi.wms.tmscore.manage.itf.IWaveManage;
import com.xianzaishi.wms.tmscore.vo.WaveDO;
import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public class WaveManageImpl implements IWaveManage {
	@Autowired
	private IWaveDao waveDao = null;

	private void validate(WaveVO waveVO) {
		if (waveVO.getAgencyId() == null || waveVO.getAgencyId() <= 0) {
			throw new BizException("agencyID error：" + waveVO.getAgencyId());
		}
		if (waveVO.getAreaId() == null || waveVO.getAreaId() <= 0) {
			throw new BizException("areaID error：" + waveVO.getAreaId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IWaveDao getWaveDao() {
		return waveDao;
	}

	public void setWaveDao(IWaveDao waveDao) {
		this.waveDao = waveDao;
	}

	public Long addWaveVO(WaveVO waveVO) {
		validate(waveVO);
		return (Long) waveDao.addDO(waveVO);
	}

	public List<WaveVO> queryWaveVOList(WaveQueryVO waveQueryVO) {
		return waveDao.queryDO(waveQueryVO);
	}

	public WaveVO getWaveVOByID(Long id) {
		return (WaveVO) waveDao.getDOByID(id);
	}

	public Boolean modifyWaveVO(WaveVO waveVO) {
		return waveDao.updateDO(waveVO);
	}

	public Boolean deleteWaveVOByID(Long id) {
		return waveDao.delDO(id);
	}

	public WaveVO assign(WaveVO waveVO) {
		return waveDao.assign(waveVO);
	}

	public Boolean releaseWaveTask(Long waveID) {
		return waveDao.releaseWaveTask(waveID);
	}
}

package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IWavePoolDao;
import com.xianzaishi.wms.tmscore.manage.itf.IWavePoolManage;
import com.xianzaishi.wms.tmscore.vo.WavePoolQueryVO;
import com.xianzaishi.wms.tmscore.vo.WavePoolVO;

public class WavePoolManageImpl implements IWavePoolManage {
	@Autowired
	private IWavePoolDao wavePoolDao = null;

	private void validate(WavePoolVO wavePoolVO) {
		if (wavePoolVO.getKey() == null || wavePoolVO.getKey().isEmpty()) {
			throw new BizException("key error：" + wavePoolVO.getKey());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IWavePoolDao getWavePoolDao() {
		return wavePoolDao;
	}

	public void setWavePoolDao(IWavePoolDao wavePoolDao) {
		this.wavePoolDao = wavePoolDao;
	}

	public Long addWavePoolVO(WavePoolVO wavePoolVO) {
		validate(wavePoolVO);
		return (Long) wavePoolDao.addDO(wavePoolVO);
	}

	public List<WavePoolVO> queryWavePoolVOList(WavePoolQueryVO wavePoolQueryVO) {
		return wavePoolDao.queryDO(wavePoolQueryVO);
	}

	public WavePoolVO getWavePoolVOByID(Long id) {
		return (WavePoolVO) wavePoolDao.getDOByID(id);
	}

	public Boolean modifyWavePoolVO(WavePoolVO wavePoolVO) {
		return wavePoolDao.updateDO(wavePoolVO);
	}

	public Boolean deleteWavePoolVOByID(Long id) {
		return wavePoolDao.delDO(id);
	}
}

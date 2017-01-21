package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.WavePoolVO;
import com.xianzaishi.wms.tmscore.vo.WavePoolQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IWavePoolService;
import com.xianzaishi.wms.tmscore.manage.itf.IWavePoolManage;

public class WavePoolServiceImpl implements IWavePoolService {
	@Autowired
	private IWavePoolManage wavePoolManage = null;

	public IWavePoolManage getWavePoolManage() {
		return wavePoolManage;
	}

	public void setWavePoolManage(IWavePoolManage wavePoolManage) {
		this.wavePoolManage = wavePoolManage;
	}

	public Long addWavePoolVO(WavePoolVO wavePoolVO) {
		return wavePoolManage.addWavePoolVO(wavePoolVO);
	}

	public List<WavePoolVO> queryWavePoolVOList(WavePoolQueryVO wavePoolQueryVO) {
		return wavePoolManage.queryWavePoolVOList(wavePoolQueryVO);
	}

	public WavePoolVO getWavePoolVOByID(Long id) {
		return (WavePoolVO) wavePoolManage.getWavePoolVOByID(id);
	}

	public Boolean modifyWavePoolVO(WavePoolVO wavePoolVO) {
		return wavePoolManage.modifyWavePoolVO(wavePoolVO);
	}

	public Boolean deleteWavePoolVOByID(Long id) {
		return wavePoolManage.deleteWavePoolVOByID(id);
	}
}

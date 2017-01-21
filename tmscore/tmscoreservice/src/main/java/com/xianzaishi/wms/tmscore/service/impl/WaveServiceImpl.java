package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IWaveManage;
import com.xianzaishi.wms.tmscore.service.itf.IWaveService;
import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public class WaveServiceImpl implements IWaveService {
	@Autowired
	private IWaveManage waveManage = null;

	public IWaveManage getWaveManage() {
		return waveManage;
	}

	public void setWaveManage(IWaveManage waveManage) {
		this.waveManage = waveManage;
	}

	public Long addWaveVO(WaveVO waveVO) {
		return waveManage.addWaveVO(waveVO);
	}

	public List<WaveVO> queryWaveVOList(WaveQueryVO waveQueryVO) {
		return waveManage.queryWaveVOList(waveQueryVO);
	}

	public WaveVO getWaveVOByID(Long id) {
		return (WaveVO) waveManage.getWaveVOByID(id);
	}

	public Boolean modifyWaveVO(WaveVO waveVO) {
		return waveManage.modifyWaveVO(waveVO);
	}

	public Boolean deleteWaveVOByID(Long id) {
		return waveManage.deleteWaveVOByID(id);
	}

	public Boolean waveFinished(Long waveID) {
		WaveVO waveVO = new WaveVO();
		waveVO.setId(waveID);
		waveVO.setStatu(1);
		waveManage.modifyWaveVO(waveVO);
		return true;
	}

	public WaveVO assign(WaveVO waveVO) {
		return waveManage.assign(waveVO);
	}

	public void packFinished(Long id) {
		WaveVO waveVO = new WaveVO();
		waveVO.setId(id);
		waveVO.setStatu(3);
		waveManage.modifyWaveVO(waveVO);
	}

	public Boolean releaseWaveTask(Long waveID) {
		return waveManage.releaseWaveTask(waveID);
	}
}

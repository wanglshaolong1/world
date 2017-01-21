package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IWavePoolDetailManage;
import com.xianzaishi.wms.tmscore.service.itf.IWavePoolDetailService;
import com.xianzaishi.wms.tmscore.vo.WavePoolDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WavePoolDetailVO;

public class WavePoolDetailServiceImpl implements IWavePoolDetailService {
	@Autowired
	private IWavePoolDetailManage wavePoolDetailManage = null;

	public IWavePoolDetailManage getWavePoolDetailManage() {
		return wavePoolDetailManage;
	}

	public void setWavePoolDetailManage(
			IWavePoolDetailManage wavePoolDetailManage) {
		this.wavePoolDetailManage = wavePoolDetailManage;
	}

	public Boolean addWavePoolDetailVO(WavePoolDetailVO wavePoolDetailVO) {
		wavePoolDetailManage.addWavePoolDetailVO(wavePoolDetailVO);
		return true;
	}

	public List<WavePoolDetailVO> queryWavePoolDetailVOList(
			WavePoolDetailQueryVO wavePoolDetailQueryVO) {
		return wavePoolDetailManage
				.queryWavePoolDetailVOList(wavePoolDetailQueryVO);
	}

	public WavePoolDetailVO getWavePoolDetailVOByID(Long id) {
		return (WavePoolDetailVO) wavePoolDetailManage
				.getWavePoolDetailVOByID(id);
	}

	public Boolean modifyWavePoolDetailVO(WavePoolDetailVO wavePoolDetailVO) {
		return wavePoolDetailManage.modifyWavePoolDetailVO(wavePoolDetailVO);
	}

	public Boolean deleteWavePoolDetailVOByID(Long id) {
		return wavePoolDetailManage.deleteWavePoolDetailVOByID(id);
	}

	public List<WavePoolDetailVO> getWavePoolDetailVOByWaveID(Long id) {
		return wavePoolDetailManage.getWavePoolDetailVOByOutgoingID(id);
	}

	public Boolean batchAddWavePoolDetailVO(
			List<WavePoolDetailVO> wavePoolDetailVOs) {
		return wavePoolDetailManage.batchAddWavePoolDetailVO(wavePoolDetailVOs);
	}

	public Boolean batchModifyWavePoolDetailVO(
			List<WavePoolDetailVO> wavePoolDetailVOs) {
		return wavePoolDetailManage
				.batchModifyWavePoolDetailVO(wavePoolDetailVOs);
	}

	public Boolean batchDeleteWavePoolDetailVO(
			List<WavePoolDetailVO> wavePoolDetailVOs) {
		return wavePoolDetailManage
				.batchDeleteWavePoolDetailVO(wavePoolDetailVOs);
	}

	public Boolean batchDeleteWavePoolDetailVOByID(List<Long> storyDetailIDs) {
		return wavePoolDetailManage
				.batchDeleteWavePoolDetailVOByID(storyDetailIDs);
	}
}

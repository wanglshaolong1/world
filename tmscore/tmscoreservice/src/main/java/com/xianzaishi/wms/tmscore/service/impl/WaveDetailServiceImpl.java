package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IWaveDetailManage;
import com.xianzaishi.wms.tmscore.service.itf.IWaveDetailService;
import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;

public class WaveDetailServiceImpl implements IWaveDetailService {
	@Autowired
	private IWaveDetailManage waveDetailManage = null;

	public IWaveDetailManage getWaveDetailManage() {
		return waveDetailManage;
	}

	public void setWaveDetailManage(IWaveDetailManage waveDetailManage) {
		this.waveDetailManage = waveDetailManage;
	}

	public Boolean addWaveDetailVO(WaveDetailVO waveDetailVO) {
		waveDetailManage.addWaveDetailVO(waveDetailVO);
		return true;
	}

	public List<WaveDetailVO> queryWaveDetailVOList(
			WaveDetailQueryVO waveDetailQueryVO) {
		return waveDetailManage.queryWaveDetailVOList(waveDetailQueryVO);
	}

	public WaveDetailVO getWaveDetailVOByID(Long id) {
		return (WaveDetailVO) waveDetailManage.getWaveDetailVOByID(id);
	}

	public Boolean modifyWaveDetailVO(WaveDetailVO waveDetailVO) {
		return waveDetailManage.modifyWaveDetailVO(waveDetailVO);
	}

	public Boolean deleteWaveDetailVOByID(Long id) {
		return waveDetailManage.deleteWaveDetailVOByID(id);
	}

	public List<WaveDetailVO> getWaveDetailVOByWaveID(Long id) {
		return waveDetailManage.getWaveDetailVOByOutgoingID(id);
	}

	public Boolean batchAddWaveDetailVO(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailManage.batchAddWaveDetailVO(waveDetailVOs);
	}

	public Boolean batchModifyWaveDetailVO(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailManage.batchModifyWaveDetailVO(waveDetailVOs);
	}

	public Boolean batchDeleteWaveDetailVO(List<WaveDetailVO> waveDetailVOs) {
		return waveDetailManage.batchDeleteWaveDetailVO(waveDetailVOs);
	}

	public Boolean batchDeleteWaveDetailVOByID(List<Long> storyDetailIDs) {
		return waveDetailManage.batchDeleteWaveDetailVOByID(storyDetailIDs);
	}
}

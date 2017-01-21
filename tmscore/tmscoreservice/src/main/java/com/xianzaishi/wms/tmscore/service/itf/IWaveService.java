package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public interface IWaveService {

	public Long addWaveVO(WaveVO waveVO);

	public List<WaveVO> queryWaveVOList(WaveQueryVO waveQueryVO);

	public WaveVO getWaveVOByID(Long id);

	public Boolean modifyWaveVO(WaveVO waveVO);

	public Boolean deleteWaveVOByID(Long id);

	public Boolean waveFinished(Long waveID);

	public WaveVO assign(WaveVO waveVO);

	public void packFinished(Long id);

	public Boolean releaseWaveTask(Long waveID);

}
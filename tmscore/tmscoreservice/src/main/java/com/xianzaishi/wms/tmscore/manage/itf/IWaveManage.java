package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public interface IWaveManage {

	public Long addWaveVO(WaveVO waveVO);

	public List<WaveVO> queryWaveVOList(WaveQueryVO waveQueryVO);

	public WaveVO getWaveVOByID(Long id);

	public Boolean modifyWaveVO(WaveVO waveVO);

	public Boolean deleteWaveVOByID(Long id);

	public WaveVO assign(WaveVO waveVO);

	public Boolean releaseWaveTask(Long waveID);

}
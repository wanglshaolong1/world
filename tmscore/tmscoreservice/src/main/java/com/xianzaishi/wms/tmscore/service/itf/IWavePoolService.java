package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.WavePoolVO;
import com.xianzaishi.wms.tmscore.vo.WavePoolQueryVO;

public interface IWavePoolService {

	public Long addWavePoolVO(WavePoolVO wavePoolVO);

	public List<WavePoolVO> queryWavePoolVOList(WavePoolQueryVO wavePoolQueryVO);

	public WavePoolVO getWavePoolVOByID(Long id);

	public Boolean modifyWavePoolVO(WavePoolVO wavePoolVO);

	public Boolean deleteWavePoolVOByID(Long id);

}
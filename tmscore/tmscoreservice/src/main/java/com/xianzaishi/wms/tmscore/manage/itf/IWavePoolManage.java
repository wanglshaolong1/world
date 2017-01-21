package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.WavePoolQueryVO;
import com.xianzaishi.wms.tmscore.vo.WavePoolVO;

public interface IWavePoolManage {

	public Long addWavePoolVO(WavePoolVO wavePoolVO);

	public List<WavePoolVO> queryWavePoolVOList(WavePoolQueryVO wavePoolQueryVO);

	public WavePoolVO getWavePoolVOByID(Long id);

	public Boolean modifyWavePoolVO(WavePoolVO wavePoolVO);

	public Boolean deleteWavePoolVOByID(Long id);

}
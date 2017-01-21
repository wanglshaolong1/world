package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;

public interface IWaveDetailService {

	public Boolean addWaveDetailVO(WaveDetailVO waveDetailVO);

	public List<WaveDetailVO> queryWaveDetailVOList(
			WaveDetailQueryVO waveDetailQueryVO);

	public WaveDetailVO getWaveDetailVOByID(Long id);

	public Boolean modifyWaveDetailVO(WaveDetailVO waveDetailVO);

	public Boolean deleteWaveDetailVOByID(Long id);

	public List<WaveDetailVO> getWaveDetailVOByWaveID(Long id);

	public Boolean batchAddWaveDetailVO(List<WaveDetailVO> waveDetailVOs);

	public Boolean batchModifyWaveDetailVO(List<WaveDetailVO> waveDetailVOs);

	public Boolean batchDeleteWaveDetailVO(List<WaveDetailVO> waveDetailVOs);

	public Boolean batchDeleteWaveDetailVOByID(List<Long> storyDetailIDs);

}
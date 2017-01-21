package com.xianzaishi.wms.tmscore.domain.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;
import com.xianzaishi.wms.tmscore.vo.WavePoolVO;
import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public interface IWaveDomainService {

	// domain
	public Boolean createWaveDomain(WaveVO waveVO);

	public WaveVO getWaveDomainByID(Long waveID);

	public Boolean deleteWaveDomain(Long id);

	public WaveVO getWaveByPickingBasketID(Long pickingBasketID);

	public WaveVO getWaveByWallPositionBarcode(String wallPositionBarcode);

	public Boolean assignPickingWallPosition(Long waveID,
			Long pickingWallPositionID);

	public WaveVO assignWaveTask(Long agencyID, Long operator);

	public Boolean releaseWaveTask(Long waveID);

	public Boolean waveFinished(Long waveID);

	public Boolean reset(Long id);

	// head
	public Boolean addWaveVO(WaveVO waveVO);

	public List<WaveVO> queryWaveVOList(WaveQueryVO waveQueryVO);

	public WaveVO getWaveVOByID(Long id);

	public Boolean modifyWaveVO(WaveVO waveVO);

	public Boolean deleteWaveVO(Long waveID);

	// body

	public Boolean createWaveDetailVO(WaveDetailVO waveDetailVO);

	public Boolean batchCreateWaveDetailVO(List<WaveDetailVO> waveDetailVOs);

	public List<WaveDetailVO> queryWaveDetailVOList(
			WaveDetailQueryVO waveDetailQueryVO);

	public List<WaveDetailVO> getWaveDetailVOListByWaveID(Long waveID);

	public WaveDetailVO getWaveDetailVOByID(Long id);

	public Boolean modifyWaveDetailVO(WaveDetailVO waveDetailVO);

	public Boolean batchModifyWaveDetailVOs(List<WaveDetailVO> waveDetailVOs);

	public Boolean deleteWaveDetailVO(Long id);

	public Boolean deleteWaveDetailVOByWaveID(Long waveID);

	public Boolean batchDeleteWaveDetailVOByWaveID(List<Long> storyDetailIDs);

	public Boolean createWaveByDistribution(DistributionVO distributionVO);

	public Boolean onDistributionRemove(Long distributionID);
}

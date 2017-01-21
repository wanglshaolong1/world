package com.xianzaishi.wms.tmscore.domain.client.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;
import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public interface IWaveDomainClient {

	// domain
	public SimpleResultVO<Boolean> createWaveDomain(WaveVO waveVO);

	public SimpleResultVO<WaveVO> getWaveDomainByID(Long waveID);

	public SimpleResultVO<Boolean> deleteWaveDomain(Long id);

	public SimpleResultVO<WaveVO> getWaveByPickingBasketID(Long pickingBasketID);

	public SimpleResultVO<WaveVO> getWaveByWallPositionBarcode(
			String wallPositionBarcode);

	public SimpleResultVO<Boolean> assignPickingWallPosition(Long waveID,
			Long pickingWallPositionID);

	public SimpleResultVO<PickVO> assignWaveTask(Long agencyID, Long operator);

	public SimpleResultVO<Boolean> releaseWaveTask(Long waveID);

	public SimpleResultVO<Boolean> waveFinished(Long waveID);
	
	public SimpleResultVO<Boolean> reset(Long id);

	// head
	public SimpleResultVO<Boolean> addWaveVO(WaveVO waveVO);

	public SimpleResultVO<List<WaveVO>> queryWaveVOList(WaveQueryVO waveQueryVO);

	public SimpleResultVO<WaveVO> getWaveVOByID(Long id);

	/**
	 * details为null时，不对details做操作，为空list时batchDelete detail，非空时自动汇聚成所需操作。
	 * 
	 * @param waveVO
	 * @return
	 */
	public SimpleResultVO<Boolean> modifyWaveVO(WaveVO waveVO);

	public SimpleResultVO<Boolean> deleteWaveVO(Long waveID);

	// body

	public SimpleResultVO<Boolean> createWaveDetailVO(WaveDetailVO waveDetailVO);

	public SimpleResultVO<Boolean> batchCreateWaveDetailVO(
			List<WaveDetailVO> waveDetailVOs);

	public SimpleResultVO<List<WaveDetailVO>> queryWaveDetailVOList(
			WaveDetailQueryVO waveDetailQueryVO);

	public SimpleResultVO<List<WaveDetailVO>> getWaveDetailVOListByWaveID(
			Long waveID);

	public SimpleResultVO<WaveDetailQueryVO> getWaveDetailVOByID(Long id);

	public SimpleResultVO<Boolean> modifyWaveDetailVO(WaveDetailVO waveDetailVO);

	/**
	 * 按ID更新Detail
	 * 
	 * @param waveDetailVOs
	 * @return
	 */
	public SimpleResultVO<Boolean> batchModifyWaveDetailVOs(
			List<WaveDetailVO> waveDetailVOs);

	public SimpleResultVO<Boolean> deleteWaveDetailVO(Long id);

	public SimpleResultVO<Boolean> deleteWaveDetailVOByWaveID(Long waveID);

	public SimpleResultVO<Boolean> batchDeleteWaveDetailVOByWaveID(
			List<Long> storyDetailIDs);

}

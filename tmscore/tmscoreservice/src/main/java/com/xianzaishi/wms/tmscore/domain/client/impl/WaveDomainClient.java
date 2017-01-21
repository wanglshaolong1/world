package com.xianzaishi.wms.tmscore.domain.client.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.domain.client.itf.IWaveDomainClient;
import com.xianzaishi.wms.tmscore.domain.service.itf.IWaveDomainService;
import com.xianzaishi.wms.tmscore.vo.PickVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;
import com.xianzaishi.wms.tmscore.vo.WaveQueryVO;
import com.xianzaishi.wms.tmscore.vo.WaveVO;

public class WaveDomainClient implements IWaveDomainClient {
	private static final Logger logger = Logger
			.getLogger(WaveDomainClient.class);
	@Autowired
	private IWaveDomainService waveDomainService = null;

	public SimpleResultVO<Boolean> createWaveDomain(WaveVO waveVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.createWaveDomain(waveVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> waveFinished(Long waveID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.waveFinished(waveID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<WaveVO> getWaveDomainByID(Long waveID) {
		SimpleResultVO<WaveVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.getWaveDomainByID(waveID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> deleteWaveDomain(Long waveID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.deleteWaveDomain(waveID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> addWaveVO(WaveVO waveVO) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.addWaveVO(waveVO));
	}

	public SimpleResultVO<List<WaveVO>> queryWaveVOList(WaveQueryVO waveQueryVO) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.queryWaveVOList(waveQueryVO));
	}

	public SimpleResultVO<WaveVO> getWaveVOByID(Long id) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.getWaveVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyWaveVO(WaveVO waveVO) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.modifyWaveVO(waveVO));
	}

	public SimpleResultVO<Boolean> deleteWaveVO(Long id) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.deleteWaveVO(id));
	}

	public SimpleResultVO<Boolean> createWaveDetailVO(WaveDetailVO waveDetailVO) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.createWaveDetailVO(waveDetailVO));
	}

	public SimpleResultVO<Boolean> batchCreateWaveDetailVO(
			List<WaveDetailVO> waveDetailVOs) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.batchCreateWaveDetailVO(waveDetailVOs));
	}

	public SimpleResultVO<List<WaveDetailVO>> queryWaveDetailVOList(
			WaveDetailQueryVO waveDetailQueryVO) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.queryWaveDetailVOList(waveDetailQueryVO));
	}

	public SimpleResultVO<List<WaveDetailVO>> getWaveDetailVOListByWaveID(
			Long waveID) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.getWaveDetailVOListByWaveID(waveID));
	}

	public SimpleResultVO<WaveDetailQueryVO> getWaveDetailVOByID(Long id) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.getWaveDetailVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyWaveDetailVO(WaveDetailVO waveDetailVO) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.modifyWaveDetailVO(waveDetailVO));
	}

	public SimpleResultVO<Boolean> batchModifyWaveDetailVOs(
			List<WaveDetailVO> waveDetailVOs) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.batchModifyWaveDetailVOs(waveDetailVOs));
	}

	public SimpleResultVO<Boolean> deleteWaveDetailVO(Long id) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.deleteWaveDetailVO(id));
	}

	public SimpleResultVO<Boolean> deleteWaveDetailVOByWaveID(Long waveID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.deleteWaveDetailVOByWaveID(waveID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> batchDeleteWaveDetailVOByWaveID(
			List<Long> storyDetailIDs) {
		return SimpleResultVO.buildSuccessResult(waveDomainService
				.batchDeleteWaveDetailVOByWaveID(storyDetailIDs));
	}

	public SimpleResultVO<WaveVO> getWaveByPickingBasketID(Long pickingBasketID) {
		SimpleResultVO<WaveVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.getWaveByPickingBasketID(pickingBasketID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> assignPickingWallPosition(Long waveID,
			Long pickingWallPositionID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.assignPickingWallPosition(waveID, pickingWallPositionID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<WaveVO> getWaveByWallPositionBarcode(
			String wallPositionBarcode) {
		SimpleResultVO<WaveVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.getWaveByWallPositionBarcode(wallPositionBarcode));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<PickVO> assignWaveTask(Long agencyID, Long operator) {
		SimpleResultVO<PickVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.assignWaveTask(agencyID, operator));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public IWaveDomainService getWaveDomainService() {
		return waveDomainService;
	}

	public void setWaveDomainService(IWaveDomainService waveDomainService) {
		this.waveDomainService = waveDomainService;
	}

	public SimpleResultVO<Boolean> releaseWaveTask(Long waveID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.releaseWaveTask(waveID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> reset(Long id) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(waveDomainService
					.reset(id));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}
}

package com.xianzaishi.wms.tmscore.domain.client.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.domain.client.itf.IPickingWallPositionDomainClient;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickingWallPositionDomainService;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;

public class PickingWallPositionDomainClient implements
		IPickingWallPositionDomainClient {
	private static final Logger logger = Logger
			.getLogger(PickingWallPositionDomainClient.class);
	@Autowired
	private IPickingWallPositionDomainService pickingWallPositionDomainService = null;

	public SimpleResultVO<Boolean> addPickingWallPositionVO(
			PickingWallPositionVO pickingWallPositionVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(pickingWallPositionDomainService
							.addPickingWallPositionVO(pickingWallPositionVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public IPickingWallPositionDomainService getPickingWallPositionDomainService() {
		return pickingWallPositionDomainService;
	}

	public void setPickingWallPositionDomainService(
			IPickingWallPositionDomainService pickingWallPositionDomainService) {
		this.pickingWallPositionDomainService = pickingWallPositionDomainService;
	}

	public SimpleResultVO<PickingWallPositionVO> getPickingWallPositionVOByBarcode(
			String barcode) {
		SimpleResultVO<PickingWallPositionVO> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(pickingWallPositionDomainService
							.getPickingWallPositionVOByBarcode(barcode));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<PickingWallPositionVO> getPickingWallPositionVOByID(
			Long id) {
		SimpleResultVO<PickingWallPositionVO> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(pickingWallPositionDomainService
							.getPickingWallPositionVOByID(id));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<PickingWallPositionVO>> batchGetPickingWallPositionVOByBarcode(
			List<String> barcodes) {
		SimpleResultVO<List<PickingWallPositionVO>> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(pickingWallPositionDomainService
							.batchGetPickingWallPositionVOByBarcode(barcodes));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<PickingWallPositionVO>> batchGetPickingWallPositionVOByID(
			List<Long> ids) {
		SimpleResultVO<List<PickingWallPositionVO>> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(pickingWallPositionDomainService
							.batchGetPickingWallPositionVOByID(ids));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<PickingWallPositionVO>> getPickingWallPositionByWaveID(
			Long waveID) {
		SimpleResultVO<List<PickingWallPositionVO>> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(pickingWallPositionDomainService
							.getPickingWallPositionByWaveID(waveID));
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

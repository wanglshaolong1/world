package com.xianzaishi.wms.tmscore.domain.client.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.domain.client.itf.IPickingBasketDomainClient;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickingBasketDomainService;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public class PickingBasketDomainClient implements IPickingBasketDomainClient {
	private static final Logger logger = Logger
			.getLogger(PickingBasketDomainClient.class);
	@Autowired
	private IPickingBasketDomainService pickingBasketDomainService = null;

	public SimpleResultVO<Boolean> addPickingBasketVO(
			PickingBasketVO pickingBasketVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickingBasketDomainService
					.addPickingBasketVO(pickingBasketVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public IPickingBasketDomainService getPickingBasketDomainService() {
		return pickingBasketDomainService;
	}

	public void setPickingBasketDomainService(
			IPickingBasketDomainService pickingBasketDomainService) {
		this.pickingBasketDomainService = pickingBasketDomainService;
	}

	public SimpleResultVO<PickingBasketVO> getPickingBasketVOByBarcode(
			String barcode) {
		SimpleResultVO<PickingBasketVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickingBasketDomainService
					.getPickingBasketVOByBarcode(barcode));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<PickingBasketVO> getPickingBasketVOByID(Long id) {
		SimpleResultVO<PickingBasketVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickingBasketDomainService
					.getPickingBasketVOByID(id));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<PickingBasketVO>> batchGetPickingBasketVOByBarcode(
			List<String> barcodes) {
		SimpleResultVO<List<PickingBasketVO>> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickingBasketDomainService
					.batchGetPickingBasketVOByBarcode(barcodes));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<PickingBasketVO>> batchGetPickingBasketVOByID(
			List<Long> ids) {
		SimpleResultVO<List<PickingBasketVO>> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickingBasketDomainService
					.batchGetPickingBasketVOByID(ids));
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

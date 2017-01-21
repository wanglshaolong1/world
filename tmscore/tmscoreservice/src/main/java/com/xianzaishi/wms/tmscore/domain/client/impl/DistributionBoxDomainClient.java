package com.xianzaishi.wms.tmscore.domain.client.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.domain.client.itf.IDistributionBoxDomainClient;
import com.xianzaishi.wms.tmscore.domain.service.itf.IDistributionBoxDomainService;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;

public class DistributionBoxDomainClient implements
		IDistributionBoxDomainClient {
	private static final Logger logger = Logger
			.getLogger(DistributionBoxDomainClient.class);
	@Autowired
	private IDistributionBoxDomainService distributionBoxDomainService = null;

	public SimpleResultVO<Boolean> addDistributionBoxVO(
			DistributionBoxVO distributionBoxVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(distributionBoxDomainService
							.addDistributionBoxVO(distributionBoxVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public IDistributionBoxDomainService getDistributionBoxDomainService() {
		return distributionBoxDomainService;
	}

	public void setDistributionBoxDomainService(
			IDistributionBoxDomainService distributionBoxDomainService) {
		this.distributionBoxDomainService = distributionBoxDomainService;
	}

	public SimpleResultVO<DistributionBoxVO> getDistributionBoxVOByBarcode(
			String barcode) {
		SimpleResultVO<DistributionBoxVO> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(distributionBoxDomainService
							.getDistributionBoxVOByBarcode(barcode));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<DistributionBoxVO> getDistributionBoxVOByID(Long id) {
		SimpleResultVO<DistributionBoxVO> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(distributionBoxDomainService
							.getDistributionBoxVOByID(id));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<DistributionBoxVO>> batchGetDistributionBoxVOByBarcode(
			List<String> barcodes) {
		SimpleResultVO<List<DistributionBoxVO>> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(distributionBoxDomainService
							.batchGetDistributionBoxVOByBarcode(barcodes));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<DistributionBoxVO>> batchGetDistributionBoxVOByID(
			List<Long> ids) {
		SimpleResultVO<List<DistributionBoxVO>> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(distributionBoxDomainService
							.batchGetDistributionBoxVOByID(ids));
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

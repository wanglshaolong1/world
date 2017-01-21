package com.xianzaishi.wms.tmscore.domain.client.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.QueryResultVO;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.domain.client.itf.IDistributionDomainClient;
import com.xianzaishi.wms.tmscore.domain.service.itf.IDistributionDomainService;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;
import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public class DistributionDomainClient implements IDistributionDomainClient {
	private static final Logger logger = Logger
			.getLogger(DistributionDomainClient.class);
	@Autowired
	private IDistributionDomainService distributionDomainService = null;

	public SimpleResultVO<Boolean> createDistributionDomain(
			DistributionVO distributionVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.createDistributionDomain(distributionVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<DistributionVO> getDistributionDomainByID(
			Long distributionID) {
		SimpleResultVO<DistributionVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.getDistributionDomainByID(distributionID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> deleteDistributionDomain(Long distributionID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.deleteDistributionDomain(distributionID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e); 
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> addDistributionVO(			
			DistributionVO distributionVO) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.addDistributionVO(distributionVO));
	}

	public SimpleResultVO<List<DistributionVO>> queryDistributionVOList(
			DistributionQueryVO distributionQueryVO) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.queryDistributionVOList(distributionQueryVO));
	}

	public SimpleResultVO<DistributionVO> getDistributionVOByID(Long id) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.getDistributionVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyDistributionVO(
			DistributionVO distributionVO) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.modifyDistributionVO(distributionVO));
	}

	public SimpleResultVO<Boolean> deleteDistributionVO(Long id) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.deleteDistributionVO(id));
	}

	public SimpleResultVO<Boolean> createDistributionDetailVO(
			DistributionDetailVO distributionDetailVO) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.createDistributionDetailVO(distributionDetailVO));
	}

	public SimpleResultVO<Boolean> batchCreateDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.batchCreateDistributionDetailVO(distributionDetailVOs));
	}

	public SimpleResultVO<List<DistributionDetailVO>> queryDistributionDetailVOList(
			DistributionDetailQueryVO distributionDetailQueryVO) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.queryDistributionDetailVOList(distributionDetailQueryVO));
	}

	public SimpleResultVO<List<DistributionDetailVO>> getDistributionDetailVOListByDistributionID(
			Long distributionID) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.getDistributionDetailVOListByDistributionID(distributionID));
	}

	public SimpleResultVO<DistributionDetailQueryVO> getDistributionDetailVOByID(
			Long id) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.getDistributionDetailVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyDistributionDetailVO(
			DistributionDetailVO distributionDetailVO) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.modifyDistributionDetailVO(distributionDetailVO));
	}

	public SimpleResultVO<Boolean> batchModifyDistributionDetailVOs(
			List<DistributionDetailVO> distributionDetailVOs) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.batchModifyDistributionDetailVOs(distributionDetailVOs));
	}

	public SimpleResultVO<Boolean> deleteDistributionDetailVO(Long id) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.deleteDistributionDetailVO(id));
	}

	public SimpleResultVO<Boolean> deleteDistributionDetailVOByDistributionID(
			Long distributionID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO
					.buildSuccessResult(distributionDomainService
							.deleteDistributionDetailVOByDistributionID(distributionID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> batchDeleteDistributionDetailVOByDistributionID(
			List<Long> storyDetailIDs) {
		return SimpleResultVO
				.buildSuccessResult(distributionDomainService
						.batchDeleteDistributionDetailVOByDistributionID(storyDetailIDs));
	}

	public IDistributionDomainService getDistributionDomainService() {
		return distributionDomainService;
	}

	public void setDistributionDomainService(
			IDistributionDomainService distributionDomainService) {
		this.distributionDomainService = distributionDomainService;
	}

	public SimpleResultVO<Boolean> suspendDistribution(Long id) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.suspendDistribution(id));
	}

	public SimpleResultVO<Boolean> reset(Long id) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.reset(id));
	}

	public SimpleResultVO<Boolean> setDistributionArea(Long id, Long area) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.setDistributionArea(id, area));
	}

	public SimpleResultVO<DistributionAreaVO> getDistributionAreaByAddressID(
			Long agency, Long addressID) {
		return SimpleResultVO.buildSuccessResult(distributionDomainService
				.getDistributionAreaByAddressID(agency, addressID));
	}

	public SimpleResultVO<Boolean> arrived(DistributionVO distributionVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.arrived(distributionVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> rejected(Long id) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.rejected(id));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<DistributionVO>> getDistributionByOrderID(
			Long orderID) {
		SimpleResultVO<List<DistributionVO>> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.getDistributionByOrderID(orderID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> closeDistribution(
			DistributionVO distributionVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.closeDistribution(distributionVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<QueryResultVO<DistributionVO>> queryDistributionVOListByPage(
			DistributionQueryVO distributionQueryVO) {
		SimpleResultVO<QueryResultVO<DistributionVO>> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(distributionDomainService
					.queryDistributionVOListByPage(distributionQueryVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> pickStart(Long id) {
		SimpleResultVO<Boolean> flag = null;
		try {
			distributionDomainService.pickStart(id);
			flag = SimpleResultVO.buildSuccessResult(true);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> picked(Long id) {
		SimpleResultVO<Boolean> flag = null;
		try {
			distributionDomainService.picked(id);
			flag = SimpleResultVO.buildSuccessResult(true);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> packStart(Long id) {
		SimpleResultVO<Boolean> flag = null;
		try {
			distributionDomainService.packStart(id);
			flag = SimpleResultVO.buildSuccessResult(true);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> packed(Long id) {
		SimpleResultVO<Boolean> flag = null;
		try {
			distributionDomainService.packed(id);
			flag = SimpleResultVO.buildSuccessResult(true);
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> deilverStart(Long id) {
		SimpleResultVO<Boolean> flag = null;
		try {
			distributionDomainService.deilverStart(id);
			flag = SimpleResultVO.buildSuccessResult(true);
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

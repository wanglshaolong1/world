package com.xianzaishi.wms.tmscore.domain.client.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.domain.client.itf.IDeliverDomainClient;
import com.xianzaishi.wms.tmscore.domain.service.itf.IDeliverDomainService;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;
import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public class DeliverDomainClient implements IDeliverDomainClient {
	private static final Logger logger = Logger
			.getLogger(DeliverDomainClient.class);
	@Autowired
	private IDeliverDomainService deliverDomainService = null;

	public SimpleResultVO<Boolean> createDeliverDomain(DeliverVO deliverVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.createDeliverDomain(deliverVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<DeliverVO> getDeliverDomainByID(Long deliverID) {
		SimpleResultVO<DeliverVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.getDeliverDomainByID(deliverID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> deleteDeliverDomain(Long deliverID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.deleteDeliverDomain(deliverID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> addDeliverVO(DeliverVO deliverVO) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.addDeliverVO(deliverVO));
	}

	public SimpleResultVO<List<DeliverVO>> queryDeliverVOList(
			DeliverQueryVO deliverQueryVO) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.queryDeliverVOList(deliverQueryVO));
	}

	public SimpleResultVO<DeliverVO> getDeliverVOByID(Long id) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.getDeliverVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyDeliverVO(DeliverVO deliverVO) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.modifyDeliverVO(deliverVO));
	}

	public SimpleResultVO<Boolean> deleteDeliverVO(Long id) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.deleteDeliverVO(id));
	}

	public SimpleResultVO<Boolean> createDeliverDetailVO(
			DeliverDetailVO deliverDetailVO) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.createDeliverDetailVO(deliverDetailVO));
	}

	public SimpleResultVO<Boolean> batchCreateDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.batchCreateDeliverDetailVO(deliverDetailVOs));
	}

	public SimpleResultVO<List<DeliverDetailVO>> queryDeliverDetailVOList(
			DeliverDetailQueryVO deliverDetailQueryVO) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.queryDeliverDetailVOList(deliverDetailQueryVO));
	}

	public SimpleResultVO<List<DeliverDetailVO>> getDeliverDetailVOListByDeliverID(
			Long deliverID) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.getDeliverDetailVOListByDeliverID(deliverID));
	}

	public SimpleResultVO<DeliverDetailQueryVO> getDeliverDetailVOByID(Long id) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.getDeliverDetailVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyDeliverDetailVO(
			DeliverDetailVO deliverDetailVO) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.modifyDeliverDetailVO(deliverDetailVO));
	}

	public SimpleResultVO<Boolean> batchModifyDeliverDetailVOs(
			List<DeliverDetailVO> deliverDetailVOs) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.batchModifyDeliverDetailVOs(deliverDetailVOs));
	}

	public SimpleResultVO<Boolean> deleteDeliverDetailVO(Long id) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.deleteDeliverDetailVO(id));
	}

	public SimpleResultVO<Boolean> deleteDeliverDetailVOByDeliverID(
			Long deliverID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.deleteDeliverDetailVOByDeliverID(deliverID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> batchDeleteDeliverDetailVOByDeliverID(
			List<Long> storyDetailIDs) {
		return SimpleResultVO.buildSuccessResult(deliverDomainService
				.batchDeleteDeliverDetailVOByDeliverID(storyDetailIDs));
	}

	public SimpleResultVO<Boolean> submitDeliver(DeliverVO deliverVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.submitDeliver(deliverVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<DeliverVO> assignDeliverVO(Long agencyID,
			Long operator) {
		SimpleResultVO<DeliverVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.assignDeliverVO(agencyID, operator));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<DeliverDistributionVO>> getDeliverDistributionVOByDeliverID(
			Long deliverID) {
		SimpleResultVO<List<DeliverDistributionVO>> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.getDeliverDistributionVOByDeliverID(deliverID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<DistributionBoxVO> getDistriButionBoxVOByBoxID(
			Long boxID) {
		SimpleResultVO<DistributionBoxVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.getDistriButionBoxVOByBoxID(boxID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> releaseDistriButionBoxes(
			List<DistributionBoxStatuVO> distributionBoxes) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.releaseDistriButionBoxes(distributionBoxes));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public IDeliverDomainService getDeliverDomainService() {
		return deliverDomainService;
	}

	public void setDeliverDomainService(
			IDeliverDomainService deliverDomainService) {
		this.deliverDomainService = deliverDomainService;
	}

	public SimpleResultVO<Boolean> handOverDeliver(Long diliverID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.handOverDeliver(diliverID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> deliverBoxReturn(DeliverVO deliverVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.deliverBoxReturn(deliverVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<DistributionVO>> getDeliverDistributions(
			Long deliverID) {
		SimpleResultVO<List<DistributionVO>> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(deliverDomainService
					.getDeliverDistributions(deliverID));
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

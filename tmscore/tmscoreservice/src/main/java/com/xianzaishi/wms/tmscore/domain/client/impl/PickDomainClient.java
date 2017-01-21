package com.xianzaishi.wms.tmscore.domain.client.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.domain.client.itf.IPickDomainClient;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickDomainService;
import com.xianzaishi.wms.tmscore.vo.PickDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;
import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public class PickDomainClient implements IPickDomainClient {
	private static final Logger logger = Logger
			.getLogger(PickDomainClient.class);
	@Autowired
	private IPickDomainService pickDomainService = null;

	public SimpleResultVO<Boolean> createPickDomain(PickVO pickVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.createPickDomain(pickVO));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<PickVO> getPickDomainByID(Long pickID) {
		SimpleResultVO<PickVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.getPickDomainByID(pickID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> deletePickDomain(Long pickID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.deletePickDomain(pickID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> addPickVO(PickVO pickVO) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.addPickVO(pickVO));
	}

	public SimpleResultVO<List<PickVO>> queryPickVOList(PickQueryVO pickQueryVO) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.queryPickVOList(pickQueryVO));
	}

	public SimpleResultVO<PickVO> getPickVOByID(Long id) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.getPickVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyPickVO(PickVO pickVO) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.modifyPickVO(pickVO));
	}

	public SimpleResultVO<Boolean> deletePickVO(Long id) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.deletePickVO(id));
	}

	public SimpleResultVO<Boolean> createPickDetailVO(PickDetailVO pickDetailVO) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.createPickDetailVO(pickDetailVO));
	}

	public SimpleResultVO<Boolean> batchCreatePickDetailVO(
			List<PickDetailVO> pickDetailVOs) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.batchCreatePickDetailVO(pickDetailVOs));
	}

	public SimpleResultVO<List<PickDetailVO>> queryPickDetailVOList(
			PickDetailQueryVO pickDetailQueryVO) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.queryPickDetailVOList(pickDetailQueryVO));
	}

	public SimpleResultVO<List<PickDetailVO>> getPickDetailVOListByPickID(
			Long pickID) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.getPickDetailVOListByPickID(pickID));
	}

	public SimpleResultVO<PickDetailQueryVO> getPickDetailVOByID(Long id) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.getPickDetailVOByID(id));
	}

	public SimpleResultVO<Boolean> modifyPickDetailVO(PickDetailVO pickDetailVO) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.modifyPickDetailVO(pickDetailVO));
	}

	public SimpleResultVO<Boolean> batchModifyPickDetailVOs(
			List<PickDetailVO> pickDetailVOs) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.batchModifyPickDetailVOs(pickDetailVOs));
	}

	public SimpleResultVO<Boolean> deletePickDetailVO(Long id) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.deletePickDetailVO(id));
	}

	public SimpleResultVO<Boolean> deletePickDetailVOByPickID(Long pickID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.deletePickDetailVOByPickID(pickID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> batchDeletePickDetailVOByPickID(
			List<Long> storyDetailIDs) {
		return SimpleResultVO.buildSuccessResult(pickDomainService
				.batchDeletePickDetailVOByPickID(storyDetailIDs));
	}

	public SimpleResultVO<PickVO> assignPickVO(Long agencyID, Long operator) {
		SimpleResultVO<PickVO> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.assignPickVO(agencyID, operator));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> submitPickedDetail(
			List<PickDetailVO> pickDetailVOs) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.submitPickedDetail(pickDetailVOs));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> recievePickingBasket(
			String pickingBasketBarcode) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.recievePickingBasket(pickingBasketBarcode));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<Boolean> cancelPickTask(Long pickID) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.cancelPickTask(pickID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public SimpleResultVO<List<PickingBasketVO>> getPickingBasketVOsByPickID(
			Long pickID) {
		SimpleResultVO<List<PickingBasketVO>> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.getPickingBasketVOsByPickID(pickID));
		} catch (BizException e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildBizErrorResult(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			flag = SimpleResultVO.buildErrorResult();
		}
		return flag;
	}

	public IPickDomainService getPickDomainService() {
		return pickDomainService;
	}

	public void setPickDomainService(IPickDomainService pickDomainService) {
		this.pickDomainService = pickDomainService;
	}

	public SimpleResultVO<Boolean> outOfStock(PickDetailVO pickDetailVO) {
		SimpleResultVO<Boolean> flag = null;
		try {
			flag = SimpleResultVO.buildSuccessResult(pickDomainService
					.outOfStock(pickDetailVO));
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

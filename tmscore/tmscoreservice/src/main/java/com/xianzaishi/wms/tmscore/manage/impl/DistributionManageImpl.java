package com.xianzaishi.wms.tmscore.manage.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionManage;
import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public class DistributionManageImpl implements IDistributionManage {
	@Autowired
	private IDistributionDao distributionDao = null;

	private void validate(DistributionVO distributionVO) {
		if (distributionVO.getAgencyId() == null
				|| distributionVO.getAgencyId() <= 0) {
			throw new BizException("ID error：" + distributionVO.getAgencyId());
		}
		if (distributionVO.getDeliveryAging() == null) {
			throw new BizException("deliveryAging error："
					+ distributionVO.getDeliveryAging());
		}
		if (distributionVO.getPickup() == null) {
			throw new BizException("pickup error：" + distributionVO.getPickup());
		}
		if (distributionVO.getPayAmountReal() == null
				&& distributionVO.getPayAmount() != null
				&& !distributionVO.getPayAmount().isEmpty()) {
			distributionVO.setPayAmountReal(new BigDecimal(distributionVO
					.getPayAmount()).multiply(new BigDecimal(100)).intValue());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDistributionDao getDistributionDao() {
		return distributionDao;
	}

	public void setDistributionDao(IDistributionDao distributionDao) {
		this.distributionDao = distributionDao;
	}

	public Long addDistributionVO(DistributionVO distributionVO) {
		validate(distributionVO);
		return (Long) distributionDao.addDO(distributionVO);
	}

	public List<DistributionVO> queryDistributionVOList(
			DistributionQueryVO distributionQueryVO) {
		return distributionDao.queryDO(distributionQueryVO);
	}

	public DistributionVO getDistributionVOByID(Long id) {
		return (DistributionVO) distributionDao.getDOByID(id);
	}

	public Boolean modifyDistributionVO(DistributionVO distributionVO) {
		return distributionDao.updateDO(distributionVO);
	}

	public Boolean deleteDistributionVOByID(Long id) {
		return distributionDao.delDO(id);
	}

	public Boolean reset(Long id) {
		return distributionDao.reset(id);
	}

	public Integer queryDistributionCount(
			DistributionQueryVO distributionQueryVO) {
		return distributionDao.queryCount(distributionQueryVO);
	}

}

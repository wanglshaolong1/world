package com.xianzaishi.wms.tmscore.manage.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionDetailDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionDetailManage;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;

public class DistributionDetailManageImpl implements IDistributionDetailManage {
	@Autowired
	private IDistributionDetailDao distributionDetailDao = null;

	private void validate(DistributionDetailVO distributionDetailVO) {
		if (distributionDetailVO.getDistributionId() == null
				|| distributionDetailVO.getDistributionId() <= 0) {
			throw new BizException("distributionID error："
					+ distributionDetailVO.getDistributionId());
		}
		if (distributionDetailVO.getSkuId() == null
				|| distributionDetailVO.getSkuId() <= 0) {
			throw new BizException("skuID error："
					+ distributionDetailVO.getSkuId());
		}

		if (distributionDetailVO.getAllNoReal() == null
				&& distributionDetailVO.getAllNo() != null
				&& !distributionDetailVO.getAllNo().isEmpty()) {
			distributionDetailVO.setAllNoReal(new BigDecimal(
					distributionDetailVO.getAllNo()).multiply(
					new BigDecimal(1000)).intValue());
		}

		if (distributionDetailVO.getDelivedNoReal() == null
				&& distributionDetailVO.getDelivedNo() != null
				&& !distributionDetailVO.getDelivedNo().isEmpty()) {
			distributionDetailVO.setDelivedNoReal(new BigDecimal(
					distributionDetailVO.getDelivedNo()).multiply(
					new BigDecimal(1000)).intValue());
		}

		if (distributionDetailVO.getDelivNoReal() == null
				&& distributionDetailVO.getDelivNo() != null
				&& !distributionDetailVO.getDelivNo().isEmpty()) {
			distributionDetailVO.setDelivNoReal(new BigDecimal(
					distributionDetailVO.getDelivNo()).multiply(
					new BigDecimal(1000)).intValue());
		}

		if (distributionDetailVO.getPriceReal() == null
				&& distributionDetailVO.getPrice() != null
				&& !distributionDetailVO.getPrice().isEmpty()) {
			distributionDetailVO.setPriceReal(new BigDecimal(
					distributionDetailVO.getPrice()).multiply(
					new BigDecimal(100)).intValue());
		}

		if (distributionDetailVO.getAllNoReal() == null
				|| distributionDetailVO.getAllNoReal() <= 0) {
			throw new BizException("all number error："
					+ distributionDetailVO.getAllNoReal());
		}
		if (distributionDetailVO.getDelivNoReal() == null
				|| distributionDetailVO.getDelivNoReal() <= 0) {
			throw new BizException("deliveryID error："
					+ distributionDetailVO.getDelivNoReal());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDistributionDetailDao getDistributionDetailDao() {
		return distributionDetailDao;
	}

	public void setDistributionDetailDao(
			IDistributionDetailDao distributionDetailDao) {
		this.distributionDetailDao = distributionDetailDao;
	}

	public Boolean addDistributionDetailVO(
			DistributionDetailVO distributionDetailVO) {
		validate(distributionDetailVO);
		distributionDetailDao.addDO(distributionDetailVO);
		return true;
	}

	public List<DistributionDetailVO> queryDistributionDetailVOList(
			DistributionDetailQueryVO distributionDetailQueryVO) {
		return distributionDetailDao.queryDO(distributionDetailQueryVO);
	}

	public DistributionDetailVO getDistributionDetailVOByID(Long id) {
		return (DistributionDetailVO) distributionDetailDao.getDOByID(id);
	}

	public Boolean modifyDistributionDetailVO(
			DistributionDetailVO distributionDetailVO) {
		return distributionDetailDao.updateDO(distributionDetailVO);
	}

	public Boolean deleteDistributionDetailVOByID(Long id) {
		return distributionDetailDao.delDO(id);
	}

	public List<DistributionDetailVO> getDistributionDetailVOByOutgoingID(
			Long id) {
		DistributionDetailQueryVO queryVO = new DistributionDetailQueryVO();
		queryVO.setDistributionId(id);
		queryVO.setSize(Integer.MAX_VALUE);
		return distributionDetailDao.queryDO(queryVO);
	}

	public Boolean batchAddDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs) {
		return distributionDetailDao.batchAddDO(distributionDetailVOs);
	}

	public Boolean batchModifyDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs) {
		return distributionDetailDao.batchModifyDO(distributionDetailVOs);
	}

	public Boolean batchDeleteDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs) {
		return distributionDetailDao.batchDeleteDO(distributionDetailVOs);
	}

	public Boolean batchDeleteDistributionDetailVOByID(
			List<Long> distributionDetailIDs) {
		return distributionDetailDao.batchDeleteDOByID(distributionDetailIDs);
	}
}

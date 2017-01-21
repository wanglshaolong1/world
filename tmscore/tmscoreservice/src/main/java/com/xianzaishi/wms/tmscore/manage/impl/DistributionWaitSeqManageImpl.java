package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionWaitSeqDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionWaitSeqManage;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqVO;

public class DistributionWaitSeqManageImpl implements
		IDistributionWaitSeqManage {
	@Autowired
	private IDistributionWaitSeqDao distributionWaitSeqDao = null;

	private void validate(DistributionWaitSeqVO distributionWaitSeqVO) {
		if (distributionWaitSeqVO.getDistributionId() == null
				|| distributionWaitSeqVO.getDistributionId() <= 0) {
			throw new BizException("distributionID error："
					+ distributionWaitSeqVO.getDistributionId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDistributionWaitSeqDao getDistributionWaitSeqDao() {
		return distributionWaitSeqDao;
	}

	public void setDistributionWaitSeqDao(
			IDistributionWaitSeqDao distributionWaitSeqDao) {
		this.distributionWaitSeqDao = distributionWaitSeqDao;
	}

	public Boolean addDistributionWaitSeqVO(
			DistributionWaitSeqVO distributionWaitSeqVO) {
		distributionWaitSeqDao.addDO(distributionWaitSeqVO);
		return true;
	}

	public List<DistributionWaitSeqVO> queryDistributionWaitSeqVOList(
			DistributionWaitSeqQueryVO distributionWaitSeqQueryVO) {
		return distributionWaitSeqDao.queryDO(distributionWaitSeqQueryVO);
	}

	public DistributionWaitSeqVO getDistributionWaitSeqVOByID(Long id) {
		return (DistributionWaitSeqVO) distributionWaitSeqDao.getDOByID(id);
	}

	public Boolean modifyDistributionWaitSeqVO(
			DistributionWaitSeqVO distributionWaitSeqVO) {
		return distributionWaitSeqDao.updateDO(distributionWaitSeqVO);
	}

	public Boolean deleteDistributionWaitSeqVOByID(Long id) {
		return distributionWaitSeqDao.delDO(id);
	}

	public boolean assign(DistributionWaitSeqVO distributionWaitSeqVO) {
		return distributionWaitSeqDao.assign(distributionWaitSeqVO);
	}

	public boolean assignToNormal(DistributionWaitSeqVO distributionWaitSeqVO) {
		return distributionWaitSeqDao.assignToNormal(distributionWaitSeqVO);
	}

	public boolean deleteByDistributionID(Long distributionID) {
		return distributionWaitSeqDao.deleteByDistributionID(distributionID);
	}
}

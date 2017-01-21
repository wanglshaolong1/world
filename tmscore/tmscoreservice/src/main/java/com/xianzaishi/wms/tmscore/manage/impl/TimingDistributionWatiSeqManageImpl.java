package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.ITimingDistributionWatiSeqDao;
import com.xianzaishi.wms.tmscore.manage.itf.ITimingDistributionWatiSeqManage;
import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqQueryVO;
import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqVO;

public class TimingDistributionWatiSeqManageImpl implements
		ITimingDistributionWatiSeqManage {
	@Autowired
	private ITimingDistributionWatiSeqDao timingDistributionWatiSeqDao = null;

	private void validate(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		if (timingDistributionWatiSeqVO.getDistributionId() == null
				|| timingDistributionWatiSeqVO.getDistributionId() <= 0) {
			throw new BizException("distributionID error："
					+ timingDistributionWatiSeqVO.getDistributionId());
		}
		if (timingDistributionWatiSeqVO.getDeliveryTime() == null
				|| timingDistributionWatiSeqVO.getDeliveryTime() <= 0) {
			throw new BizException("deliveryTime error："
					+ timingDistributionWatiSeqVO.getDeliveryTime());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public ITimingDistributionWatiSeqDao getTimingDistributionWatiSeqDao() {
		return timingDistributionWatiSeqDao;
	}

	public void setTimingDistributionWatiSeqDao(
			ITimingDistributionWatiSeqDao timingDistributionWatiSeqDao) {
		this.timingDistributionWatiSeqDao = timingDistributionWatiSeqDao;
	}

	public Boolean addTimingDistributionWatiSeqVO(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		validate(timingDistributionWatiSeqVO);
		timingDistributionWatiSeqDao.addDO(timingDistributionWatiSeqVO);
		return true;
	}

	public List<TimingDistributionWatiSeqVO> queryTimingDistributionWatiSeqVOList(
			TimingDistributionWatiSeqQueryVO timingDistributionWatiSeqQueryVO) {
		return timingDistributionWatiSeqDao
				.queryDO(timingDistributionWatiSeqQueryVO);
	}

	public TimingDistributionWatiSeqVO getTimingDistributionWatiSeqVOByID(
			Long id) {
		return (TimingDistributionWatiSeqVO) timingDistributionWatiSeqDao
				.getDOByID(id);
	}

	public Boolean modifyTimingDistributionWatiSeqVO(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		return timingDistributionWatiSeqDao
				.updateDO(timingDistributionWatiSeqVO);
	}

	public Boolean deleteTimingDistributionWatiSeqVOByID(Long id) {
		return timingDistributionWatiSeqDao.delDO(id);
	}

	public boolean assign(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		return timingDistributionWatiSeqDao.assign(timingDistributionWatiSeqVO);
	}

	public boolean assignToNormal(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		return timingDistributionWatiSeqDao
				.assignToNormal(timingDistributionWatiSeqVO);
	}

	public boolean deleteByDistributionID(Long distributionID) {
		return timingDistributionWatiSeqDao
				.deleteByDistributionID(distributionID);
	}
}

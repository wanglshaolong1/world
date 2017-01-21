package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonVO;
import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonDO;
import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionCloseReasonManage;

import com.xianzaishi.wms.tmscore.dao.itf.IDistributionCloseReasonDao;

public class DistributionCloseReasonManageImpl implements IDistributionCloseReasonManage {
	@Autowired
	private IDistributionCloseReasonDao distributionCloseReasonDao = null;

	private void validate(DistributionCloseReasonDO distributionCloseReasonDO) {
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}
	
	public IDistributionCloseReasonDao getDistributionCloseReasonDao() {
		return distributionCloseReasonDao;
	}

	public void setDistributionCloseReasonDao(IDistributionCloseReasonDao distributionCloseReasonDao) {
		this.distributionCloseReasonDao = distributionCloseReasonDao;
	}
	
	public Boolean addDistributionCloseReasonVO(DistributionCloseReasonVO distributionCloseReasonVO) {
		distributionCloseReasonDao.addDO(distributionCloseReasonVO);
		return true;
	}

	public List<DistributionCloseReasonVO> queryDistributionCloseReasonVOList(DistributionCloseReasonQueryVO distributionCloseReasonQueryVO) {
		return distributionCloseReasonDao.queryDO(distributionCloseReasonQueryVO);
	}

	public DistributionCloseReasonVO getDistributionCloseReasonVOByID(Long id) {
		return (DistributionCloseReasonVO) distributionCloseReasonDao.getDOByID(id);
	}

	public Boolean modifyDistributionCloseReasonVO(DistributionCloseReasonVO distributionCloseReasonVO) {
		return distributionCloseReasonDao.updateDO(distributionCloseReasonVO);
	}

	public Boolean deleteDistributionCloseReasonVOByID(Long id) {
		return distributionCloseReasonDao.delDO(id);
	}
}

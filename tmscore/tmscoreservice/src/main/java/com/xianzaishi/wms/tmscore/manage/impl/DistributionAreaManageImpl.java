package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionAreaDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionAreaManage;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;

public class DistributionAreaManageImpl implements IDistributionAreaManage {
	@Autowired
	private IDistributionAreaDao distributionAreaDao = null;

	private void validate(DistributionAreaVO distributionAreaVO) {
		if (distributionAreaVO.getAgency() == null
				|| distributionAreaVO.getAgency() <= 0) {
			throw new BizException("agencyID error："
					+ distributionAreaVO.getAgency());
		}
		if (distributionAreaVO.getName() == null
				|| distributionAreaVO.getName().isEmpty()) {
			throw new BizException("name error：" + distributionAreaVO.getName());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDistributionAreaDao getDistributionAreaDao() {
		return distributionAreaDao;
	}

	public void setDistributionAreaDao(IDistributionAreaDao distributionAreaDao) {
		this.distributionAreaDao = distributionAreaDao;
	}

	public Boolean addDistributionAreaVO(DistributionAreaVO distributionAreaVO) {
		validate(distributionAreaVO);
		distributionAreaDao.addDO(distributionAreaVO);
		return true;
	}

	public List<DistributionAreaVO> queryDistributionAreaVOList(
			DistributionAreaQueryVO distributionAreaQueryVO) {
		return distributionAreaDao.queryDO(distributionAreaQueryVO);
	}

	public DistributionAreaVO getDistributionAreaVOByID(Long id) {
		return (DistributionAreaVO) distributionAreaDao.getDOByID(id);
	}

	public Boolean modifyDistributionAreaVO(
			DistributionAreaVO distributionAreaVO) {
		return distributionAreaDao.updateDO(distributionAreaVO);
	}

	public Boolean deleteDistributionAreaVOByID(Long id) {
		return distributionAreaDao.delDO(id);
	}

	public List<DistributionAreaVO> getArea(DistributionAreaQueryVO queryVO) {
		return distributionAreaDao.getArea(queryVO);
	}
}

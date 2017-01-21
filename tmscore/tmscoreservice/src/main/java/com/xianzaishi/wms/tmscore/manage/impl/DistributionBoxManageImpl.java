package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionBoxDao;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionBoxManage;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;

public class DistributionBoxManageImpl implements IDistributionBoxManage {
	@Autowired
	private IDistributionBoxDao distributionBoxDao = null;

	private void validate(DistributionBoxVO distributionBoxVO) {
		if (distributionBoxVO.getAgencyId() == null
				|| distributionBoxVO.getAgencyId() <= 0) {
			throw new BizException("agencyID error："
					+ distributionBoxVO.getAgencyId());
		}
		if (distributionBoxVO.getCode() == null
				|| distributionBoxVO.getCode().isEmpty()) {
			throw new BizException("code error：" + distributionBoxVO.getCode());
		}
		if (distributionBoxVO.getBarcode() == null
				|| distributionBoxVO.getBarcode().isEmpty()) {
			throw new BizException("barcode error："
					+ distributionBoxVO.getBarcode());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDistributionBoxDao getDistributionBoxDao() {
		return distributionBoxDao;
	}

	public void setDistributionBoxDao(IDistributionBoxDao distributionBoxDao) {
		this.distributionBoxDao = distributionBoxDao;
	}

	public Boolean addDistributionBoxVO(DistributionBoxVO distributionBoxVO) {
		validate(distributionBoxVO);
		distributionBoxDao.addDO(distributionBoxVO);
		return true;
	}

	public List<DistributionBoxVO> queryDistributionBoxVOList(
			DistributionBoxQueryVO distributionBoxQueryVO) {
		return distributionBoxDao.queryDO(distributionBoxQueryVO);
	}

	public DistributionBoxVO getDistributionBoxVOByID(Long id) {
		return (DistributionBoxVO) distributionBoxDao.getDOByID(id);
	}

	public Boolean modifyDistributionBoxVO(DistributionBoxVO distributionBoxVO) {
		return distributionBoxDao.updateDO(distributionBoxVO);
	}

	public Boolean deleteDistributionBoxVOByID(Long id) {
		return distributionBoxDao.delDO(id);
	}
}

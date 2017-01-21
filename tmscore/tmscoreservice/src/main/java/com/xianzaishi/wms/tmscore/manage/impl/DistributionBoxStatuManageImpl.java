package com.xianzaishi.wms.tmscore.manage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuDO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionBoxStatuManage;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionBoxStatuDao;

public class DistributionBoxStatuManageImpl implements
		IDistributionBoxStatuManage {
	@Autowired
	private IDistributionBoxStatuDao distributionBoxStatuDao = null;

	private void validate(DistributionBoxStatuVO distributionBoxStatuVO) {
		if (distributionBoxStatuVO.getBoxId() == null
				|| distributionBoxStatuVO.getBoxId() <= 0) {
			throw new BizException("boxID error："
					+ distributionBoxStatuVO.getBoxId());
		}
	}

	private void validate(Long id) {
		if (id == null || id <= 0) {
			throw new BizException("ID error：" + id);
		}
	}

	public IDistributionBoxStatuDao getDistributionBoxStatuDao() {
		return distributionBoxStatuDao;
	}

	public void setDistributionBoxStatuDao(
			IDistributionBoxStatuDao distributionBoxStatuDao) {
		this.distributionBoxStatuDao = distributionBoxStatuDao;
	}

	public Boolean addDistributionBoxStatuVO(
			DistributionBoxStatuVO distributionBoxStatuVO) {
		validate(distributionBoxStatuVO);
		distributionBoxStatuDao.addDO(distributionBoxStatuVO);
		return true;
	}

	public List<DistributionBoxStatuVO> queryDistributionBoxStatuVOList(
			DistributionBoxStatuQueryVO distributionBoxStatuQueryVO) {
		return distributionBoxStatuDao.queryDO(distributionBoxStatuQueryVO);
	}

	public DistributionBoxStatuVO getDistributionBoxStatuVOByID(Long id) {
		return (DistributionBoxStatuVO) distributionBoxStatuDao.getDOByID(id);
	}

	public Boolean modifyDistributionBoxStatuVO(
			DistributionBoxStatuVO distributionBoxStatuVO) {
		return distributionBoxStatuDao.updateDO(distributionBoxStatuVO);
	}

	public Boolean deleteDistributionBoxStatuVOByID(Long id) {
		return distributionBoxStatuDao.delDO(id);
	}

	public void assign(Long deliverID, Long boxID) {
		distributionBoxStatuDao.assign(deliverID, boxID);
	}

	public void release(DistributionBoxStatuVO distributionBoxStatuVO) {
		distributionBoxStatuDao.release(distributionBoxStatuVO);
	}
}

package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqVO;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionWaitSeqService;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionWaitSeqManage;

public class DistributionWaitSeqServiceImpl implements
		IDistributionWaitSeqService {
	@Autowired
	private IDistributionWaitSeqManage distributionWaitSeqManage = null;

	public IDistributionWaitSeqManage getDistributionWaitSeqManage() {
		return distributionWaitSeqManage;
	}

	public void setDistributionWaitSeqManage(
			IDistributionWaitSeqManage distributionWaitSeqManage) {
		this.distributionWaitSeqManage = distributionWaitSeqManage;
	}

	public Boolean addDistributionWaitSeqVO(
			DistributionWaitSeqVO distributionWaitSeqVO) {
		distributionWaitSeqManage
				.addDistributionWaitSeqVO(distributionWaitSeqVO);
		return true;
	}

	public List<DistributionWaitSeqVO> queryDistributionWaitSeqVOList(
			DistributionWaitSeqQueryVO distributionWaitSeqQueryVO) {
		return distributionWaitSeqManage
				.queryDistributionWaitSeqVOList(distributionWaitSeqQueryVO);
	}

	public DistributionWaitSeqVO getDistributionWaitSeqVOByID(Long id) {
		return (DistributionWaitSeqVO) distributionWaitSeqManage
				.getDistributionWaitSeqVOByID(id);
	}

	public Boolean modifyDistributionWaitSeqVO(
			DistributionWaitSeqVO distributionWaitSeqVO) {
		return distributionWaitSeqManage
				.modifyDistributionWaitSeqVO(distributionWaitSeqVO);
	}

	public Boolean deleteDistributionWaitSeqVOByID(Long id) {
		return distributionWaitSeqManage.deleteDistributionWaitSeqVOByID(id);
	}

	public boolean assign(DistributionWaitSeqVO distributionWaitSeqVO) {
		return distributionWaitSeqManage.assign(distributionWaitSeqVO);
	}

	public boolean assignToNormal(DistributionWaitSeqVO distributionWaitSeqVO) {
		return distributionWaitSeqManage.assignToNormal(distributionWaitSeqVO);
	}

	public boolean deleteByDistributionID(Long distributionID) {
		return distributionWaitSeqManage.deleteByDistributionID(distributionID);
	}
}

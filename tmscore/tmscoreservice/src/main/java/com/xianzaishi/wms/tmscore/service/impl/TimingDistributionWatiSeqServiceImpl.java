package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqVO;
import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.ITimingDistributionWatiSeqService;
import com.xianzaishi.wms.tmscore.manage.itf.ITimingDistributionWatiSeqManage;

public class TimingDistributionWatiSeqServiceImpl implements
		ITimingDistributionWatiSeqService {
	@Autowired
	private ITimingDistributionWatiSeqManage timingDistributionWatiSeqManage = null;

	public ITimingDistributionWatiSeqManage getTimingDistributionWatiSeqManage() {
		return timingDistributionWatiSeqManage;
	}

	public void setTimingDistributionWatiSeqManage(
			ITimingDistributionWatiSeqManage timingDistributionWatiSeqManage) {
		this.timingDistributionWatiSeqManage = timingDistributionWatiSeqManage;
	}

	public Boolean addTimingDistributionWatiSeqVO(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		timingDistributionWatiSeqManage
				.addTimingDistributionWatiSeqVO(timingDistributionWatiSeqVO);
		return true;
	}

	public List<TimingDistributionWatiSeqVO> queryTimingDistributionWatiSeqVOList(
			TimingDistributionWatiSeqQueryVO timingDistributionWatiSeqQueryVO) {
		return timingDistributionWatiSeqManage
				.queryTimingDistributionWatiSeqVOList(timingDistributionWatiSeqQueryVO);
	}

	public TimingDistributionWatiSeqVO getTimingDistributionWatiSeqVOByID(
			Long id) {
		return (TimingDistributionWatiSeqVO) timingDistributionWatiSeqManage
				.getTimingDistributionWatiSeqVOByID(id);
	}

	public Boolean modifyTimingDistributionWatiSeqVO(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		return timingDistributionWatiSeqManage
				.modifyTimingDistributionWatiSeqVO(timingDistributionWatiSeqVO);
	}

	public Boolean deleteTimingDistributionWatiSeqVOByID(Long id) {
		return timingDistributionWatiSeqManage
				.deleteTimingDistributionWatiSeqVOByID(id);
	}

	public boolean assign(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		return timingDistributionWatiSeqManage
				.assign(timingDistributionWatiSeqVO);
	}

	public boolean assignToNormal(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		return timingDistributionWatiSeqManage
				.assignToNormal(timingDistributionWatiSeqVO);
	}

	public boolean deleteByDistributionID(Long distributionID) {
		return timingDistributionWatiSeqManage
				.deleteByDistributionID(distributionID);
	}
}

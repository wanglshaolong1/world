package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonVO;
import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionCloseReasonService;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionCloseReasonManage;

public class DistributionCloseReasonServiceImpl implements IDistributionCloseReasonService {
	@Autowired
	private IDistributionCloseReasonManage distributionCloseReasonManage = null;

	public IDistributionCloseReasonManage getDistributionCloseReasonManage() {
		return distributionCloseReasonManage;
	}

	public void setDistributionCloseReasonManage(IDistributionCloseReasonManage distributionCloseReasonManage) {
		this.distributionCloseReasonManage = distributionCloseReasonManage;
	}
	
	public Boolean addDistributionCloseReasonVO(DistributionCloseReasonVO distributionCloseReasonVO) {
		distributionCloseReasonManage.addDistributionCloseReasonVO(distributionCloseReasonVO);
		return true;
	}

	public List<DistributionCloseReasonVO> queryDistributionCloseReasonVOList(DistributionCloseReasonQueryVO distributionCloseReasonQueryVO) {
		return distributionCloseReasonManage.queryDistributionCloseReasonVOList(distributionCloseReasonQueryVO);
	}

	public DistributionCloseReasonVO getDistributionCloseReasonVOByID(Long id) {
		return (DistributionCloseReasonVO) distributionCloseReasonManage.getDistributionCloseReasonVOByID(id);
	}

	public Boolean modifyDistributionCloseReasonVO(DistributionCloseReasonVO distributionCloseReasonVO) {
		return distributionCloseReasonManage.modifyDistributionCloseReasonVO(distributionCloseReasonVO);
	}

	public Boolean deleteDistributionCloseReasonVOByID(Long id) {
		return distributionCloseReasonManage.deleteDistributionCloseReasonVOByID(id);
	}
}

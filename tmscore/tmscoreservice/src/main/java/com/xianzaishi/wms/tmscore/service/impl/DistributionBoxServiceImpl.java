package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionBoxService;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionBoxManage;

public class DistributionBoxServiceImpl implements IDistributionBoxService {
	@Autowired
	private IDistributionBoxManage distributionBoxManage = null;

	public IDistributionBoxManage getDistributionBoxManage() {
		return distributionBoxManage;
	}

	public void setDistributionBoxManage(IDistributionBoxManage distributionBoxManage) {
		this.distributionBoxManage = distributionBoxManage;
	}
	
	public Boolean addDistributionBoxVO(DistributionBoxVO distributionBoxVO) {
		distributionBoxManage.addDistributionBoxVO(distributionBoxVO);
		return true;
	}

	public List<DistributionBoxVO> queryDistributionBoxVOList(DistributionBoxQueryVO distributionBoxQueryVO) {
		return distributionBoxManage.queryDistributionBoxVOList(distributionBoxQueryVO);
	}

	public DistributionBoxVO getDistributionBoxVOByID(Long id) {
		return (DistributionBoxVO) distributionBoxManage.getDistributionBoxVOByID(id);
	}

	public Boolean modifyDistributionBoxVO(DistributionBoxVO distributionBoxVO) {
		return distributionBoxManage.modifyDistributionBoxVO(distributionBoxVO);
	}

	public Boolean deleteDistributionBoxVOByID(Long id) {
		return distributionBoxManage.deleteDistributionBoxVOByID(id);
	}
}

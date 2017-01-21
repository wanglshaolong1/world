package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionAreaService;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionAreaManage;

public class DistributionAreaServiceImpl implements IDistributionAreaService {
	@Autowired
	private IDistributionAreaManage distributionAreaManage = null;

	public IDistributionAreaManage getDistributionAreaManage() {
		return distributionAreaManage;
	}

	public void setDistributionAreaManage(
			IDistributionAreaManage distributionAreaManage) {
		this.distributionAreaManage = distributionAreaManage;
	}

	public Boolean addDistributionAreaVO(DistributionAreaVO distributionAreaVO) {
		distributionAreaManage.addDistributionAreaVO(distributionAreaVO);
		return true;
	}

	public List<DistributionAreaVO> queryDistributionAreaVOList(
			DistributionAreaQueryVO distributionAreaQueryVO) {
		return distributionAreaManage
				.queryDistributionAreaVOList(distributionAreaQueryVO);
	}

	public DistributionAreaVO getDistributionAreaVOByID(Long id) {
		return (DistributionAreaVO) distributionAreaManage
				.getDistributionAreaVOByID(id);
	}

	public Boolean modifyDistributionAreaVO(
			DistributionAreaVO distributionAreaVO) {
		return distributionAreaManage
				.modifyDistributionAreaVO(distributionAreaVO);
	}

	public Boolean deleteDistributionAreaVOByID(Long id) {
		return distributionAreaManage.deleteDistributionAreaVOByID(id);
	}

	public List<DistributionAreaVO> getArea(DistributionAreaQueryVO queryVO) {
		return distributionAreaManage.getArea(queryVO);
	}
}

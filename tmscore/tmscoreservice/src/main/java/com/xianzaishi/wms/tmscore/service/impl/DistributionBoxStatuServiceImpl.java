package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionBoxStatuService;
import com.xianzaishi.wms.tmscore.manage.itf.IDistributionBoxStatuManage;

public class DistributionBoxStatuServiceImpl implements
		IDistributionBoxStatuService {
	@Autowired
	private IDistributionBoxStatuManage distributionBoxStatuManage = null;

	public IDistributionBoxStatuManage getDistributionBoxStatuManage() {
		return distributionBoxStatuManage;
	}

	public void setDistributionBoxStatuManage(
			IDistributionBoxStatuManage distributionBoxStatuManage) {
		this.distributionBoxStatuManage = distributionBoxStatuManage;
	}

	public Boolean addDistributionBoxStatuVO(
			DistributionBoxStatuVO distributionBoxStatuVO) {
		distributionBoxStatuManage
				.addDistributionBoxStatuVO(distributionBoxStatuVO);
		return true;
	}

	public List<DistributionBoxStatuVO> queryDistributionBoxStatuVOList(
			DistributionBoxStatuQueryVO distributionBoxStatuQueryVO) {
		return distributionBoxStatuManage
				.queryDistributionBoxStatuVOList(distributionBoxStatuQueryVO);
	}

	public DistributionBoxStatuVO getDistributionBoxStatuVOByID(Long id) {
		return (DistributionBoxStatuVO) distributionBoxStatuManage
				.getDistributionBoxStatuVOByID(id);
	}

	public Boolean modifyDistributionBoxStatuVO(
			DistributionBoxStatuVO distributionBoxStatuVO) {
		return distributionBoxStatuManage
				.modifyDistributionBoxStatuVO(distributionBoxStatuVO);
	}

	public Boolean deleteDistributionBoxStatuVOByID(Long id) {
		return distributionBoxStatuManage.deleteDistributionBoxStatuVOByID(id);
	}

	public void assign(Long deliverID, Long boxID) {
		distributionBoxStatuManage.assign(deliverID, boxID);
	}

	public void release(DistributionBoxStatuVO distributionBoxStatuVO) {
		distributionBoxStatuManage.release(distributionBoxStatuVO);
	}
}

package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IDistributionDetailManage;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionDetailService;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;

public class DistributionDetailServiceImpl implements
		IDistributionDetailService {
	@Autowired
	private IDistributionDetailManage distributionDetailManage = null;

	public IDistributionDetailManage getDistributionDetailManage() {
		return distributionDetailManage;
	}

	public void setDistributionDetailManage(
			IDistributionDetailManage distributionDetailManage) {
		this.distributionDetailManage = distributionDetailManage;
	}

	public Boolean addDistributionDetailVO(
			DistributionDetailVO distributionDetailVO) {
		distributionDetailManage.addDistributionDetailVO(distributionDetailVO);
		return true;
	}

	public List<DistributionDetailVO> queryDistributionDetailVOList(
			DistributionDetailQueryVO distributionDetailQueryVO) {
		return distributionDetailManage
				.queryDistributionDetailVOList(distributionDetailQueryVO);
	}

	public DistributionDetailVO getDistributionDetailVOByID(Long id) {
		return (DistributionDetailVO) distributionDetailManage
				.getDistributionDetailVOByID(id);
	}

	public Boolean modifyDistributionDetailVO(
			DistributionDetailVO distributionDetailVO) {
		return distributionDetailManage
				.modifyDistributionDetailVO(distributionDetailVO);
	}

	public Boolean deleteDistributionDetailVOByID(Long id) {
		return distributionDetailManage.deleteDistributionDetailVOByID(id);
	}

	public List<DistributionDetailVO> getDistributionDetailVOByDistributionID(
			Long id) {
		return distributionDetailManage.getDistributionDetailVOByOutgoingID(id);
	}

	public Boolean batchAddDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs) {
		return distributionDetailManage
				.batchAddDistributionDetailVO(distributionDetailVOs);
	}

	public Boolean batchModifyDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs) {
		return distributionDetailManage
				.batchModifyDistributionDetailVO(distributionDetailVOs);
	}

	public Boolean batchDeleteDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs) {
		return distributionDetailManage
				.batchDeleteDistributionDetailVO(distributionDetailVOs);
	}

	public Boolean batchDeleteDistributionDetailVOByID(List<Long> storyDetailIDs) {
		return distributionDetailManage
				.batchDeleteDistributionDetailVOByID(storyDetailIDs);
	}
}

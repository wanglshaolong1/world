package com.xianzaishi.wms.tmscore.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IDistributionManage;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionService;
import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public class DistributionServiceImpl implements IDistributionService {
	@Autowired
	private IDistributionManage distributionManage = null;

	public IDistributionManage getDistributionManage() {
		return distributionManage;
	}

	public void setDistributionManage(IDistributionManage distributionManage) {
		this.distributionManage = distributionManage;
	}

	public Long addDistributionVO(DistributionVO distributionVO) {
		return distributionManage.addDistributionVO(distributionVO);
	}

	public List<DistributionVO> queryDistributionVOList(
			DistributionQueryVO distributionQueryVO) {
		return distributionManage.queryDistributionVOList(distributionQueryVO);
	}

	public DistributionVO getDistributionVOByID(Long id) {
		return (DistributionVO) distributionManage.getDistributionVOByID(id);
	}

	public Boolean modifyDistributionVO(DistributionVO distributionVO) {
		return distributionManage.modifyDistributionVO(distributionVO);
	}

	public Boolean deleteDistributionVOByID(Long id) {
		return distributionManage.deleteDistributionVOByID(id);
	}

	public Boolean suspendDistribution(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(-1);
		return distributionManage.modifyDistributionVO(distributionVO);
	}

	public Boolean reset(Long id) {
		return distributionManage.reset(id);
	}

	public void pickStart(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(2);
		distributionManage.modifyDistributionVO(distributionVO);
	}

	public void picked(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(3);
		distributionManage.modifyDistributionVO(distributionVO);
	}

	public void packStart(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(4);
		distributionManage.modifyDistributionVO(distributionVO);
	}

	public void packed(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(5);
		distributionManage.modifyDistributionVO(distributionVO);
	}

	public void deilverStart(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(6);
		distributionManage.modifyDistributionVO(distributionVO);
	}

	public void arrived(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(7);
		distributionVO.setDeliveredTime(new Date());
		distributionVO.setRejected(0);
		distributionManage.modifyDistributionVO(distributionVO);
	}

	public void rejected(Long id) {
		DistributionVO distributionVO = new DistributionVO();
		distributionVO.setId(id);
		distributionVO.setStatu(7);
		distributionVO.setDeliveredTime(new Date());
		distributionVO.setRejected(1);
		distributionManage.modifyDistributionVO(distributionVO);
	}

	public Boolean closeDistribution(DistributionVO distributionVO) {
		DistributionVO tmp = new DistributionVO();
		tmp.setId(distributionVO.getId());
		tmp.setBizStatu(1);
		tmp.setCloseReason(distributionVO.getCloseReason());
		return distributionManage.modifyDistributionVO(tmp);
	}

	public Integer queryDistributionCount(
			DistributionQueryVO distributionQueryVO) {
		return distributionManage.queryDistributionCount(distributionQueryVO);
	}
}

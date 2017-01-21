package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IPickDetailManage;
import com.xianzaishi.wms.tmscore.service.itf.IPickDetailService;
import com.xianzaishi.wms.tmscore.vo.PickDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;

public class PickDetailServiceImpl implements IPickDetailService {
	@Autowired
	private IPickDetailManage pickDetailManage = null;

	public IPickDetailManage getPickDetailManage() {
		return pickDetailManage;
	}

	public void setPickDetailManage(IPickDetailManage pickDetailManage) {
		this.pickDetailManage = pickDetailManage;
	}

	public Boolean addPickDetailVO(PickDetailVO pickDetailVO) {
		pickDetailManage.addPickDetailVO(pickDetailVO);
		return true;
	}

	public List<PickDetailVO> queryPickDetailVOList(
			PickDetailQueryVO pickDetailQueryVO) {
		return pickDetailManage.queryPickDetailVOList(pickDetailQueryVO);
	}

	public PickDetailVO getPickDetailVOByID(Long id) {
		return (PickDetailVO) pickDetailManage.getPickDetailVOByID(id);
	}

	public Boolean modifyPickDetailVO(PickDetailVO pickDetailVO) {
		return pickDetailManage.modifyPickDetailVO(pickDetailVO);
	}

	public Boolean deletePickDetailVOByID(Long id) {
		return pickDetailManage.deletePickDetailVOByID(id);
	}

	public List<PickDetailVO> getPickDetailVOByPickID(Long id) {
		return pickDetailManage.getPickDetailVOByOutgoingID(id);
	}

	public Boolean batchAddPickDetailVO(List<PickDetailVO> pickDetailVOs) {
		return pickDetailManage.batchAddPickDetailVO(pickDetailVOs);
	}

	public Boolean batchModifyPickDetailVO(List<PickDetailVO> pickDetailVOs) {
		return pickDetailManage.batchModifyPickDetailVO(pickDetailVOs);
	}

	public Boolean batchDeletePickDetailVO(List<PickDetailVO> pickDetailVOs) {
		return pickDetailManage.batchDeletePickDetailVO(pickDetailVOs);
	}

	public Boolean batchDeletePickDetailVOByID(List<Long> storyDetailIDs) {
		return pickDetailManage.batchDeletePickDetailVOByID(storyDetailIDs);
	}
}

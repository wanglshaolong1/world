package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IPickManage;
import com.xianzaishi.wms.tmscore.service.itf.IPickService;
import com.xianzaishi.wms.tmscore.vo.PickQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickVO;

public class PickServiceImpl implements IPickService {
	@Autowired
	private IPickManage pickManage = null;

	public IPickManage getPickManage() {
		return pickManage;
	}

	public void setPickManage(IPickManage pickManage) {
		this.pickManage = pickManage;
	}

	public Long addPickVO(PickVO pickVO) {
		return pickManage.addPickVO(pickVO);
	}

	public List<PickVO> queryPickVOList(PickQueryVO pickQueryVO) {
		return pickManage.queryPickVOList(pickQueryVO);
	}

	public PickVO getPickVOByID(Long id) {
		return (PickVO) pickManage.getPickVOByID(id);
	}

	public Boolean modifyPickVO(PickVO pickVO) {
		return pickManage.modifyPickVO(pickVO);
	}

	public Boolean deletePickVOByID(Long id) {
		return pickManage.deletePickVOByID(id);
	}

	public PickVO assign(PickVO pickVO) {
		return pickManage.assign(pickVO);
	}

	public Boolean cancelPickTask(Long pickID) {
		PickVO pickVO = pickManage.getPickVOByID(pickID);
		pickVO.setStatu(Short.parseShort("3"));
		return pickManage.modifyPickVO(pickVO);
	}
}

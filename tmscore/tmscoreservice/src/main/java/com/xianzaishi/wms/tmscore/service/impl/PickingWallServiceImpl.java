package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.PickingWallVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallService;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingWallManage;

public class PickingWallServiceImpl implements IPickingWallService {
	@Autowired
	private IPickingWallManage pickingWallManage = null;

	public IPickingWallManage getPickingWallManage() {
		return pickingWallManage;
	}

	public void setPickingWallManage(IPickingWallManage pickingWallManage) {
		this.pickingWallManage = pickingWallManage;
	}
	
	public Boolean addPickingWallVO(PickingWallVO pickingWallVO) {
		pickingWallManage.addPickingWallVO(pickingWallVO);
		return true;
	}

	public List<PickingWallVO> queryPickingWallVOList(PickingWallQueryVO pickingWallQueryVO) {
		return pickingWallManage.queryPickingWallVOList(pickingWallQueryVO);
	}

	public PickingWallVO getPickingWallVOByID(Long id) {
		return (PickingWallVO) pickingWallManage.getPickingWallVOByID(id);
	}

	public Boolean modifyPickingWallVO(PickingWallVO pickingWallVO) {
		return pickingWallManage.modifyPickingWallVO(pickingWallVO);
	}

	public Boolean deletePickingWallVOByID(Long id) {
		return pickingWallManage.deletePickingWallVOByID(id);
	}
}

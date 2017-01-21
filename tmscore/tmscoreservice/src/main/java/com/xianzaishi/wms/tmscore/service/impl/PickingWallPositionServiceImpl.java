package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionService;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingWallPositionManage;

public class PickingWallPositionServiceImpl implements IPickingWallPositionService {
	@Autowired
	private IPickingWallPositionManage pickingWallPositionManage = null;

	public IPickingWallPositionManage getPickingWallPositionManage() {
		return pickingWallPositionManage;
	}

	public void setPickingWallPositionManage(IPickingWallPositionManage pickingWallPositionManage) {
		this.pickingWallPositionManage = pickingWallPositionManage;
	}
	
	public Boolean addPickingWallPositionVO(PickingWallPositionVO pickingWallPositionVO) {
		pickingWallPositionManage.addPickingWallPositionVO(pickingWallPositionVO);
		return true;
	}

	public List<PickingWallPositionVO> queryPickingWallPositionVOList(PickingWallPositionQueryVO pickingWallPositionQueryVO) {
		return pickingWallPositionManage.queryPickingWallPositionVOList(pickingWallPositionQueryVO);
	}

	public PickingWallPositionVO getPickingWallPositionVOByID(Long id) {
		return (PickingWallPositionVO) pickingWallPositionManage.getPickingWallPositionVOByID(id);
	}

	public Boolean modifyPickingWallPositionVO(PickingWallPositionVO pickingWallPositionVO) {
		return pickingWallPositionManage.modifyPickingWallPositionVO(pickingWallPositionVO);
	}

	public Boolean deletePickingWallPositionVOByID(Long id) {
		return pickingWallPositionManage.deletePickingWallPositionVOByID(id);
	}
}

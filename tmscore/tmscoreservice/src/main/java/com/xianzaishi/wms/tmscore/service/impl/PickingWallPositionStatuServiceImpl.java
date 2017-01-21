package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.manage.itf.IPickingWallPositionStatuManage;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionStatuService;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuVO;

public class PickingWallPositionStatuServiceImpl implements
		IPickingWallPositionStatuService {
	@Autowired
	private IPickingWallPositionStatuManage pickingWallPositionStatuManage = null;

	public IPickingWallPositionStatuManage getPickingWallPositionStatuManage() {
		return pickingWallPositionStatuManage;
	}

	public void setPickingWallPositionStatuManage(
			IPickingWallPositionStatuManage pickingWallPositionStatuManage) {
		this.pickingWallPositionStatuManage = pickingWallPositionStatuManage;
	}

	public Boolean addPickingWallPositionStatuVO(
			PickingWallPositionStatuVO pickingWallPositionStatuVO) {
		pickingWallPositionStatuManage
				.addPickingWallPositionStatuVO(pickingWallPositionStatuVO);
		return true;
	}

	public List<PickingWallPositionStatuVO> queryPickingWallPositionStatuVOList(
			PickingWallPositionStatuQueryVO pickingWallPositionStatuQueryVO) {
		return pickingWallPositionStatuManage
				.queryPickingWallPositionStatuVOList(pickingWallPositionStatuQueryVO);
	}

	public PickingWallPositionStatuVO getPickingWallPositionStatuVOByID(Long id) {
		return (PickingWallPositionStatuVO) pickingWallPositionStatuManage
				.getPickingWallPositionStatuVOByID(id);
	}

	public Boolean modifyPickingWallPositionStatuVO(
			PickingWallPositionStatuVO pickingWallPositionStatuVO) {
		return pickingWallPositionStatuManage
				.modifyPickingWallPositionStatuVO(pickingWallPositionStatuVO);
	}

	public Boolean deletePickingWallPositionStatuVOByID(Long id) {
		return pickingWallPositionStatuManage
				.deletePickingWallPositionStatuVOByID(id);
	}

	public void assign(Long waveID, Long positionID) {
		pickingWallPositionStatuManage.assign(waveID, positionID);
	}
}

package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IPickingBasketStatuService;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingBasketStatuManage;

public class PickingBasketStatuServiceImpl implements
		IPickingBasketStatuService {
	@Autowired
	private IPickingBasketStatuManage pickingBasketStatuManage = null;

	public IPickingBasketStatuManage getPickingBasketStatuManage() {
		return pickingBasketStatuManage;
	}

	public void setPickingBasketStatuManage(
			IPickingBasketStatuManage pickingBasketStatuManage) {
		this.pickingBasketStatuManage = pickingBasketStatuManage;
	}

	public Boolean addPickingBasketStatuVO(
			PickingBasketStatuVO pickingBasketStatuVO) {
		pickingBasketStatuManage.addPickingBasketStatuVO(pickingBasketStatuVO);
		return true;
	}

	public List<PickingBasketStatuVO> queryPickingBasketStatuVOList(
			PickingBasketStatuQueryVO pickingBasketStatuQueryVO) {
		return pickingBasketStatuManage
				.queryPickingBasketStatuVOList(pickingBasketStatuQueryVO);
	}

	public PickingBasketStatuVO getPickingBasketStatuVOByID(Long id) {
		return (PickingBasketStatuVO) pickingBasketStatuManage
				.getPickingBasketStatuVOByID(id);
	}

	public Boolean modifyPickingBasketStatuVO(
			PickingBasketStatuVO pickingBasketStatuVO) {
		return pickingBasketStatuManage
				.modifyPickingBasketStatuVO(pickingBasketStatuVO);
	}

	public Boolean deletePickingBasketStatuVOByID(Long id) {
		return pickingBasketStatuManage.deletePickingBasketStatuVOByID(id);
	}

	public void assign(Long pickID, List<Long> basketIDs) {
		pickingBasketStatuManage.assign(pickID, basketIDs);
	}
}

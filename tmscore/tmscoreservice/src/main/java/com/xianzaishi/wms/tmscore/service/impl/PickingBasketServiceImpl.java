package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IPickingBasketService;
import com.xianzaishi.wms.tmscore.manage.itf.IPickingBasketManage;

public class PickingBasketServiceImpl implements IPickingBasketService {
	@Autowired
	private IPickingBasketManage pickingBasketManage = null;

	public IPickingBasketManage getPickingBasketManage() {
		return pickingBasketManage;
	}

	public void setPickingBasketManage(IPickingBasketManage pickingBasketManage) {
		this.pickingBasketManage = pickingBasketManage;
	}

	public Boolean addPickingBasketVO(PickingBasketVO pickingBasketVO) {
		pickingBasketManage.addPickingBasketVO(pickingBasketVO);
		return true;
	}

	public List<PickingBasketVO> queryPickingBasketVOList(
			PickingBasketQueryVO pickingBasketQueryVO) {
		return pickingBasketManage
				.queryPickingBasketVOList(pickingBasketQueryVO);
	}

	public PickingBasketVO getPickingBasketVOByID(Long id) {
		return (PickingBasketVO) pickingBasketManage.getPickingBasketVOByID(id);
	}

	public Boolean modifyPickingBasketVO(PickingBasketVO pickingBasketVO) {
		return pickingBasketManage.modifyPickingBasketVO(pickingBasketVO);
	}

	public Boolean deletePickingBasketVOByID(Long id) {
		return pickingBasketManage.deletePickingBasketVOByID(id);
	}

}

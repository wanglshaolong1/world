package com.xianzaishi.wms.tmscore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.tmscore.vo.PickBasketVO;
import com.xianzaishi.wms.tmscore.vo.PickBasketQueryVO;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.service.itf.IPickBasketService;
import com.xianzaishi.wms.tmscore.manage.itf.IPickBasketManage;

public class PickBasketServiceImpl implements IPickBasketService {
	@Autowired
	private IPickBasketManage pickBasketManage = null;

	public IPickBasketManage getPickBasketManage() {
		return pickBasketManage;
	}

	public void setPickBasketManage(IPickBasketManage pickBasketManage) {
		this.pickBasketManage = pickBasketManage;
	}

	public Boolean addPickBasketVO(PickBasketVO pickBasketVO) {
		pickBasketManage.addPickBasketVO(pickBasketVO);
		return true;
	}

	public List<PickBasketVO> queryPickBasketVOList(
			PickBasketQueryVO pickBasketQueryVO) {
		return pickBasketManage.queryPickBasketVOList(pickBasketQueryVO);
	}

	public PickBasketVO getPickBasketVOByID(Long id) {
		return (PickBasketVO) pickBasketManage.getPickBasketVOByID(id);
	}

	public Boolean modifyPickBasketVO(PickBasketVO pickBasketVO) {
		return pickBasketManage.modifyPickBasketVO(pickBasketVO);
	}

	public Boolean deletePickBasketVOByID(Long id) {
		return pickBasketManage.deletePickBasketVOByID(id);
	}
}

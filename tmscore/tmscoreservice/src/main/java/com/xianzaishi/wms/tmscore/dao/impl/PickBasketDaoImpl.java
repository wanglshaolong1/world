package com.xianzaishi.wms.tmscore.dao.impl;

import java.util.List;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.tmscore.dao.itf.IPickBasketDao;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;

public class PickBasketDaoImpl extends BaseDaoAdapter implements IPickBasketDao {
	public String getVOClassName() {
		return "PickBasketDO";
	}
}

package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IPickingBasketDao;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class PickingBasketDaoImpl extends BaseDaoAdapter implements IPickingBasketDao {
public String getVOClassName() {
		return "PickingBasketDO";
	}
}

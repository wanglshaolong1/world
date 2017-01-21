package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IPickingWallDao;
import com.xianzaishi.wms.tmscore.vo.PickingWallVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class PickingWallDaoImpl extends BaseDaoAdapter implements IPickingWallDao {
public String getVOClassName() {
		return "PickingWallDO";
	}
}

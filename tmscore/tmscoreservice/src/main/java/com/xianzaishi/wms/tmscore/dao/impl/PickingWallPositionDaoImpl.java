package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IPickingWallPositionDao;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class PickingWallPositionDaoImpl extends BaseDaoAdapter implements IPickingWallPositionDao {
public String getVOClassName() {
		return "PickingWallPositionDO";
	}
}

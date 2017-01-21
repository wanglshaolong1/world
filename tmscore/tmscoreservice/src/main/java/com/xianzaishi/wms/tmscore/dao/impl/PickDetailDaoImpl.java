package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IPickDetailDao;
import com.xianzaishi.wms.tmscore.vo.PickDetailVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class PickDetailDaoImpl extends BaseDaoAdapter implements IPickDetailDao {
public String getVOClassName() {
		return "PickDetailDO";
	}
}

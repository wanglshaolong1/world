package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IDeliverBoxDao;
import com.xianzaishi.wms.tmscore.vo.DeliverBoxVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class DeliverBoxDaoImpl extends BaseDaoAdapter implements IDeliverBoxDao {
public String getVOClassName() {
		return "DeliverBoxDO";
	}
}

package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IDeliverDetailDao;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class DeliverDetailDaoImpl extends BaseDaoAdapter implements IDeliverDetailDao {
public String getVOClassName() {
		return "DeliverDetailDO";
	}
}

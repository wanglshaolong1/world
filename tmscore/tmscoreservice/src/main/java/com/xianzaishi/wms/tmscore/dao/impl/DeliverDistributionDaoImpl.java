package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IDeliverDistributionDao;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class DeliverDistributionDaoImpl extends BaseDaoAdapter implements IDeliverDistributionDao {
public String getVOClassName() {
		return "DeliverDistributionDO";
	}
}

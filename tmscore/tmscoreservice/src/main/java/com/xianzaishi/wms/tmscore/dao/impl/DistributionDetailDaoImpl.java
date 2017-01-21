package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IDistributionDetailDao;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class DistributionDetailDaoImpl extends BaseDaoAdapter implements IDistributionDetailDao {
public String getVOClassName() {
		return "DistributionDetailDO";
	}
}

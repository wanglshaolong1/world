package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IDistributionBoxDao;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class DistributionBoxDaoImpl extends BaseDaoAdapter implements IDistributionBoxDao {
public String getVOClassName() {
		return "DistributionBoxDO";
	}
}

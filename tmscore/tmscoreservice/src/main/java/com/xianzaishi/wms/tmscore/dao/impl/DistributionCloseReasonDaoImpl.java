package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IDistributionCloseReasonDao;
import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class DistributionCloseReasonDaoImpl extends BaseDaoAdapter implements IDistributionCloseReasonDao {
public String getVOClassName() {
		return "DistributionCloseReasonDO";
	}
}

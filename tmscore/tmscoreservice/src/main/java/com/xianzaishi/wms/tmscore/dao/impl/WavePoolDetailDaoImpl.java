package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IWavePoolDetailDao;
import com.xianzaishi.wms.tmscore.vo.WavePoolDetailVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class WavePoolDetailDaoImpl extends BaseDaoAdapter implements IWavePoolDetailDao {
public String getVOClassName() {
		return "WavePoolDetailDO";
	}
}

package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IWaveDetailDao;
import com.xianzaishi.wms.tmscore.vo.WaveDetailVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class WaveDetailDaoImpl extends BaseDaoAdapter implements IWaveDetailDao {
public String getVOClassName() {
		return "WaveDetailDO";
	}
}

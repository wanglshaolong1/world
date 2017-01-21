package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IWavePoolDao;
import com.xianzaishi.wms.tmscore.vo.WavePoolVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class WavePoolDaoImpl extends BaseDaoAdapter implements IWavePoolDao {
public String getVOClassName() {
		return "WavePoolDO";
	}
}

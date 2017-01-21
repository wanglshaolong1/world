package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IAddressAreaMappingDao;
import com.xianzaishi.wms.tmscore.vo.AddressAreaMappingVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class AddressAreaMappingDaoImpl extends BaseDaoAdapter implements IAddressAreaMappingDao {
public String getVOClassName() {
		return "AddressAreaMappingDO";
	}
}

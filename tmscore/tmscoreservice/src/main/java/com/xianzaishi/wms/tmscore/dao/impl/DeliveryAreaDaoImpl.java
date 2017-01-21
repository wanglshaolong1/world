package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.tmscore.dao.itf.IDeliveryAreaDao;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;

public class DeliveryAreaDaoImpl extends BaseDaoAdapter implements IDeliveryAreaDao {
public String getVOClassName() {
		return "DeliveryAreaDO";
	}
}

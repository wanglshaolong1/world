package com.xianzaishi.wms.tmscore.dao.itf;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;

public interface IDeliverDao extends IBaseDao {
	public DeliverVO assign(DeliverVO deliverVO);
}
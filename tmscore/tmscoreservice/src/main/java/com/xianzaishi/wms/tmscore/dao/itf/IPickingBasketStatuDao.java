package com.xianzaishi.wms.tmscore.dao.itf;

import java.util.List;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;

public interface IPickingBasketStatuDao extends IBaseDao {
	public void assign(Long pickID, List<Long> basketIDs);
}
package com.xianzaishi.wms.tmscore.dao.itf;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;

public interface IPickingWallPositionStatuDao extends IBaseDao {
	public void assign(Long waveID, Long positionID);
}
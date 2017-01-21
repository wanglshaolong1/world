package com.xianzaishi.wms.tmscore.dao.itf;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;
import com.xianzaishi.wms.tmscore.vo.PickVO;

public interface IPickDao extends IBaseDao {
	public PickVO assign(PickVO pickVO);
}
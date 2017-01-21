package com.xianzaishi.wms.tmscore.dao.itf;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;

public interface IDistributionBoxStatuDao extends IBaseDao {
	public void assign(Long deliverID, Long boxID);

	public void release(DistributionBoxStatuVO distributionBoxStatuVO);
}
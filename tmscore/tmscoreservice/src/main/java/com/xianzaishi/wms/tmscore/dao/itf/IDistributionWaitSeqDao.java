package com.xianzaishi.wms.tmscore.dao.itf;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqVO;

public interface IDistributionWaitSeqDao extends IBaseDao {
	public boolean assign(DistributionWaitSeqVO distributionWaitSeqVO);

	public boolean assignToNormal(DistributionWaitSeqVO distributionWaitSeqVO);

	public boolean deleteByDistributionID(Long distributionID);
}
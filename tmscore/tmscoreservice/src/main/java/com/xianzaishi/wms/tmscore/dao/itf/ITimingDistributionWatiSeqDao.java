package com.xianzaishi.wms.tmscore.dao.itf;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;
import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqVO;

public interface ITimingDistributionWatiSeqDao extends IBaseDao {
	public boolean assign(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO);

	public boolean assignToNormal(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO);

	public boolean deleteByDistributionID(Long distributionID);
}
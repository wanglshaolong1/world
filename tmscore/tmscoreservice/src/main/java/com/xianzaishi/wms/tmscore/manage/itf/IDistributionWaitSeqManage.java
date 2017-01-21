package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqVO;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqDO;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqQueryVO;

public interface IDistributionWaitSeqManage {

	public Boolean addDistributionWaitSeqVO(
			DistributionWaitSeqVO distributionWaitSeqVO);

	public List<DistributionWaitSeqVO> queryDistributionWaitSeqVOList(
			DistributionWaitSeqQueryVO distributionWaitSeqQueryVO);

	public DistributionWaitSeqVO getDistributionWaitSeqVOByID(Long id);

	public Boolean modifyDistributionWaitSeqVO(
			DistributionWaitSeqVO distributionWaitSeqVO);

	public Boolean deleteDistributionWaitSeqVOByID(Long id);

	public boolean assign(DistributionWaitSeqVO distributionWaitSeqVO);

	public boolean assignToNormal(DistributionWaitSeqVO distributionWaitSeqVO);

	public boolean deleteByDistributionID(Long distributionID);

}
package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public interface IDistributionService {

	public Long addDistributionVO(DistributionVO distributionVO);

	public List<DistributionVO> queryDistributionVOList(
			DistributionQueryVO distributionQueryVO);

	public Integer queryDistributionCount(
			DistributionQueryVO distributionQueryVO);

	public DistributionVO getDistributionVOByID(Long id);

	public Boolean modifyDistributionVO(DistributionVO distributionVO);

	public Boolean deleteDistributionVOByID(Long id);

	public Boolean suspendDistribution(Long id);

	public Boolean closeDistribution(DistributionVO distributionVO);

	public Boolean reset(Long id);

	public void pickStart(Long id);

	public void picked(Long id);

	public void packStart(Long id);

	public void packed(Long id);

	public void deilverStart(Long id);

	public void arrived(Long id);

	public void rejected(Long id);

}
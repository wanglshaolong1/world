package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public interface IDistributionManage {

	public Long addDistributionVO(DistributionVO distributionVO);

	public List<DistributionVO> queryDistributionVOList(
			DistributionQueryVO distributionQueryVO);

	public Integer queryDistributionCount(
			DistributionQueryVO distributionQueryVO);

	public DistributionVO getDistributionVOByID(Long id);

	public Boolean modifyDistributionVO(DistributionVO distributionVO);

	public Boolean deleteDistributionVOByID(Long id);

	public Boolean reset(Long id);

}
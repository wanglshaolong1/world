package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;

public interface IDistributionDetailService {

	public Boolean addDistributionDetailVO(
			DistributionDetailVO distributionDetailVO);

	public List<DistributionDetailVO> queryDistributionDetailVOList(
			DistributionDetailQueryVO distributionDetailQueryVO);

	public DistributionDetailVO getDistributionDetailVOByID(Long id);

	public Boolean modifyDistributionDetailVO(
			DistributionDetailVO distributionDetailVO);

	public Boolean deleteDistributionDetailVOByID(Long id);

	public List<DistributionDetailVO> getDistributionDetailVOByDistributionID(
			Long id);

	public Boolean batchAddDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs);

	public Boolean batchModifyDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs);

	public Boolean batchDeleteDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs);

	public Boolean batchDeleteDistributionDetailVOByID(List<Long> storyDetailIDs);

}
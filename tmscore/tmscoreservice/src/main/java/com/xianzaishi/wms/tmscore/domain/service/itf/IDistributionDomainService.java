package com.xianzaishi.wms.tmscore.domain.service.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.QueryResultVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;
import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public interface IDistributionDomainService {

	// domain
	public List<DistributionVO> getDistributionByOrderID(Long orderID);

	public Boolean createDistributionDomain(DistributionVO distributionVO);

	public DistributionVO getDistributionDomainByID(Long distributionID);

	public Boolean deleteDistributionDomain(Long id);

	public Boolean closeDistribution(DistributionVO distributionVO);

	public Boolean suspendDistribution(Long id);

	public Boolean reset(Long id);

	public void pickStart(Long id);

	public void picked(Long id);

	public void packStart(Long id);

	public void packed(Long id);

	public void deilverStart(Long id);

	public Boolean arrived(DistributionVO distributionVO);

	public Boolean rejected(Long id);

	public Boolean setDistributionArea(Long id, Long area);

	public List<DistributionVO> assignNormal(String assign);

	public List<DistributionVO> assignTiming(String assign);

	// head
	public Boolean addDistributionVO(DistributionVO distributionVO);

	public List<DistributionVO> queryDistributionVOList(
			DistributionQueryVO distributionQueryVO);

	public QueryResultVO<DistributionVO> queryDistributionVOListByPage(
			DistributionQueryVO distributionQueryVO);

	public DistributionVO getDistributionVOByID(Long id);

	public Boolean modifyDistributionVO(DistributionVO distributionVO);

	public Boolean deleteDistributionVO(Long distributionID);

	// body
	public Boolean createDistributionDetailVO(
			DistributionDetailVO distributionDetailVO);

	public Boolean batchCreateDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs);

	public List<DistributionDetailVO> queryDistributionDetailVOList(
			DistributionDetailQueryVO distributionDetailQueryVO);

	public List<DistributionDetailVO> getDistributionDetailVOListByDistributionID(
			Long distributionID);

	public DistributionDetailVO getDistributionDetailVOByID(Long id);

	public Boolean modifyDistributionDetailVO(
			DistributionDetailVO distributionDetailVO);

	public Boolean batchModifyDistributionDetailVOs(
			List<DistributionDetailVO> distributionDetailVOs);

	public Boolean deleteDistributionDetailVO(Long id);

	public Boolean deleteDistributionDetailVOByDistributionID(
			Long distributionID);

	public Boolean batchDeleteDistributionDetailVOByDistributionID(
			List<Long> distributionDetailIDs);

	public DistributionAreaVO getDistributionAreaByAddressID(Long agencyID,
			Long addressID);
}

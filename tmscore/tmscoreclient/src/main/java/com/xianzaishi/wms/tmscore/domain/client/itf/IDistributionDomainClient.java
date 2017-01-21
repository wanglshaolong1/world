package com.xianzaishi.wms.tmscore.domain.client.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.QueryResultVO;
import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionDetailVO;
import com.xianzaishi.wms.tmscore.vo.DistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public interface IDistributionDomainClient {

	// domain
	public SimpleResultVO<Boolean> createDistributionDomain(
			DistributionVO distributionVO);

	public SimpleResultVO<DistributionVO> getDistributionDomainByID(
			Long distributionID);

	public SimpleResultVO<Boolean> deleteDistributionDomain(Long id);

	public SimpleResultVO<Boolean> suspendDistribution(Long id);

	public SimpleResultVO<Boolean> closeDistribution(
			DistributionVO distributionVO);

	public SimpleResultVO<Boolean> reset(Long id);

	public SimpleResultVO<Boolean> pickStart(Long id);

	public SimpleResultVO<Boolean> picked(Long id);

	public SimpleResultVO<Boolean> packStart(Long id);

	public SimpleResultVO<Boolean> packed(Long id);

	public SimpleResultVO<Boolean> deilverStart(Long id);

	public SimpleResultVO<Boolean> arrived(DistributionVO distributionVO);

	public SimpleResultVO<Boolean> rejected(Long id);

	public SimpleResultVO<Boolean> setDistributionArea(Long id, Long area);

	public SimpleResultVO<List<DistributionVO>> getDistributionByOrderID(
			Long orderID);

	// head
	public SimpleResultVO<Boolean> addDistributionVO(
			DistributionVO distributionVO);

	public SimpleResultVO<List<DistributionVO>> queryDistributionVOList(
			DistributionQueryVO distributionQueryVO);

	public SimpleResultVO<QueryResultVO<DistributionVO>> queryDistributionVOListByPage(
			DistributionQueryVO distributionQueryVO);

	public SimpleResultVO<DistributionVO> getDistributionVOByID(Long id);

	public SimpleResultVO<Boolean> modifyDistributionVO(
			DistributionVO distributionVO);

	public SimpleResultVO<Boolean> deleteDistributionVO(Long distributionID);

	// body
	public SimpleResultVO<Boolean> createDistributionDetailVO(
			DistributionDetailVO distributionDetailVO);

	public SimpleResultVO<Boolean> batchCreateDistributionDetailVO(
			List<DistributionDetailVO> distributionDetailVOs);

	public SimpleResultVO<List<DistributionDetailVO>> queryDistributionDetailVOList(
			DistributionDetailQueryVO distributionDetailQueryVO);

	public SimpleResultVO<List<DistributionDetailVO>> getDistributionDetailVOListByDistributionID(
			Long distributionID);

	public SimpleResultVO<DistributionDetailQueryVO> getDistributionDetailVOByID(
			Long id);

	public SimpleResultVO<Boolean> modifyDistributionDetailVO(
			DistributionDetailVO distributionDetailVO);

	public SimpleResultVO<Boolean> batchModifyDistributionDetailVOs(
			List<DistributionDetailVO> distributionDetailVOs);

	public SimpleResultVO<Boolean> deleteDistributionDetailVO(Long id);

	public SimpleResultVO<Boolean> deleteDistributionDetailVOByDistributionID(
			Long distributionID);

	public SimpleResultVO<Boolean> batchDeleteDistributionDetailVOByDistributionID(
			List<Long> storyDetailIDs);

	public SimpleResultVO<DistributionAreaVO> getDistributionAreaByAddressID(
			Long agency, Long addressID);
}

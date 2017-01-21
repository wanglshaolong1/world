package com.xianzaishi.wms.tmscore.domain.client.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;
import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public interface IDeliverDomainClient {

	// domain
	public SimpleResultVO<Boolean> createDeliverDomain(DeliverVO waveVO);

	public SimpleResultVO<DeliverVO> getDeliverDomainByID(Long waveID);

	public SimpleResultVO<Boolean> deleteDeliverDomain(Long id);

	public SimpleResultVO<Boolean> submitDeliver(DeliverVO deliverVO);

	public SimpleResultVO<List<DistributionVO>> getDeliverDistributions(
			Long deliverID);

	// head
	public SimpleResultVO<Boolean> addDeliverVO(DeliverVO waveVO);

	public SimpleResultVO<List<DeliverVO>> queryDeliverVOList(
			DeliverQueryVO waveQueryVO);

	public SimpleResultVO<DeliverVO> getDeliverVOByID(Long id);

	public SimpleResultVO<Boolean> modifyDeliverVO(DeliverVO waveVO);

	public SimpleResultVO<Boolean> deleteDeliverVO(Long waveID);

	public SimpleResultVO<DeliverVO> assignDeliverVO(Long agencyID,
			Long operator);

	// body

	public SimpleResultVO<Boolean> createDeliverDetailVO(
			DeliverDetailVO waveDetailVO);

	public SimpleResultVO<Boolean> batchCreateDeliverDetailVO(
			List<DeliverDetailVO> waveDetailVOs);

	public SimpleResultVO<List<DeliverDetailVO>> queryDeliverDetailVOList(
			DeliverDetailQueryVO waveDetailQueryVO);

	public SimpleResultVO<List<DeliverDetailVO>> getDeliverDetailVOListByDeliverID(
			Long waveID);

	public SimpleResultVO<DeliverDetailQueryVO> getDeliverDetailVOByID(Long id);

	public SimpleResultVO<Boolean> modifyDeliverDetailVO(
			DeliverDetailVO waveDetailVO);

	public SimpleResultVO<Boolean> batchModifyDeliverDetailVOs(
			List<DeliverDetailVO> waveDetailVOs);

	public SimpleResultVO<Boolean> deleteDeliverDetailVO(Long id);

	public SimpleResultVO<Boolean> deleteDeliverDetailVOByDeliverID(Long waveID);

	public SimpleResultVO<Boolean> batchDeleteDeliverDetailVOByDeliverID(
			List<Long> storyDetailIDs);

	public SimpleResultVO<List<DeliverDistributionVO>> getDeliverDistributionVOByDeliverID(
			Long deliverID);

	public SimpleResultVO<DistributionBoxVO> getDistriButionBoxVOByBoxID(
			Long boxID);

	public SimpleResultVO<Boolean> releaseDistriButionBoxes(
			List<DistributionBoxStatuVO> distributionBoxes);

	public SimpleResultVO<Boolean> handOverDeliver(Long diliverID);

	public SimpleResultVO<Boolean> deliverBoxReturn(DeliverVO deliverVO);
}

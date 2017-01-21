package com.xianzaishi.wms.tmscore.domain.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliverDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;
import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.tmscore.vo.DistributionVO;

public interface IDeliverDomainService {

	// domain
	public Boolean createDeliverDomain(DeliverVO waveVO);

	public DeliverVO getDeliverDomainByID(Long waveID);

	public Boolean deleteDeliverDomain(Long id);

	public Boolean submitDeliver(DeliverVO deliverVO);

	public List<DistributionVO> getDeliverDistributions(Long deliverID);

	// head
	public Boolean addDeliverVO(DeliverVO waveVO);

	public List<DeliverVO> queryDeliverVOList(DeliverQueryVO waveQueryVO);

	public DeliverVO getDeliverVOByID(Long id);

	public Boolean modifyDeliverVO(DeliverVO waveVO);

	public Boolean deleteDeliverVO(Long waveID);

	public DeliverVO assignDeliverVO(Long agencyID, Long operator);

	// body

	public Boolean createDeliverDetailVO(DeliverDetailVO waveDetailVO);

	public Boolean batchCreateDeliverDetailVO(
			List<DeliverDetailVO> waveDetailVOs);

	public List<DeliverDetailVO> queryDeliverDetailVOList(
			DeliverDetailQueryVO waveDetailQueryVO);

	public List<DeliverDetailVO> getDeliverDetailVOListByDeliverID(Long waveID);

	public DeliverDetailVO getDeliverDetailVOByID(Long id);

	public Boolean modifyDeliverDetailVO(DeliverDetailVO waveDetailVO);

	public Boolean batchModifyDeliverDetailVOs(
			List<DeliverDetailVO> waveDetailVOs);

	public Boolean deleteDeliverDetailVO(Long id);

	public Boolean deleteDeliverDetailVOByDeliverID(Long waveID);

	public Boolean batchDeleteDeliverDetailVOByDeliverID(
			List<Long> storyDetailIDs);

	public List<DeliverDistributionVO> getDeliverDistributionVOByDeliverID(
			Long deliverID);

	public DistributionBoxVO getDistriButionBoxVOByBoxID(Long boxID);

	public Boolean releaseDistriButionBoxes(
			List<DistributionBoxStatuVO> distributionBoxes);

	public Boolean handOverDeliver(Long diliverID);

	public Boolean deliverBoxReturn(DeliverVO deliverVO);
}

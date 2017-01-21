package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliverDistributionQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDistributionVO;

public interface IDeliverDistributionService {

	public Boolean addDeliverDistributionVO(
			DeliverDistributionVO deliverDistributionVO);

	public List<DeliverDistributionVO> queryDeliverDistributionVOList(
			DeliverDistributionQueryVO deliverDistributionQueryVO);

	public DeliverDistributionVO getDeliverDistributionVOByID(Long id);

	public Boolean modifyDeliverDistributionVO(
			DeliverDistributionVO deliverDistributionVO);

	public Boolean deleteDeliverDistributionVOByID(Long id);

	public List<DeliverDistributionVO> getDeliverDistributionVOByDeliverID(
			Long id);

	public Boolean batchAddDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs);

	public Boolean batchModifyDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs);

	public Boolean batchDeleteDeliverDistributionVO(
			List<DeliverDistributionVO> deliverDistributionVOs);

	public Boolean batchDeleteDeliverDistributionVOByID(
			List<Long> storyDetailIDs);

}
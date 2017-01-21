package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliverBoxQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverBoxVO;

public interface IDeliverBoxService {

	public Boolean addDeliverBoxVO(DeliverBoxVO deliverBoxVO);

	public List<DeliverBoxVO> queryDeliverBoxVOList(
			DeliverBoxQueryVO deliverBoxQueryVO);

	public DeliverBoxVO getDeliverBoxVOByID(Long id);

	public Boolean modifyDeliverBoxVO(DeliverBoxVO deliverBoxVO);

	public Boolean deleteDeliverBoxVOByID(Long id);

	public List<DeliverBoxVO> getDeliverBoxVOByOutgoingID(Long id);

	public Boolean batchAddDeliverBoxVO(
			List<DeliverBoxVO> deliverBoxVOs);

	public Boolean batchModifyDeliverBoxVO(
			List<DeliverBoxVO> deliverBoxVOs);

	public Boolean batchDeleteDeliverBoxVO(
			List<DeliverBoxVO> deliverBoxVOs);

	public Boolean batchDeleteDeliverBoxVOByID(List<Long> storyDetailIDs);

}
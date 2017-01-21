package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliverDetailQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverDetailVO;

public interface IDeliverDetailManage {

	public Boolean addDeliverDetailVO(DeliverDetailVO deliverDetailVO);

	public List<DeliverDetailVO> queryDeliverDetailVOList(
			DeliverDetailQueryVO deliverDetailQueryVO);

	public DeliverDetailVO getDeliverDetailVOByID(Long id);

	public Boolean modifyDeliverDetailVO(DeliverDetailVO deliverDetailVO);

	public Boolean deleteDeliverDetailVOByID(Long id);

	public List<DeliverDetailVO> getDeliverDetailVOByOutgoingID(Long id);

	public Boolean batchAddDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs);

	public Boolean batchModifyDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs);

	public Boolean batchDeleteDeliverDetailVO(
			List<DeliverDetailVO> deliverDetailVOs);

	public Boolean batchDeleteDeliverDetailVOByID(List<Long> deliverDetailIDs);

}
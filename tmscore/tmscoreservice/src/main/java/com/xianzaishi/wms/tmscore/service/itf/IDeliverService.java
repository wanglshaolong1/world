package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliverVO;
import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;

public interface IDeliverService {

	public Long addDeliverVO(DeliverVO deliverVO);

	public List<DeliverVO> queryDeliverVOList(DeliverQueryVO deliverQueryVO);

	public DeliverVO getDeliverVOByID(Long id);

	public Boolean modifyDeliverVO(DeliverVO deliverVO);

	public Boolean deleteDeliverVOByID(Long id);

	public DeliverVO assign(DeliverVO deliverVO);

}
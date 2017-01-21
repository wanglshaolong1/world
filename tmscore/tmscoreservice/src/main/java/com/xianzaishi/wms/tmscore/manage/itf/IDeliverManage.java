package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliverQueryVO;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;

public interface IDeliverManage {

	public Long addDeliverVO(DeliverVO deliverVO);

	public List<DeliverVO> queryDeliverVOList(DeliverQueryVO deliverQueryVO);

	public DeliverVO getDeliverVOByID(Long id);

	public Boolean modifyDeliverVO(DeliverVO deliverVO);

	public Boolean deleteDeliverVOByID(Long id);

	public DeliverVO assign(DeliverVO deliverVO);

}
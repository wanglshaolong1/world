package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliveryAreaVO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaDO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaQueryVO;

public interface IDeliveryAreaManage {

	public Boolean addDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO);

	public List<DeliveryAreaVO> queryDeliveryAreaVOList(DeliveryAreaQueryVO deliveryAreaQueryVO);

	public DeliveryAreaVO getDeliveryAreaVOByID(Long id);

	public Boolean modifyDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO);

	public Boolean deleteDeliveryAreaVOByID(Long id);

}
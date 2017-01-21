package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DeliveryAreaVO;
import com.xianzaishi.wms.tmscore.vo.DeliveryAreaQueryVO;

public interface IDeliveryAreaService {

	public Boolean addDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO);

	public List<DeliveryAreaVO> queryDeliveryAreaVOList(DeliveryAreaQueryVO deliveryAreaQueryVO);

	public DeliveryAreaVO getDeliveryAreaVOByID(Long id);

	public Boolean modifyDeliveryAreaVO(DeliveryAreaVO deliveryAreaVO);

	public Boolean deleteDeliveryAreaVOByID(Long id);

}
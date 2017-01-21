package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;

public interface IPickingBasketStatuService {

	public Boolean addPickingBasketStatuVO(
			PickingBasketStatuVO pickingBasketStatuVO);

	public List<PickingBasketStatuVO> queryPickingBasketStatuVOList(
			PickingBasketStatuQueryVO pickingBasketStatuQueryVO);

	public PickingBasketStatuVO getPickingBasketStatuVOByID(Long id);

	public Boolean modifyPickingBasketStatuVO(
			PickingBasketStatuVO pickingBasketStatuVO);

	public Boolean deletePickingBasketStatuVOByID(Long id);

	public void assign(Long pickID, List<Long> basketIDs);
}
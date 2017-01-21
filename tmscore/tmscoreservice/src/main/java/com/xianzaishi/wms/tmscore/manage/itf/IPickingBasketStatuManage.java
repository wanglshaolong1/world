package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuVO;

public interface IPickingBasketStatuManage {

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
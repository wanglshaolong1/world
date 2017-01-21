package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingBasketQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public interface IPickingBasketManage {

	public Boolean addPickingBasketVO(PickingBasketVO pickingBasketVO);

	public List<PickingBasketVO> queryPickingBasketVOList(
			PickingBasketQueryVO pickingBasketQueryVO);

	public PickingBasketVO getPickingBasketVOByID(Long id);

	public Boolean modifyPickingBasketVO(PickingBasketVO pickingBasketVO);

	public Boolean deletePickingBasketVOByID(Long id);

}
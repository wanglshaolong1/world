package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketQueryVO;

public interface IPickingBasketService {

	public Boolean addPickingBasketVO(PickingBasketVO pickingBasketVO);

	public List<PickingBasketVO> queryPickingBasketVOList(PickingBasketQueryVO pickingBasketQueryVO);

	public PickingBasketVO getPickingBasketVOByID(Long id);

	public Boolean modifyPickingBasketVO(PickingBasketVO pickingBasketVO);

	public Boolean deletePickingBasketVOByID(Long id);

}
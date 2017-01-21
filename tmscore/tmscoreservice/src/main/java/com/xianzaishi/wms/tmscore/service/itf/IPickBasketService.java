package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickBasketVO;
import com.xianzaishi.wms.tmscore.vo.PickBasketQueryVO;

public interface IPickBasketService {

	public Boolean addPickBasketVO(PickBasketVO pickBasketVO);

	public List<PickBasketVO> queryPickBasketVOList(
			PickBasketQueryVO pickBasketQueryVO);

	public PickBasketVO getPickBasketVOByID(Long id);

	public Boolean modifyPickBasketVO(PickBasketVO pickBasketVO);

	public Boolean deletePickBasketVOByID(Long id);
}
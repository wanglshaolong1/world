package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickBasketQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickBasketVO;

public interface IPickBasketManage {

	public Boolean addPickBasketVO(PickBasketVO pickBasketVO);

	public List<PickBasketVO> queryPickBasketVOList(
			PickBasketQueryVO pickBasketQueryVO);

	public PickBasketVO getPickBasketVOByID(Long id);

	public Boolean modifyPickBasketVO(PickBasketVO pickBasketVO);

	public Boolean deletePickBasketVOByID(Long id);

}
package com.xianzaishi.wms.tmscore.domain.client.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public interface IPickingBasketDomainClient {

	public SimpleResultVO<Boolean> addPickingBasketVO(
			PickingBasketVO pickingBasketVO);

	public SimpleResultVO<PickingBasketVO> getPickingBasketVOByBarcode(
			String barcode);

	public SimpleResultVO<PickingBasketVO> getPickingBasketVOByID(Long id);

	public SimpleResultVO<List<PickingBasketVO>> batchGetPickingBasketVOByBarcode(
			List<String> barcodes);

	public SimpleResultVO<List<PickingBasketVO>> batchGetPickingBasketVOByID(
			List<Long> ids);
}

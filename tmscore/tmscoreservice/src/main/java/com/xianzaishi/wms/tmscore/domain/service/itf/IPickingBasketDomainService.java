package com.xianzaishi.wms.tmscore.domain.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public interface IPickingBasketDomainService {

	public Boolean addPickingBasketVO(PickingBasketVO pickingBasketVO);

	public PickingBasketVO getPickingBasketVOByBarcode(String barcode);

	public PickingBasketVO getPickingBasketVOByID(Long id);

	public List<PickingBasketVO> batchGetPickingBasketVOByBarcode(
			List<String> barcodes) throws Exception;

	public List<PickingBasketVO> batchGetPickingBasketVOByID(List<Long> ids)
			throws Exception;
}

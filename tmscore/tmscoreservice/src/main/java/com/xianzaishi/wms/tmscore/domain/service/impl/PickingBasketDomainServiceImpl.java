package com.xianzaishi.wms.tmscore.domain.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.barcode.domain.client.itf.IBarcodeSequenceDomainClient;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickingBasketDomainService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingBasketService;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketVO;

public class PickingBasketDomainServiceImpl implements
		IPickingBasketDomainService {
	@Autowired
	private IBarcodeSequenceDomainClient barcodeSequenceDomainClient = null;
	@Autowired
	private IPickingBasketService pickingBasketService = null;

	public Boolean addPickingBasketVO(PickingBasketVO pickingBasketVO) {
		pickingBasketVO.setBarcode(barcodeSequenceDomainClient.getBarcode(2)
				.getTarget());
		return pickingBasketService.addPickingBasketVO(pickingBasketVO);
	}

	public IBarcodeSequenceDomainClient getBarcodeSequenceDomainClient() {
		return barcodeSequenceDomainClient;
	}

	public void setBarcodeSequenceDomainClient(
			IBarcodeSequenceDomainClient barcodeSequenceDomainClient) {
		this.barcodeSequenceDomainClient = barcodeSequenceDomainClient;
	}

	public IPickingBasketService getPickingBasketService() {
		return pickingBasketService;
	}

	public void setPickingBasketService(
			IPickingBasketService pickingBasketService) {
		this.pickingBasketService = pickingBasketService;
	}

	public PickingBasketVO getPickingBasketVOByBarcode(String barcode) {
		PickingBasketQueryVO pickingBasketQueryVO = new PickingBasketQueryVO();
		pickingBasketQueryVO.setBarcode(barcode);
		List<PickingBasketVO> pickingWallPositionVOs = pickingBasketService
				.queryPickingBasketVOList(pickingBasketQueryVO);
		if (pickingWallPositionVOs == null
				|| pickingWallPositionVOs.size() != 1) {
			throw new BizException("获取仓库位错误:{barcode:" + barcode + "}");
		}
		return pickingWallPositionVOs.get(0);
	}

	public PickingBasketVO getPickingBasketVOByID(Long id) {
		return pickingBasketService.getPickingBasketVOByID(id);
	}

	public List<PickingBasketVO> batchGetPickingBasketVOByBarcode(
			List<String> barcodes) throws Exception {
		if (barcodes == null && barcodes.isEmpty()) {
			throw new Exception("barcodes is empty");
		}
		List<PickingBasketVO> pickingBasketVOs = new LinkedList<PickingBasketVO>();
		for (String barcode : barcodes) {
			pickingBasketVOs.add(getPickingBasketVOByBarcode(barcode));
		}
		return pickingBasketVOs;
	}

	public List<PickingBasketVO> batchGetPickingBasketVOByID(List<Long> ids)
			throws Exception {
		if (ids == null && ids.isEmpty()) {
			throw new Exception("ids is empty");
		}
		List<PickingBasketVO> pickingBasketVOs = new LinkedList<PickingBasketVO>();
		for (Long id : ids) {
			pickingBasketVOs.add(getPickingBasketVOByID(id));
		}
		return pickingBasketVOs;
	}
}

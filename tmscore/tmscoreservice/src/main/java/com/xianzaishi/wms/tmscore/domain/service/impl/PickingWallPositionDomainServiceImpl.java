package com.xianzaishi.wms.tmscore.domain.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.barcode.domain.client.itf.IBarcodeSequenceDomainClient;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.domain.service.itf.IPickingWallPositionDomainService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionService;
import com.xianzaishi.wms.tmscore.service.itf.IPickingWallPositionStatuService;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionVO;

public class PickingWallPositionDomainServiceImpl implements
		IPickingWallPositionDomainService {
	@Autowired
	private IBarcodeSequenceDomainClient barcodeSequenceDomainClient = null;
	@Autowired
	private IPickingWallPositionService pickingWallPositionService = null;
	@Autowired
	private IPickingWallPositionStatuService pickingWallPositionStatuService = null;

	public List<PickingWallPositionVO> getPickingWallPositionByWaveID(
			Long waveID) {
		PickingWallPositionStatuQueryVO pickingWallPositionStatuQueryVO = new PickingWallPositionStatuQueryVO();
		pickingWallPositionStatuQueryVO.setAssignmentId(waveID);
		List<PickingWallPositionStatuVO> pickingWallPositionStatuVOs = pickingWallPositionStatuService
				.queryPickingWallPositionStatuVOList(pickingWallPositionStatuQueryVO);
		List<PickingWallPositionVO> pickingWallPositions = new LinkedList<PickingWallPositionVO>();
		if (pickingWallPositionStatuVOs != null
				&& !pickingWallPositionStatuVOs.isEmpty()) {
			for (PickingWallPositionStatuVO pickingWallPositionStatuVO : pickingWallPositionStatuVOs) {
				pickingWallPositions
						.add(pickingWallPositionService
								.getPickingWallPositionVOByID(pickingWallPositionStatuVO
										.getWallPositionId()));
			}
		}
		return pickingWallPositions;
	}

	public Boolean addPickingWallPositionVO(
			PickingWallPositionVO pickingWallPositionVO) {
		pickingWallPositionVO.setBarcode(barcodeSequenceDomainClient
				.getBarcode(3).getTarget());
		return pickingWallPositionService
				.addPickingWallPositionVO(pickingWallPositionVO);
	}

	public IPickingWallPositionService getPickingWallPositionService() {
		return pickingWallPositionService;
	}

	public void setPickingWallPositionService(
			IPickingWallPositionService pickingWallPositionService) {
		this.pickingWallPositionService = pickingWallPositionService;
	}

	public IBarcodeSequenceDomainClient getBarcodeSequenceDomainClient() {
		return barcodeSequenceDomainClient;
	}

	public void setBarcodeSequenceDomainClient(
			IBarcodeSequenceDomainClient barcodeSequenceDomainClient) {
		this.barcodeSequenceDomainClient = barcodeSequenceDomainClient;
	}

	public PickingWallPositionVO getPickingWallPositionVOByBarcode(
			String barcode) {
		PickingWallPositionQueryVO pickingWallPositionQueryVO = new PickingWallPositionQueryVO();
		pickingWallPositionQueryVO.setBarcode(barcode);
		List<PickingWallPositionVO> pickingWallPositionVOs = pickingWallPositionService
				.queryPickingWallPositionVOList(pickingWallPositionQueryVO);
		if (pickingWallPositionVOs == null
				|| pickingWallPositionVOs.size() != 1) {
			throw new BizException("获取仓库位错误:{barcode:" + barcode + "}");
		}
		return pickingWallPositionVOs.get(0);
	}

	public PickingWallPositionVO getPickingWallPositionVOByID(Long id) {
		return pickingWallPositionService.getPickingWallPositionVOByID(id);
	}

	public List<PickingWallPositionVO> batchGetPickingWallPositionVOByBarcode(
			List<String> barcodes) throws Exception {
		if (barcodes == null && barcodes.isEmpty()) {
			throw new Exception("barcodes is empty");
		}
		List<PickingWallPositionVO> pickingWallPositionVOs = new LinkedList<PickingWallPositionVO>();
		for (String barcode : barcodes) {
			pickingWallPositionVOs
					.add(getPickingWallPositionVOByBarcode(barcode));
		}
		return pickingWallPositionVOs;
	}

	public List<PickingWallPositionVO> batchGetPickingWallPositionVOByID(
			List<Long> ids) throws Exception {
		if (ids == null && ids.isEmpty()) {
			throw new Exception("ids is empty");
		}
		List<PickingWallPositionVO> pickingWallPositionVOs = new LinkedList<PickingWallPositionVO>();
		for (Long id : ids) {
			pickingWallPositionVOs.add(getPickingWallPositionVOByID(id));
		}
		return pickingWallPositionVOs;
	}

	public IPickingWallPositionStatuService getPickingWallPositionStatuService() {
		return pickingWallPositionStatuService;
	}

	public void setPickingWallPositionStatuService(
			IPickingWallPositionStatuService pickingWallPositionStatuService) {
		this.pickingWallPositionStatuService = pickingWallPositionStatuService;
	}

}

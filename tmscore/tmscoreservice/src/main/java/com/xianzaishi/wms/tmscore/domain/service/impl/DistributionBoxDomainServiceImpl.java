package com.xianzaishi.wms.tmscore.domain.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xianzaishi.wms.barcode.domain.client.itf.IBarcodeSequenceDomainClient;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.domain.service.itf.IDistributionBoxDomainService;
import com.xianzaishi.wms.tmscore.service.itf.IDistributionBoxService;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;

public class DistributionBoxDomainServiceImpl implements
		IDistributionBoxDomainService {
	@Autowired
	private IBarcodeSequenceDomainClient barcodeSequenceDomainClient = null;
	@Autowired
	private IDistributionBoxService distributionBoxService = null;

	public Boolean addDistributionBoxVO(DistributionBoxVO distributionBoxVO) {
		distributionBoxVO.setBarcode(barcodeSequenceDomainClient.getBarcode(4)
				.getTarget());
		return distributionBoxService.addDistributionBoxVO(distributionBoxVO);
	}

	public IBarcodeSequenceDomainClient getBarcodeSequenceDomainClient() {
		return barcodeSequenceDomainClient;
	}

	public void setBarcodeSequenceDomainClient(
			IBarcodeSequenceDomainClient barcodeSequenceDomainClient) {
		this.barcodeSequenceDomainClient = barcodeSequenceDomainClient;
	}

	public IDistributionBoxService getDistributionBoxService() {
		return distributionBoxService;
	}

	public void setDistributionBoxService(
			IDistributionBoxService distributionBoxService) {
		this.distributionBoxService = distributionBoxService;
	}

	public DistributionBoxVO getDistributionBoxVOByBarcode(String barcode) {
		DistributionBoxQueryVO distributionBoxQueryVO = new DistributionBoxQueryVO();
		distributionBoxQueryVO.setBarcode(barcode);
		List<DistributionBoxVO> distributionBoxQueryVOs = distributionBoxService
				.queryDistributionBoxVOList(distributionBoxQueryVO);
		if (distributionBoxQueryVOs == null
				|| distributionBoxQueryVOs.size() != 1) {
			throw new BizException("获取仓库位错误:{barcode:" + barcode + "}");
		}
		return distributionBoxQueryVOs.get(0);
	}

	public DistributionBoxVO getDistributionBoxVOByID(Long id) {
		return distributionBoxService.getDistributionBoxVOByID(id);
	}

	public List<DistributionBoxVO> batchGetDistributionBoxVOByBarcode(
			List<String> barcodes) throws Exception {
		if (barcodes == null && barcodes.isEmpty()) {
			throw new Exception("barcodes is empty");
		}
		List<DistributionBoxVO> distributionBoxVOs = new LinkedList<DistributionBoxVO>();
		for (String barcode : barcodes) {
			distributionBoxVOs.add(getDistributionBoxVOByBarcode(barcode));
		}
		return distributionBoxVOs;
	}

	public List<DistributionBoxVO> batchGetDistributionBoxVOByID(List<Long> ids)
			throws Exception {
		if (ids == null && ids.isEmpty()) {
			throw new Exception("ids is empty");
		}
		List<DistributionBoxVO> distributionBoxVOs = new LinkedList<DistributionBoxVO>();
		for (Long id : ids) {
			distributionBoxVOs.add(getDistributionBoxVOByID(id));
		}
		return distributionBoxVOs;
	}

}

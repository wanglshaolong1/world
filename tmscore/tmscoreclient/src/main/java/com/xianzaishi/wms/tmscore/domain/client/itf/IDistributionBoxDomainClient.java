package com.xianzaishi.wms.tmscore.domain.client.itf;

import java.util.List;

import com.xianzaishi.wms.common.vo.SimpleResultVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;

public interface IDistributionBoxDomainClient {

	public SimpleResultVO<Boolean> addDistributionBoxVO(
			DistributionBoxVO distributionBoxVO);

	public SimpleResultVO<DistributionBoxVO> getDistributionBoxVOByBarcode(
			String barcode);

	public SimpleResultVO<DistributionBoxVO> getDistributionBoxVOByID(Long id);

	public SimpleResultVO<List<DistributionBoxVO>> batchGetDistributionBoxVOByBarcode(
			List<String> barcodes);

	public SimpleResultVO<List<DistributionBoxVO>> batchGetDistributionBoxVOByID(
			List<Long> ids);

}

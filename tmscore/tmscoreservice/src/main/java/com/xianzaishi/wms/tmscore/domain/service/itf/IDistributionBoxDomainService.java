package com.xianzaishi.wms.tmscore.domain.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;

public interface IDistributionBoxDomainService {

	public Boolean addDistributionBoxVO(DistributionBoxVO distributionBoxVO);

	public DistributionBoxVO getDistributionBoxVOByBarcode(String barcode);

	public DistributionBoxVO getDistributionBoxVOByID(Long id);

	public List<DistributionBoxVO> batchGetDistributionBoxVOByBarcode(
			List<String> barcodes) throws Exception;

	public List<DistributionBoxVO> batchGetDistributionBoxVOByID(List<Long> ids)
			throws Exception;
}

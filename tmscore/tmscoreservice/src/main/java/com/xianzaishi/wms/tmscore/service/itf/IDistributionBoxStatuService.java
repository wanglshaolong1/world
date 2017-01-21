package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuQueryVO;

public interface IDistributionBoxStatuService {

	public Boolean addDistributionBoxStatuVO(
			DistributionBoxStatuVO distributionBoxStatuVO);

	public List<DistributionBoxStatuVO> queryDistributionBoxStatuVOList(
			DistributionBoxStatuQueryVO distributionBoxStatuQueryVO);

	public DistributionBoxStatuVO getDistributionBoxStatuVOByID(Long id);

	public Boolean modifyDistributionBoxStatuVO(
			DistributionBoxStatuVO distributionBoxStatuVO);

	public Boolean deleteDistributionBoxStatuVOByID(Long id);

	public void assign(Long deliverID, Long boxID);

	public void release(DistributionBoxStatuVO distributionBoxStatuVO);

}
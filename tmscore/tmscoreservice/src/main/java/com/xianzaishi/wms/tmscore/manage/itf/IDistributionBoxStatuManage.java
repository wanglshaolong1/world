package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuDO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuQueryVO;

public interface IDistributionBoxStatuManage {

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
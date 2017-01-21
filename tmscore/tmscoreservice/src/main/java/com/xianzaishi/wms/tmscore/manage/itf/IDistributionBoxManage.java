package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;

public interface IDistributionBoxManage {

	public Boolean addDistributionBoxVO(DistributionBoxVO distributionBoxVO);

	public List<DistributionBoxVO> queryDistributionBoxVOList(
			DistributionBoxQueryVO distributionBoxQueryVO);

	public DistributionBoxVO getDistributionBoxVOByID(Long id);

	public Boolean modifyDistributionBoxVO(DistributionBoxVO distributionBoxVO);

	public Boolean deleteDistributionBoxVOByID(Long id);

}
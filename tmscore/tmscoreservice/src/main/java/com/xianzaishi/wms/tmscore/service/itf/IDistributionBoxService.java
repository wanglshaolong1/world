package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionBoxVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxQueryVO;

public interface IDistributionBoxService {

	public Boolean addDistributionBoxVO(DistributionBoxVO distributionBoxVO);

	public List<DistributionBoxVO> queryDistributionBoxVOList(DistributionBoxQueryVO distributionBoxQueryVO);

	public DistributionBoxVO getDistributionBoxVOByID(Long id);

	public Boolean modifyDistributionBoxVO(DistributionBoxVO distributionBoxVO);

	public Boolean deleteDistributionBoxVOByID(Long id);

}
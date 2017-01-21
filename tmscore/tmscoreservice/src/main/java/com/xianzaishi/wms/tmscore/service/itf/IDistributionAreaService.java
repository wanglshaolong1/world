package com.xianzaishi.wms.tmscore.service.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;

public interface IDistributionAreaService {

	public Boolean addDistributionAreaVO(DistributionAreaVO distributionAreaVO);

	public List<DistributionAreaVO> queryDistributionAreaVOList(
			DistributionAreaQueryVO distributionAreaQueryVO);

	public DistributionAreaVO getDistributionAreaVOByID(Long id);

	public Boolean modifyDistributionAreaVO(
			DistributionAreaVO distributionAreaVO);

	public Boolean deleteDistributionAreaVOByID(Long id);

	public List<DistributionAreaVO> getArea(DistributionAreaQueryVO queryVO);

}
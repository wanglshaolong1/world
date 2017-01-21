package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;

public interface IDistributionAreaManage {

	public Boolean addDistributionAreaVO(DistributionAreaVO distributionAreaVO);

	public List<DistributionAreaVO> queryDistributionAreaVOList(
			DistributionAreaQueryVO distributionAreaQueryVO);

	public DistributionAreaVO getDistributionAreaVOByID(Long id);

	public Boolean modifyDistributionAreaVO(
			DistributionAreaVO distributionAreaVO);

	public Boolean deleteDistributionAreaVOByID(Long id);

	public List<DistributionAreaVO> getArea(DistributionAreaQueryVO queryVO);

}
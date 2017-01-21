package com.xianzaishi.wms.tmscore.manage.itf;

import java.util.List;

import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonVO;
import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonDO;
import com.xianzaishi.wms.tmscore.vo.DistributionCloseReasonQueryVO;

public interface IDistributionCloseReasonManage {

	public Boolean addDistributionCloseReasonVO(DistributionCloseReasonVO distributionCloseReasonVO);

	public List<DistributionCloseReasonVO> queryDistributionCloseReasonVOList(DistributionCloseReasonQueryVO distributionCloseReasonQueryVO);

	public DistributionCloseReasonVO getDistributionCloseReasonVOByID(Long id);

	public Boolean modifyDistributionCloseReasonVO(DistributionCloseReasonVO distributionCloseReasonVO);

	public Boolean deleteDistributionCloseReasonVOByID(Long id);

}
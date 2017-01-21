package com.xianzaishi.wms.tmscore.dao.itf;

import java.util.List;

import com.xianzaishi.wms.common.dao.itf.IBaseDao;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;

public interface IDistributionAreaDao extends IBaseDao {

	public List<DistributionAreaVO> getArea(DistributionAreaQueryVO queryVO);

}
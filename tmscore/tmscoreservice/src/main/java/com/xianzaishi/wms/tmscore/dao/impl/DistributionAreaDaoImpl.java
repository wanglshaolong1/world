package com.xianzaishi.wms.tmscore.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xianzaishi.wms.tmscore.dao.itf.IDistributionAreaDao;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionAreaVO;
import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;

public class DistributionAreaDaoImpl extends BaseDaoAdapter implements
		IDistributionAreaDao {
	private final Log log = LogFactory.getLog(DistributionAreaDaoImpl.class);

	public String getVOClassName() {
		return "DistributionAreaDO";
	}

	public List<DistributionAreaVO> getArea(DistributionAreaQueryVO queryVO) {
		List<DistributionAreaVO> flag = new LinkedList<DistributionAreaVO>();
		try {
			flag = (List<DistributionAreaVO>) simpleSqlMapClientTemplate
					.queryForList(getVOClassName() + ".getArea", queryVO);
		} catch (Exception e) {
			log.error("查询数据失败。", e);
			throw new BizException("查询数据失败。", e);
		}
		return flag;
	}
}

package com.xianzaishi.wms.tmscore.dao.impl;

import java.util.Date;
import java.util.List;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionBoxStatuDao;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.DistributionBoxStatuVO;

public class DistributionBoxStatuDaoImpl extends BaseDaoAdapter implements
		IDistributionBoxStatuDao {
	public String getVOClassName() {
		return "DistributionBoxStatuDO";
	}

	public void assign(Long deliverID, Long boxID) {
		DistributionBoxStatuQueryVO queryVO = new DistributionBoxStatuQueryVO();
		queryVO.setBoxId(boxID);
		List<DistributionBoxStatuVO> statuVOs = queryDO(queryVO);
		DistributionBoxStatuVO statuVO = null;
		if (statuVOs != null && statuVOs.size() > 0) {
			statuVO = statuVOs.get(0);
		} else {
			statuVO = new DistributionBoxStatuVO();
		}
		statuVO.setAssignmentId(deliverID);
		statuVO.setUsed(Short.parseShort("1"));
		statuVO.setStartTime(new Date(System.currentTimeMillis()));
		statuVO.setBoxId(boxID);
		if (statuVO.getId() == null) {
			addDO(statuVO);
		} else {
			updateDO(statuVO);
		}
	}

	public void release(DistributionBoxStatuVO distributionBoxStatuVO) {
		try {
			simpleSqlMapClientTemplate.update(getVOClassName() + ".release",
					distributionBoxStatuVO);
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
	}
}

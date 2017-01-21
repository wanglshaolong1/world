package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.ITimingDistributionWatiSeqDao;
import com.xianzaishi.wms.tmscore.vo.TimingDistributionWatiSeqVO;

public class TimingDistributionWatiSeqDaoImpl extends BaseDaoAdapter implements
		ITimingDistributionWatiSeqDao {
	public String getVOClassName() {
		return "TimingDistributionWatiSeqDO";
	}

	public boolean assign(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		Boolean flag = false;
		try {
			int no = simpleSqlMapClientTemplate.update(getVOClassName()
					+ ".assign", timingDistributionWatiSeqVO);
			if (no > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}

	public boolean assignToNormal(
			TimingDistributionWatiSeqVO timingDistributionWatiSeqVO) {
		Boolean flag = true;
		try {
			int no = simpleSqlMapClientTemplate.update(getVOClassName()
					+ ".assigntonormal", timingDistributionWatiSeqVO);
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}

	public boolean deleteByDistributionID(Long distributionID) {
		Boolean flag = false;
		try {
			if (distributionID != null && distributionID > 0) {
				simpleSqlMapClientTemplate.delete(getVOClassName()
						+ ".deleteByDistributionID", distributionID);
			}
		} catch (Exception e) {
			throw new BizException("删除数据失败。", e);
		}
		return flag;
	}
}

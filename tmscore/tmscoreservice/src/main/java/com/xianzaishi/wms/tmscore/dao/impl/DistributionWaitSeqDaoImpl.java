package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionWaitSeqDao;
import com.xianzaishi.wms.tmscore.vo.DistributionWaitSeqVO;

public class DistributionWaitSeqDaoImpl extends BaseDaoAdapter implements
		IDistributionWaitSeqDao {
	public String getVOClassName() {
		return "DistributionWaitSeqDO";
	}

	public boolean assign(DistributionWaitSeqVO distributionWaitSeqVO) {
		Boolean flag = false;
		try {
			int no = simpleSqlMapClientTemplate.update(getVOClassName()
					+ ".assign", distributionWaitSeqVO);
			if (no > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}

	public boolean assignToNormal(DistributionWaitSeqVO distributionWaitSeqVO) {
		Boolean flag = true;
		try {
			int no = simpleSqlMapClientTemplate.update(getVOClassName()
					+ ".assigntonormal", distributionWaitSeqVO);
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

package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDistributionDao;

public class DistributionDaoImpl extends BaseDaoAdapter implements
		IDistributionDao {
	public String getVOClassName() {
		return "DistributionDO";
	}

	public Boolean reset(Long id) {
		Boolean flag = false;
		try {
			if (id != null && id > 0) {
				int no = simpleSqlMapClientTemplate.update(getVOClassName()
						+ ".reset", id);
				if (no == 1) {
					flag = true;
				} else if (no > 1) {
					throw new BizException("影响的数据大于1条。");
				} else {
					throw new BizException("数据不存在。");
				}
			} else {
				throw new BizException("更新数据失败，ID错误：ID = " + id);
			}
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}
}

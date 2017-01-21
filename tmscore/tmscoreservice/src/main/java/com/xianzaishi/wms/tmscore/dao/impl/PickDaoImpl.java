package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IPickDao;
import com.xianzaishi.wms.tmscore.vo.PickVO;

public class PickDaoImpl extends BaseDaoAdapter implements IPickDao {
	public String getVOClassName() {
		return "PickDO";
	}

	public PickVO assign(PickVO pickVO) {
		PickVO flag = null;
		try {
			if (pickVO.getId() != null && pickVO.getId() > 0) {
				int no = simpleSqlMapClientTemplate.update(getVOClassName()
						+ ".assign", pickVO);
				if (no == 1) {
					flag = (PickVO) getDOByID(pickVO.getId());
				} else if (no > 1) {
					throw new BizException("影响的数据大于1条。");
				}
			} else {
				throw new BizException("更新数据失败，ID错误：ID = " + pickVO.getId());
			}
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}
}

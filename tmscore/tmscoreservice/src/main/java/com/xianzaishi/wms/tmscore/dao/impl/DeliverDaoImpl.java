package com.xianzaishi.wms.tmscore.dao.impl;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.common.exception.BizException;
import com.xianzaishi.wms.tmscore.dao.itf.IDeliverDao;
import com.xianzaishi.wms.tmscore.vo.DeliverVO;

public class DeliverDaoImpl extends BaseDaoAdapter implements IDeliverDao {
	public String getVOClassName() {
		return "DeliverDO";
	}

	public DeliverVO assign(DeliverVO deliverVO) {
		DeliverVO flag = null;
		try {
			if (deliverVO.getId() != null && deliverVO.getId() > 0) {
				int no = simpleSqlMapClientTemplate.update(getVOClassName()
						+ ".assign", deliverVO);
				if (no == 1) {
					flag = (DeliverVO) getDOByID(deliverVO.getId());
				} else if (no > 1) {
					throw new BizException("影响的数据大于1条。");
				}
			} else {
				throw new BizException("更新数据失败，ID错误：ID = " + deliverVO.getId());
			}
		} catch (Exception e) {
			throw new BizException("更新数据失败。", e);
		}
		return flag;
	}
}

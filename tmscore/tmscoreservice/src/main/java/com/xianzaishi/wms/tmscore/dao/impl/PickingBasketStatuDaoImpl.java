package com.xianzaishi.wms.tmscore.dao.impl;

import java.util.Date;
import java.util.List;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.tmscore.dao.itf.IPickingBasketStatuDao;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingBasketStatuVO;

public class PickingBasketStatuDaoImpl extends BaseDaoAdapter implements
		IPickingBasketStatuDao {
	public String getVOClassName() {
		return "PickingBasketStatuDO";
	}

	public void assign(Long pickID, List<Long> basketIDs) {
		for (int i = 0; i < basketIDs.size(); i++) {
			PickingBasketStatuQueryVO queryVO = new PickingBasketStatuQueryVO();
			queryVO.setBasketId(basketIDs.get(i));
			List<PickingBasketStatuVO> statuVOs = queryDO(queryVO);
			PickingBasketStatuVO statuVO = null;
			if (statuVOs != null && statuVOs.size() > 0) {
				statuVO = statuVOs.get(0);
			} else {
				statuVO = new PickingBasketStatuVO();
			}
			statuVO.setAssignmentId(pickID);
			statuVO.setUsed(Short.parseShort("1"));
			statuVO.setStartTime(new Date(System.currentTimeMillis()));
			statuVO.setBasketId((Long) basketIDs.get(0));
			statuVO.setStatu(0);
			if (statuVO.getId() == null) {
				addDO(statuVO);
			} else {
				updateDO(statuVO);
			}
		}
	}
}

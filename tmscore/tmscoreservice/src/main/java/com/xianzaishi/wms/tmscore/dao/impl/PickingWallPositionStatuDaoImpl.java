package com.xianzaishi.wms.tmscore.dao.impl;

import java.util.Date;
import java.util.List;

import com.xianzaishi.wms.common.dao.impl.BaseDaoAdapter;
import com.xianzaishi.wms.tmscore.dao.itf.IPickingWallPositionStatuDao;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuQueryVO;
import com.xianzaishi.wms.tmscore.vo.PickingWallPositionStatuVO;

public class PickingWallPositionStatuDaoImpl extends BaseDaoAdapter implements
		IPickingWallPositionStatuDao {
	public String getVOClassName() {
		return "PickingWallPositionStatuDO";
	}

	public void assign(Long waveID, Long positionID) {
		PickingWallPositionStatuQueryVO queryVO = new PickingWallPositionStatuQueryVO();
		queryVO.setWallPositionId(positionID);
		List<PickingWallPositionStatuVO> statuVOs = queryDO(queryVO);
		PickingWallPositionStatuVO statuVO = null;
		if (statuVOs != null && statuVOs.size() > 0) {
			statuVO = statuVOs.get(0);
		} else {
			statuVO = new PickingWallPositionStatuVO();
		}
		statuVO.setAssignmentId(waveID);
		statuVO.setUsed(Short.parseShort("1"));
		statuVO.setStartTime(new Date(System.currentTimeMillis()));
		statuVO.setWallPositionId(positionID);
		if (statuVO.getId() == null) {
			addDO(statuVO);
		} else {
			updateDO(statuVO);
		}
	}
}

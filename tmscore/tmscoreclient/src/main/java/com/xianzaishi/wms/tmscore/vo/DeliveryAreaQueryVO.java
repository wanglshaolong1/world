package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DeliveryAreaQueryVO extends QueryVO implements Serializable {

	private Long deiliverierId = null;

	private Long areaId = null;

	public Long getDeiliverierId() {
		return deiliverierId;
	}

	public void setDeiliverierId(Long deiliverierId) {
		this.deiliverierId = deiliverierId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
}
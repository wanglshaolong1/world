package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.BaseVO;

public class PickBasketVO extends BaseVO implements Serializable {

	private Long pickId = null;

	private Long agencyId = null;

	private Long basketId = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPickId() {
		return pickId;
	}

	public void setPickId(Long pickId) {
		this.pickId = pickId;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}

}
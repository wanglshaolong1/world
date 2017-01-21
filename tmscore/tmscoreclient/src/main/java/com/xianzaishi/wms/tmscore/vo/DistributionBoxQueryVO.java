package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DistributionBoxQueryVO extends QueryVO implements Serializable {

	private Long agencyId = null;

	private String code = null;

	private String barcode = null;

	private Short storeType = null;

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Short getStoreType() {
		return storeType;
	}

	public void setStoreType(Short storeType) {
		this.storeType = storeType;
	}
}
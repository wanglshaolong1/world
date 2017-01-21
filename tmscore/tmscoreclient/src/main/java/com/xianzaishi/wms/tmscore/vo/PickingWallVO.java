package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.BaseVO;

public class PickingWallVO extends BaseVO implements Serializable {
	private Long agencyId = null;

	private String code = null;

	private String barcode = null;

	private Integer allRow = null;

	private Integer allColumn = null;

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

	public Integer getAllRow() {
		return allRow;
	}

	public void setAllRow(Integer allRow) {
		this.allRow = allRow;
	}

	public Integer getAllColumn() {
		return allColumn;
	}

	public void setAllColumn(Integer allColumn) {
		this.allColumn = allColumn;
	}

}
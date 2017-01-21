package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;

import com.xianzaishi.wms.common.vo.BaseVO;

public class PickingWallPositionVO extends BaseVO implements Serializable {

	private Long wallId = null;

	private Long agencyId = null;

	private String code = null;

	private String barcode = null;

	private Integer rowNo = null;

	private Integer columnNo = null;

	public Long getWallId() {
		return wallId;
	}

	public void setWallId(Long wallId) {
		this.wallId = wallId;
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

	public Integer getRowNo() {
		return rowNo;
	}

	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}

	public Integer getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(Integer columnNo) {
		this.columnNo = columnNo;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}
}
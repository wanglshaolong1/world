package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.BaseVO;

public class PickingWallPositionStatuVO extends BaseVO implements Serializable {
	private Long wallPositionId = null;

	private String wallPositionBarcode = null;

	private Short used = null;

	private Date startTime = null;

	private Long assignmentId = null;

	public Long getWallPositionId() {
		return wallPositionId;
	}

	public void setWallPositionId(Long wallPositionId) {
		this.wallPositionId = wallPositionId;
	}

	public Short getUsed() {
		return used;
	}

	public void setUsed(Short used) {
		this.used = used;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getWallPositionBarcode() {
		return wallPositionBarcode;
	}

	public void setWallPositionBarcode(String wallPositionBarcode) {
		this.wallPositionBarcode = wallPositionBarcode;
	}

}
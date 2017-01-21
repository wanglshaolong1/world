package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class PickingWallPositionStatuQueryVO extends QueryVO implements
		Serializable {

	private Long agencyId = null;

	private Long wallPositionId = null;

	private Short used = null;

	private Date startTime = null;

	private Long assignmentId = null;

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

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
}
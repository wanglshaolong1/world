package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.xianzaishi.wms.common.vo.BaseVO;

public class PickVO extends BaseVO implements Serializable {

	private Long agencyId = null;

	private Long waveId = null;

	private Long areaId = null;

	private Long operator = null;

	private Date createTime = null;

	private Date finishTime = null;

	private Short statu = null;

	private List details = null;

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public List getDetails() {
		return details;
	}

	public void setDetails(List details) {
		this.details = details;
	}

	public Short getStatu() {
		return statu;
	}

	public void setStatu(Short statu) {
		this.statu = statu;
	}
}
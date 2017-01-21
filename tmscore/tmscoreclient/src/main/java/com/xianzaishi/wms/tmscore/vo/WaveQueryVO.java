package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class WaveQueryVO extends QueryVO implements Serializable {

	private Long agencyId = null;

	private Short single = null;

	private Long operator = null;

	private Integer pickup = null;

	private Long areaId = null;

	private Date createTime = null;

	private Date finishTime = null;

	private Integer statu = null;

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Short getSingle() {
		return single;
	}

	public void setSingle(Short single) {
		this.single = single;
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

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Integer getPickup() {
		return pickup;
	}

	public void setPickup(Integer pickup) {
		this.pickup = pickup;
	}

}
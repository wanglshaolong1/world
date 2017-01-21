package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;

import com.xianzaishi.wms.common.vo.BaseVO;

public class DistributionWaitSeqVO extends BaseVO implements Serializable {

	private Long agencyId = null;

	private Long distributionId = null;

	private Integer statu = null;

	private String assign = null;

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Long getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(Long distributionId) {
		this.distributionId = distributionId;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

}
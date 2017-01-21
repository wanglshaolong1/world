package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DeliverDistributionQueryVO extends QueryVO implements Serializable {

	private Long deliverId = null;

	private Long agencyId = null;

	private Long distributionId = null;

	public Long getDeliverId() {
		return deliverId;
	}

	public void setDeliverId(Long deliverId) {
		this.deliverId = deliverId;
	}

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

}
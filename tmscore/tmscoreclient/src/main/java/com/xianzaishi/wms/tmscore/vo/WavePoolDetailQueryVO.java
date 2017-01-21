package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class WavePoolDetailQueryVO extends QueryVO implements Serializable {

	private Long poolId = null;

	private Long distributionId = null;

	public Long getPoolId() {
		return poolId;
	}

	public void setPoolId(Long poolId) {
		this.poolId = poolId;
	}

	public Long getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(Long distributionId) {
		this.distributionId = distributionId;
	}

}
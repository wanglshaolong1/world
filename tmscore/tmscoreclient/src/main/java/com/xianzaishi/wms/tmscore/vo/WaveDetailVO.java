package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;

import com.xianzaishi.wms.common.vo.BaseVO;

public class WaveDetailVO extends BaseVO implements Serializable {

	private Long waveId = null;

	private Long distributionId = null;

	public Long getWaveId() {
		return waveId;
	}

	public void setWaveId(Long waveId) {
		this.waveId = waveId;
	}

	public Long getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(Long distributionId) {
		this.distributionId = distributionId;
	}

}
package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class WaveDetailQueryVO extends QueryVO implements Serializable {

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
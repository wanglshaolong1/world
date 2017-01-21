package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DistributionCloseReasonQueryVO extends QueryVO implements
		Serializable {

	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
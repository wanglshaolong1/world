package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.List;

import com.xianzaishi.wms.common.vo.BaseVO;

public class WavePoolVO extends BaseVO implements Serializable {

	private String key = null;

	private Short statu = null;

	private String assign = null;

	private Long createTime = null;

	private List<WavePoolDetailVO> details = null;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Short getStatu() {
		return statu;
	}

	public void setStatu(Short statu) {
		this.statu = statu;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public List<WavePoolDetailVO> getDetails() {
		return details;
	}

	public void setDetails(List<WavePoolDetailVO> details) {
		this.details = details;
	}

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

}
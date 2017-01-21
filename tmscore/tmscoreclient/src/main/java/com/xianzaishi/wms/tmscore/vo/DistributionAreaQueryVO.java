package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DistributionAreaQueryVO extends QueryVO implements Serializable {

	private String name = null;

	private Long agency = null;

	private Integer maxlng = null;

	private Integer minlng = null;

	private Integer maxlat = null;

	private Integer minlat = null;

	private Integer lng = null;

	private Integer lat = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAgency() {
		return agency;
	}

	public void setAgency(Long agency) {
		this.agency = agency;
	}

	public Integer getMaxlng() {
		return maxlng;
	}

	public void setMaxlng(Integer maxlng) {
		this.maxlng = maxlng;
	}

	public Integer getMinlng() {
		return minlng;
	}

	public void setMinlng(Integer minlng) {
		this.minlng = minlng;
	}

	public Integer getMaxlat() {
		return maxlat;
	}

	public void setMaxlat(Integer maxlat) {
		this.maxlat = maxlat;
	}

	public Integer getMinlat() {
		return minlat;
	}

	public void setMinlat(Integer minlat) {
		this.minlat = minlat;
	}

	public Integer getLng() {
		return lng;
	}

	public void setLng(Integer lng) {
		this.lng = lng;
	}

	public Integer getLat() {
		return lat;
	}

	public void setLat(Integer lat) {
		this.lat = lat;
	}

}
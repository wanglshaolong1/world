package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DistributionDetailQueryVO extends QueryVO implements Serializable {

	private Long distributionId = null;

	private Long agencyId = null;

	private Long skuId = null;

	private Integer allNo = null;

	private Integer orderSpec = null;

	private Integer delivedSpec = null;

	private Integer delivSpec = null;

	private Integer delivedNo = null;

	private Integer delivNo = null;

	private String saleUnit = null;

	private Long saleUnitId = null;

	private String specUnit = null;

	private Long specUnitId = null;

	private Integer spec = null;

	public Long getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(Long distributionId) {
		this.distributionId = distributionId;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Integer getAllNo() {
		return allNo;
	}

	public void setAllNo(Integer allNo) {
		this.allNo = allNo;
	}

	public Integer getDelivedNo() {
		return delivedNo;
	}

	public void setDelivedNo(Integer delivedNo) {
		this.delivedNo = delivedNo;
	}

	public Integer getDelivNo() {
		return delivNo;
	}

	public void setDelivNo(Integer delivNo) {
		this.delivNo = delivNo;
	}

	public Integer getOrderSpec() {
		return orderSpec;
	}

	public void setOrderSpec(Integer orderSpec) {
		this.orderSpec = orderSpec;
	}

	public Integer getDelivedSpec() {
		return delivedSpec;
	}

	public void setDelivedSpec(Integer delivedSpec) {
		this.delivedSpec = delivedSpec;
	}

	public Integer getDelivSpec() {
		return delivSpec;
	}

	public void setDelivSpec(Integer delivSpec) {
		this.delivSpec = delivSpec;
	}

	public String getSaleUnit() {
		return saleUnit;
	}

	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}

	public String getSpecUnit() {
		return specUnit;
	}

	public void setSpecUnit(String specUnit) {
		this.specUnit = specUnit;
	}

	public Long getSaleUnitId() {
		return saleUnitId;
	}

	public void setSaleUnitId(Long saleUnitId) {
		this.saleUnitId = saleUnitId;
	}

	public Long getSpecUnitId() {
		return specUnitId;
	}

	public void setSpecUnitId(Long specUnitId) {
		this.specUnitId = specUnitId;
	}

	public Integer getSpec() {
		return spec;
	}

	public void setSpec(Integer spec) {
		this.spec = spec;
	}

}
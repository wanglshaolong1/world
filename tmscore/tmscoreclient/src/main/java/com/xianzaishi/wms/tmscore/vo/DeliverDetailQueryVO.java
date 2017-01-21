package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DeliverDetailQueryVO extends QueryVO implements Serializable {

	private Long delivId = null;

	private Long distributionId = null;

	private Long agencyId = null;

	private Long skuId = null;

	private Long boxId = null;

	private Integer orderNo = null;

	private Integer orderSpec = null;

	private Integer distributionSpec = null;

	private Integer delivSpec = null;

	private Integer remainSpec = null;

	private Integer distributionNo = null;

	private Integer delivNo = null;

	private Integer remainNo = null;

	private String saleUnit = null;

	private Long saleUnitId = null;

	private String specUnit = null;

	private Long specUnitId = null;

	private Integer spec = null;

	public Long getDelivId() {
		return delivId;
	}

	public void setDelivId(Long delivId) {
		this.delivId = delivId;
	}

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

	public Long getBoxId() {
		return boxId;
	}

	public void setBoxId(Long boxId) {
		this.boxId = boxId;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getDistributionNo() {
		return distributionNo;
	}

	public void setDistributionNo(Integer distributionNo) {
		this.distributionNo = distributionNo;
	}

	public Integer getDelivNo() {
		return delivNo;
	}

	public void setDelivNo(Integer delivNo) {
		this.delivNo = delivNo;
	}

	public Integer getRemainNo() {
		return remainNo;
	}

	public void setRemainNo(Integer remainNo) {
		this.remainNo = remainNo;
	}

	public Integer getOrderSpec() {
		return orderSpec;
	}

	public void setOrderSpec(Integer orderSpec) {
		this.orderSpec = orderSpec;
	}

	public Integer getDistributionSpec() {
		return distributionSpec;
	}

	public void setDistributionSpec(Integer distributionSpec) {
		this.distributionSpec = distributionSpec;
	}

	public Integer getDelivSpec() {
		return delivSpec;
	}

	public void setDelivSpec(Integer delivSpec) {
		this.delivSpec = delivSpec;
	}

	public Integer getRemainSpec() {
		return remainSpec;
	}

	public void setRemainSpec(Integer remainSpec) {
		this.remainSpec = remainSpec;
	}

	public String getSaleUnit() {
		return saleUnit;
	}

	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}

	public Long getSaleUnitId() {
		return saleUnitId;
	}

	public void setSaleUnitId(Long saleUnitId) {
		this.saleUnitId = saleUnitId;
	}

	public String getSpecUnit() {
		return specUnit;
	}

	public void setSpecUnit(String specUnit) {
		this.specUnit = specUnit;
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
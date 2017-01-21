package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.xianzaishi.wms.common.vo.BaseVO;

public class DeliverDetailVO extends BaseVO implements Serializable {

	private Long delivId = null;

	private Long distributionId = null;

	private Long agencyId = null;

	private Long skuId = null;

	private Long boxId = null;

	private String orderNo = null;

	private Integer orderNoReal = null;

	private Integer orderSpec = null;

	private Integer distributionSpec = null;

	private Integer saleUnitType = null;

	private Integer delivSpec = null;

	private Integer remainSpec = null;

	private String distributionNo = null;

	private Integer distributionNoReal = null;

	private String delivNo = null;

	private String remainNo = null;

	private Integer delivNoReal = null;

	private Integer remainNoReal = null;

	private String saleUnit = null;

	private Long saleUnitId = null;

	private String specUnit = null;

	private Long specUnitId = null;

	private Integer spec = null;

	private String skuName = null;

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

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Integer getSaleUnitType() {
		return saleUnitType;
	}

	public void setSaleUnitType(Integer saleUnitType) {
		this.saleUnitType = saleUnitType;
	}

	public String getOrderNo() {
		if (orderNo == null && orderNoReal != null) {
			orderNo = new BigDecimal(orderNoReal).divide(new BigDecimal(1000))
					.toString();
		}
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderNoReal() {
		return orderNoReal;
	}

	public void setOrderNoReal(Integer orderNoReal) {
		this.orderNoReal = orderNoReal;
	}

	public String getDelivNo() {
		if (delivNo == null && delivNoReal != null) {
			delivNo = new BigDecimal(delivNoReal).divide(new BigDecimal(1000))
					.toString();
		}
		return delivNo;
	}

	public void setDelivNo(String delivNo) {
		this.delivNo = delivNo;
	}

	public String getRemainNo() {
		if (delivNo == null && delivNoReal != null) {
			delivNo = new BigDecimal(delivNoReal).divide(new BigDecimal(1000))
					.toString();
		}
		return remainNo;
	}

	public void setRemainNo(String remainNo) {
		if (remainNo == null && remainNoReal != null) {
			remainNo = new BigDecimal(remainNoReal)
					.divide(new BigDecimal(1000)).toString();
		}
		this.remainNo = remainNo;
	}

	public Integer getDelivNoReal() {
		return delivNoReal;
	}

	public void setDelivNoReal(Integer delivNoReal) {
		this.delivNoReal = delivNoReal;
	}

	public Integer getRemainNoReal() {
		return remainNoReal;
	}

	public void setRemainNoReal(Integer remainNoReal) {
		this.remainNoReal = remainNoReal;
	}

	public void init() {
		if (orderNoReal == null && orderNo != null && !orderNo.isEmpty()) {
			orderNoReal = new BigDecimal(orderNo)
					.multiply(new BigDecimal(1000)).intValue();
		}

		if (delivNoReal == null && delivNo != null && !delivNo.isEmpty()) {
			delivNoReal = new BigDecimal(delivNo)
					.multiply(new BigDecimal(1000)).intValue();
		}

		if (remainNoReal == null && remainNo != null && !remainNo.isEmpty()) {
			remainNoReal = new BigDecimal(remainNo).multiply(
					new BigDecimal(1000)).intValue();
		}

		if (distributionNoReal == null && distributionNo != null && !distributionNo.isEmpty()) {
			distributionNoReal = new BigDecimal(distributionNo).multiply(
					new BigDecimal(1000)).intValue();
		}

	}

	public String getDistributionNo() {
		if (distributionNo == null && distributionNoReal != null) {
			distributionNo = new BigDecimal(distributionNoReal).divide(
					new BigDecimal(1000)).toString();
		}
		return distributionNo;
	}

	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}

	public Integer getDistributionNoReal() {
		return distributionNoReal;
	}

	public void setDistributionNoReal(Integer distributionNoReal) {
		this.distributionNoReal = distributionNoReal;
	}
}
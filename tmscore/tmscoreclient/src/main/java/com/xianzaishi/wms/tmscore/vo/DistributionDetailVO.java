package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.xianzaishi.wms.common.vo.BaseVO;

public class DistributionDetailVO extends BaseVO implements Serializable {

	private Long distributionId = null;

	private Long agencyId = null;

	private Long skuId = null;

	private String skuName = null;

	private String allNo = null;

	private Integer allNoReal = null;

	private Integer orderSpec = null;

	private Integer delivedSpec = null;

	private Integer delivSpec = null;

	private String delivedNo = null;

	private String delivNo = null;

	private Integer delivedNoReal = null;

	private Integer delivNoReal = null;

	private String saleUnit = null;

	private Long saleUnitId = null;

	private String specUnit = null;

	private Long specUnitId = null;

	private Integer spec = null;

	private String price = null;

	private Integer priceReal = null;

	private Integer saleUnitType = null;

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

	public String getAllNo() {
		if (allNo == null && allNoReal != null) {
			allNo = new BigDecimal(allNoReal).divide(new BigDecimal(1000))
					.toString();
		}
		return allNo;
	}

	public void setAllNo(String allNo) {
		this.allNo = allNo;
	}

	public Integer getAllNoReal() {
		return allNoReal;
	}

	public void setAllNoReal(Integer allNoReal) {
		this.allNoReal = allNoReal;
	}

	public String getDelivedNo() {
		if (delivedNo == null && delivedNoReal != null) {
			delivedNo = new BigDecimal(delivedNoReal).divide(
					new BigDecimal(1000)).toString();
		}
		return delivedNo;
	}

	public void setDelivedNo(String delivedNo) {
		this.delivedNo = delivedNo;
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

	public Integer getDelivedNoReal() {
		return delivedNoReal;
	}

	public void setDelivedNoReal(Integer delivedNoReal) {
		this.delivedNoReal = delivedNoReal;
	}

	public Integer getDelivNoReal() {
		return delivNoReal;
	}

	public void setDelivNoReal(Integer delivNoReal) {
		this.delivNoReal = delivNoReal;
	}

	public String getPrice() {
		if (price == null && priceReal != null) {
			price = new BigDecimal(priceReal).divide(new BigDecimal(100))
					.toString();
		}
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getPriceReal() {
		return priceReal;
	}

	public void setPriceReal(Integer priceReal) {
		this.priceReal = priceReal;
	}

	public void init() {
		if (allNoReal == null && allNo != null && !allNo.isEmpty()) {
			allNoReal = new BigDecimal(allNo).multiply(new BigDecimal(1000))
					.intValue();
		}

		if (delivedNoReal == null && delivedNo != null && !delivedNo.isEmpty()) {
			delivedNoReal = new BigDecimal(delivedNo).multiply(
					new BigDecimal(1000)).intValue();
		}

		if (delivNoReal == null && delivNo != null && !delivNo.isEmpty()) {
			delivNoReal = new BigDecimal(delivNo)
					.multiply(new BigDecimal(1000)).intValue();
		}

		if (priceReal == null && price != null && !price.isEmpty()) {
			priceReal = new BigDecimal(price).multiply(new BigDecimal(100))
					.intValue();
		}
	}

}
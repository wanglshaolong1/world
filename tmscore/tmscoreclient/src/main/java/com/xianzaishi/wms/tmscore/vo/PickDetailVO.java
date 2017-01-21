package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.xianzaishi.wms.common.vo.BaseVO;

public class PickDetailVO extends BaseVO implements Serializable {

	private Long pickId = null;

	private Long agencyId = null;

	private Long areaId = null;

	private Long skuId = null;

	private Short oos = null;

	private Integer orderSpec = null;

	private Integer pickedSpec = null;

	private String orderNo = null;

	private String pickedNo = null;

	private Integer orderNoReal = null;

	private Integer pickedNoReal = null;

	private Long positionId = null;

	private String skuBarcode = null;

	private String positionBarcode = null;

	private String basketBarcode = null;

	private Long basketId = null;

	private String saleUnit = null;

	private Long saleUnitId = null;

	private String specUnit = null;

	private Long specUnitId = null;

	private Integer spec = null;

	private String skuName = null;

	private String positionCode = null;

	private Integer saleUnitType = null;

	public Long getPickId() {
		return pickId;
	}

	public void setPickId(Long pickId) {
		this.pickId = pickId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Short getOos() {
		return oos;
	}

	public void setOos(Short oos) {
		this.oos = oos;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public String getSkuBarcode() {
		return skuBarcode;
	}

	public void setSkuBarcode(String skuBarcode) {
		this.skuBarcode = skuBarcode;
	}

	public String getPositionBarcode() {
		return positionBarcode;
	}

	public void setPositionBarcode(String positionBarcode) {
		this.positionBarcode = positionBarcode;
	}

	public String getBasketBarcode() {
		return basketBarcode;
	}

	public void setBasketBarcode(String basketBarcode) {
		this.basketBarcode = basketBarcode;
	}

	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Integer getOrderSpec() {
		return orderSpec;
	}

	public void setOrderSpec(Integer orderSpec) {
		this.orderSpec = orderSpec;
	}

	public Integer getPickedSpec() {
		return pickedSpec;
	}

	public void setPickedSpec(Integer pickedSpec) {
		this.pickedSpec = pickedSpec;
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

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public Integer getSaleUnitType() {
		return saleUnitType;
	}

	public void setSaleUnitType(Integer saleUnitType) {
		this.saleUnitType = saleUnitType;
	}

	public String getOrderNo() {
		if (orderNo == null && orderNoReal != null) {
			orderNo = new BigDecimal(orderNoReal).divide(new BigDecimal(100))
					.toString();
		}
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPickedNo() {
		if (pickedNo == null && pickedNoReal != null) {
			pickedNo = new BigDecimal(pickedNoReal).divide(new BigDecimal(100))
					.toString();
		}
		return pickedNo;
	}

	public void setPickedNo(String pickedNo) {
		this.pickedNo = pickedNo;
	}

	public Integer getOrderNoReal() {
		return orderNoReal;
	}

	public void setOrderNoReal(Integer orderNoReal) {
		this.orderNoReal = orderNoReal;
	}

	public Integer getPickedNoReal() {
		return pickedNoReal;
	}

	public void setPickedNoReal(Integer pickedNoReal) {
		this.pickedNoReal = pickedNoReal;
	}

	public void init() {
		if (orderNoReal == null && orderNo != null && !orderNo.isEmpty()) {
			orderNoReal = new BigDecimal(orderNo)
					.multiply(new BigDecimal(1000)).intValue();
		}

		if (pickedNoReal == null && pickedNo != null && !pickedNo.isEmpty()) {
			pickedNoReal = new BigDecimal(pickedNo).multiply(
					new BigDecimal(1000)).intValue();
		}

	}
}
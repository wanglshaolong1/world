package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;

import com.xianzaishi.wms.common.vo.QueryVO;

public class PickDetailQueryVO extends QueryVO implements Serializable {

	private Long pickId = null;

	private Long agencyId = null;

	private Long skuId = null;

	private Short oos = null;

	private Integer orderNo = null;

	private Integer orderSpec = null;

	private Integer pickedSpec = null;

	private Integer pickedNo = null;

	private Long positionId = null;

	private Long slottingId = null;

	private Long basketId = null;

	private String saleUnit = null;

	private Long saleUnitId = null;

	private String specUnit = null;

	private Long specUnitId = null;

	private Integer spec = null;

	public Long getPickId() {
		return pickId;
	}

	public void setPickId(Long pickId) {
		this.pickId = pickId;
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

	public Short getOos() {
		return oos;
	}

	public void setOos(Short oos) {
		this.oos = oos;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPickedNo() {
		return pickedNo;
	}

	public void setPickedNo(Integer pickedNo) {
		this.pickedNo = pickedNo;
	}

	public Long getPositionId() {
		return positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	public Long getSlottingId() {
		return slottingId;
	}

	public void setSlottingId(Long slottingId) {
		this.slottingId = slottingId;
	}

	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
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

}
package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.xianzaishi.wms.common.vo.BaseVO;
/**
 * 配送单列表VO
 * @author Administrator
 *
 */
public class DistributionVO extends BaseVO implements Serializable {

	private Long agencyId = null;

	private Long orderId = null;

	private Date orderTime = null;

	private Integer pickup = null;

	private Long areaId = null;

	private Short deliveryAging = null;

	private Date appointTime = null;

	private String payAmount = null;

	private Integer payAmountReal = null;

	private String userName = null;

	private Long userAddressId = null;

	private String userAddress = null;

	private String userPhone = null;

	private Integer bizStatu = null;

	private Integer closeReason = null;

	private Integer statu = null;

	private Integer rejected = null;

	private List<DistributionDetailVO> details = null;

	private Date createTime = null;

	private Date deliveredTime = null;
	
	private String desOrder = null;//订单描述
	

	public String getDesOrder() {
		return this.desOrder;
	}

	public void setDesOrder(String desOrder) {
		this.desOrder = desOrder;
	}

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Short getDeliveryAging() {
		return deliveryAging;
	}

	public void setDeliveryAging(Short deliveryAging) {
		this.deliveryAging = deliveryAging;
	}

	public Date getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDeliveredTime() {
		return deliveredTime;
	}

	public void setDeliveredTime(Date deliveredTime) {
		this.deliveredTime = deliveredTime;
	}

	public List<DistributionDetailVO> getDetails() {
		return details;
	}

	public void setDetails(List<DistributionDetailVO> details) {
		this.details = details;
	}

	public Integer getPickup() {
		return pickup;
	}

	public void setPickup(Integer pickup) {
		this.pickup = pickup;
	}

	public Integer getRejected() {
		return rejected;
	}

	public void setRejected(Integer rejected) {
		this.rejected = rejected;
	}

	public Integer getBizStatu() {
		return bizStatu;
	}

	public void setBizStatu(Integer bizStatu) {
		this.bizStatu = bizStatu;
	}

	public Integer getCloseReason() {
		return closeReason;
	}

	public void setCloseReason(Integer closeReason) {
		this.closeReason = closeReason;
	}

	public String getPayAmount() {
		if (payAmount == null && payAmountReal != null) {
			payAmount = new BigDecimal(payAmountReal).divide(
					new BigDecimal(100)).toString();
		}
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(Long userAddressId) {
		this.userAddressId = userAddressId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Integer getPayAmountReal() {
		return payAmountReal;
	}

	public void setPayAmountReal(Integer payAmountReal) {
		this.payAmountReal = payAmountReal;
	}

	public void init() {
		if (payAmountReal == null && payAmount != null && !payAmount.isEmpty()) {
			payAmountReal = new BigDecimal(payAmount).multiply(
					new BigDecimal(100)).intValue();
		}
	}
}
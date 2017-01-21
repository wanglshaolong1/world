package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.xianzaishi.wms.common.vo.QueryVO;

public class DistributionQueryVO extends QueryVO implements Serializable {

	private Long agencyId = null;

	private Long orderId = null;

	private Date orderTime = null;

	private Integer pickup = null;

	private Long areaId = null;

	private Short deliveryAging = null;

	private Date appointTime = null;

	private Integer bizStatu = null;

	private Integer closeReason = null;

	private Short statu = null;

	private Integer statuMax = null;

	private Integer bizStatuNE = null;

	private Integer rejected = null;

	private Date createTime = null;

	private Date deliveredTime = null;
	
	private String beginTime = null;
	
	private String endTime = null;
	
	private Date begin = null;
	
	private Date end = null;
	
	
	

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(null != beginTime){
			try {
				this.begin = sf.parse(beginTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(null != endTime){
			try {
				this.end = sf.parse(endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
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

	public Short getStatu() {
		return statu;
	}

	public void setStatu(Short statu) {
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

	public Integer getStatuMax() {
		return statuMax;
	}

	public void setStatuMax(Integer statuMax) {
		this.statuMax = statuMax;
	}

	public Integer getBizStatuNE() {
		return bizStatuNE;
	}

	public void setBizStatuNE(Integer bizStatuNE) {
		this.bizStatuNE = bizStatuNE;
	}

}
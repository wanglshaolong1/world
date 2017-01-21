package com.xianzaishi.wms.tmscore.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.xianzaishi.wms.common.vo.BaseVO;

public class WaveVO extends BaseVO implements Serializable {

	private Long agencyId = null;

	private Long areaId = null;

	private Integer single = null;

	private Date createTime = null;

	private Date finishTime = null;

	private Integer statu = null;

	private Integer pickup = null;

	private List<WaveDetailVO> details = null;

	private List<PickVO> pickVOs = null;

	private Long operator = null;

	private List<PickingWallPositionVO> pickingWallPositions = null;

	private Long pickingWallPositionID = null;

	private String pickingWallPositionBarcode = null;

	private String pickingWallPositionCode = null;

	private List<PickingBasketVO> pickingBaskets = null;

	private List<PickDetailVO> pickDetails = null;

	public Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	public Integer getSingle() {
		return single;
	}

	public void setSingle(Integer single) {
		this.single = single;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public List<WaveDetailVO> getDetails() {
		return details;
	}

	public void setDetails(List<WaveDetailVO> details) {
		this.details = details;
	}

	public Long getPickingWallPositionID() {
		return pickingWallPositionID;
	}

	public void setPickingWallPositionID(Long pickingWallPositionID) {
		this.pickingWallPositionID = pickingWallPositionID;
	}

	public String getPickingWallPositionBarcode() {
		return pickingWallPositionBarcode;
	}

	public void setPickingWallPositionBarcode(String pickingWallPositionBarcode) {
		this.pickingWallPositionBarcode = pickingWallPositionBarcode;
	}

	public String getPickingWallPositionCode() {
		return pickingWallPositionCode;
	}

	public void setPickingWallPositionCode(String pickingWallPositionCode) {
		this.pickingWallPositionCode = pickingWallPositionCode;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Integer getPickup() {
		return pickup;
	}

	public void setPickup(Integer pickup) {
		this.pickup = pickup;
	}

	public List<PickVO> getPickVOs() {
		return pickVOs;
	}

	public void setPickVOs(List<PickVO> pickVOs) {
		this.pickVOs = pickVOs;
	}

	public List<PickingWallPositionVO> getPickingWallPositions() {
		return pickingWallPositions;
	}

	public void setPickingWallPositions(
			List<PickingWallPositionVO> pickingWallPositions) {
		this.pickingWallPositions = pickingWallPositions;
	}

	public List<PickingBasketVO> getPickingBaskets() {
		return pickingBaskets;
	}

	public void setPickingBaskets(List<PickingBasketVO> pickingBaskets) {
		this.pickingBaskets = pickingBaskets;
	}

	public List<PickDetailVO> getPickDetails() {
		return pickDetails;
	}

	public void setPickDetails(List<PickDetailVO> pickDetails) {
		this.pickDetails = pickDetails;
	}

}
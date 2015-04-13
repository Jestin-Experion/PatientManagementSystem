package com.experion.pms.mvc.data;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.experion.pms.vo.RestrictionListVO;

public class NewRestrictionForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -169626869927070996L;
	
	private String restrictionId;
	private String restrictionName;
	private String description;
	private String status;	
	private String createdOn;
	private String createdBy;
	/*private String foodProductId;
	private String restrictionStatus;*/
	 private List<RestrictionListVO> foodRestrictions = new LinkedList<RestrictionListVO>();
	
	
	public String getRestrictionId() {
		return restrictionId;
	}
	public void setRestrictionId(String restrictionId) {
		this.restrictionId = restrictionId;
	}
	public String getRestrictionName() {
		return restrictionName;
	}
	public void setRestrictionName(String restrictionName) {
		this.restrictionName = restrictionName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<RestrictionListVO> getFoodRestrictions() {
		return foodRestrictions;
	}
	public void setFoodRestrictions(List<RestrictionListVO> foodRestrictions) {
		this.foodRestrictions = foodRestrictions;
	}
	
	
}
package com.experion.pms.vo;

public class RestrictionListVO {
	private String foodProductId;
    private String restrictionType; 
    private String restrictionListId;
    
    public RestrictionListVO(){
    	
    }
    
    
    public RestrictionListVO(String foodProductId,String restrictionType) {
    	this.foodProductId = foodProductId;
        this.restrictionType = restrictionType;
    }


	public String getFoodProductId() {
		return foodProductId;
	}


	public void setFoodProductId(String foodProductId) {
		this.foodProductId = foodProductId;
	}


	public String getRestrictionType() {
		return restrictionType;
	}


	public void setRestrictionType(String restrictionType) {
		this.restrictionType = restrictionType;
	}


	public String getRestrictionListId() {
		return restrictionListId;
	}


	public void setRestrictionListId(String restrictionListId) {
		this.restrictionListId = restrictionListId;
	}

	
	
    
    // Getter and Setter methods
}
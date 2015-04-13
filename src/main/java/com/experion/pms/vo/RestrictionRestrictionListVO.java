package com.experion.pms.vo;

import java.util.LinkedList;
import java.util.List;

import com.experion.pms.entity.Restriction;
import com.experion.pms.entity.RestrictionList;

public class RestrictionRestrictionListVO {
    Restriction restriction;
    RestrictionList restrictionList;    
    
    private List<RestrictionListVO> foodRestrictions = new LinkedList<RestrictionListVO>();

      
    
	public Restriction getRestriction() {
		return restriction;
	}


	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}


	public RestrictionList getRestrictionList() {
		return restrictionList;
	}


	public void setRestrictionList(RestrictionList restrictionList) {
		this.restrictionList = restrictionList;
	}


	public List<RestrictionListVO> getFoodRestrictions() {
		return foodRestrictions;
	}


	public void setFoodRestrictions(List<RestrictionListVO> foodRestrictions) {
		this.foodRestrictions = foodRestrictions;
	} 
    
    
    //Getter and setter
	
	
	
}
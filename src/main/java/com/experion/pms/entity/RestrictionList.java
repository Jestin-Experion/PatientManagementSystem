/**
 * 
 */
package com.experion.pms.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "RestrictionList")
public class RestrictionList implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;

	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
/*	@Column(name = "RestrictionId")
	private String restrictionId;*/
	
	@Column(name = "FoodProductId")
	private String foodProductId;
	
	@Column(name = "RestrictionType")
	private String restrictionType;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restrictionId")
	private Restriction restriction;
	
	@ManyToOne(cascade = CascadeType.ALL,optional=false)	
	@JoinColumn(name = "FoodProductId",referencedColumnName="id", insertable=false, updatable=false )
	private FoodProduct foodProduct;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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


	public Restriction getRestriction() {
		return restriction;
	}


	public void setRestriction(Restriction restriction) {
		this.restriction = restriction;
	}

	public FoodProduct getFoodProduct() {
		return foodProduct;
	}

	public void setFoodProduct(FoodProduct foodProduct) {
		this.foodProduct = foodProduct;
	}

	@Override
	public String toString() {
		return "RestrictionList [restrictionType=" + restrictionType
			;
	}

	
	
}
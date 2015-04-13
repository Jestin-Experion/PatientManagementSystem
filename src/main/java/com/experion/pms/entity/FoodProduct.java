/**
 * 
 */
package com.experion.pms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "FoodProducts")
public class FoodProduct implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;

	/*
	 * @GeneratedValue(strategy=GenerationType.AUTO) //@GeneratedValue(strategy
	 * = GenerationType.AUTO, generator = "LTS_EMP_DETAILS")
	 * //@SequenceGenerator(name = "LTS_EMP_DETAILS", sequenceName =
	 * "LTS_EMP_ID_SEQ")
	 * 
	 * @Column(name = "book_ID") private Long bookID;
	 */

	@Id
	@Column(name = "Id")
	private String id;

	 
	@Column(name = "FoodName")
	private String foodName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId", nullable = false)
	private FoodCategory foodCategory;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "foodProduct", fetch=FetchType.LAZY )	
	private List<RestrictionList> restrictionDetails;
	
	
	public String getId() {
		return id;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public List<RestrictionList> getRestrictionDetails() {
		return restrictionDetails;
	}

	public void setRestrictionDetails(List<RestrictionList> restrictionDetails) {
		this.restrictionDetails = restrictionDetails;
	}

	@Override
	public String toString() {
		return "FoodProduct [restrictionDetails=" + restrictionDetails + "]";
	}

	
	
	/*@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodProduct [id=").append(id).append(", foodName=)")
				.append(foodName).append(", foodCategory=")
				.append(foodCategory).append(", getId()=").append(getId())
				.append(", getFoodCategory()=").append(getFoodCategory())
				.append(", getFoodName()=").append(getFoodName());
		return builder.toString();
	}*/

}
/**
 * 
 */
package com.experion.pms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "FoodCategories")
public class FoodCategory implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "CategoryName")
	private String categoryName;

	@OneToMany(mappedBy = "foodCategory", fetch=FetchType.EAGER)
	@OrderBy("foodName ASC")
	private List<FoodProduct> foodProducts;

	public String getId() {
		return id;
	}

	public List<FoodProduct> getFoodProducts() {
		return foodProducts;
	}

	public void setFoodProducts(List<FoodProduct> foodProducts) {
		this.foodProducts = foodProducts;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "FoodCategory [categoryName=" + categoryName + ", foodProducts="
				+ foodProducts + "]";
	}

	

}

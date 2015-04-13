/**
 * 
 */
package com.experion.pms.dao;

import java.util.List;

import com.experion.pms.entity.FoodCategory;
import com.experion.pms.entity.Restriction;

/**
 * @author AneeshChandran
 *
 */
public interface RestrictionManagementDAO {

	public List<Restriction> list() throws Exception;
	public Restriction loadEditDetails(String restrictionId) throws Exception;
	public  List<FoodCategory> getFoodCategoryAndFood() throws Exception;	
	public void saveRestriction(Restriction restriction) throws Exception;
	public Restriction restrictionNameValidate(String restrictionName,String id) throws Exception;
	//public void saveRestrictionList(List<RestrictionList> restrictionLis) throws Exception;

}

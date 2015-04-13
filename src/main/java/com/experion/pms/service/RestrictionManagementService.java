/**
 * 
 */
package com.experion.pms.service;

import java.util.List;

import com.experion.pms.entity.FoodCategory;
import com.experion.pms.entity.Restriction;
import com.experion.pms.vo.RestrictionListVO;

/**
 * @author AneeshChandran
 * 
 */
public interface RestrictionManagementService {

	public List<Restriction> list() throws Exception;
	public Restriction loadEditDetails(String restrictionId) throws Exception;	
	//public List<Restriction> loadEditDetails(String restrictionId) throws Exception;
	public  List<FoodCategory> getFoodCategoryAndFood() throws Exception;	
	public void saveRestriction(Restriction restriction, List<RestrictionListVO> list) throws Exception;
	public void editRestriction(Restriction restriction, List<RestrictionListVO> list) throws Exception;
	public Restriction restrictionNameValidate(String restrictionName,String id) throws Exception;	
}

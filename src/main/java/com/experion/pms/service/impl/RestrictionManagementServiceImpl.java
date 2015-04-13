/**
 * 
 */
package com.experion.pms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.experion.pms.dao.RestrictionManagementDAO;
import com.experion.pms.entity.FoodCategory;
import com.experion.pms.entity.Restriction;
import com.experion.pms.entity.RestrictionList;
import com.experion.pms.service.RestrictionManagementService;
import com.experion.pms.vo.RestrictionListVO;

/**
 * @author AneeshChandran
 * 
 */
public class RestrictionManagementServiceImpl implements
		RestrictionManagementService {

	// private MessageSource messageSource;

	private RestrictionManagementDAO restrictionManagementDAO;

	private static final Log log = LogFactory
			.getLog(RestrictionManagementServiceImpl.class);
	
	public RestrictionManagementDAO getRestrictionManagementDAO() {
		return restrictionManagementDAO;
	}

	public void setRestrictionManagementDAO(
			RestrictionManagementDAO restrictionManagementDAO) {
		this.restrictionManagementDAO = restrictionManagementDAO;
	}

	

	public List<Restriction> list() throws Exception {
		try {
			return restrictionManagementDAO.list();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}		
	}	

	public Restriction loadEditDetails(String restrictionId) throws Exception {
		try {
			return restrictionManagementDAO.loadEditDetails(restrictionId);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;			
		}
	}

	public List<FoodCategory> getFoodCategoryAndFood() throws Exception {
		try {
			return restrictionManagementDAO.getFoodCategoryAndFood();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;			
		}
	}
	

	public void saveRestriction(Restriction restriction, List<RestrictionListVO> list) throws Exception {		
		
		List<RestrictionList> restrictionLists = new ArrayList<RestrictionList>();	
		
		for (RestrictionListVO restrictionListVO : list) {			
			RestrictionList restrictionList=new RestrictionList();
			restrictionList.setFoodProductId(restrictionListVO.getFoodProductId());
			restrictionList.setRestrictionType(restrictionListVO.getRestrictionType());			
			restrictionList.setRestriction(restriction);			
			restrictionLists.add(restrictionList);
		}
		restriction.setRestrictionLists(restrictionLists);
		try {
			restrictionManagementDAO.saveRestriction(restriction);			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw e;			
		}
		
	}
	
	public void editRestriction(Restriction restriction, List<RestrictionListVO> list) throws Exception {		
		
		List<RestrictionList> restrictionLists = new ArrayList<RestrictionList>();	
		
		for (RestrictionListVO restrictionListVO : list) {			
			RestrictionList restrictionList=new RestrictionList();
			restrictionList.setId(restrictionListVO.getRestrictionListId());
			restrictionList.setFoodProductId(restrictionListVO.getFoodProductId());
			restrictionList.setRestrictionType(restrictionListVO.getRestrictionType());			
			restrictionList.setRestriction(restriction);			
			restrictionLists.add(restrictionList);
		}
		restriction.setRestrictionLists(restrictionLists);
		try {
			restrictionManagementDAO.saveRestriction(restriction);			
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			throw e;			
		}
		
	}

	public Restriction restrictionNameValidate(String restrictionName,String id)
			throws Exception {
		return restrictionManagementDAO.restrictionNameValidate(restrictionName,id);
	}

}

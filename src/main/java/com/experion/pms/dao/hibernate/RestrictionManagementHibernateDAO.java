/**
 * 
 */
package com.experion.pms.dao.hibernate;

import java.util.List;

import com.experion.pms.dao.RestrictionManagementDAO;
import com.experion.pms.entity.FoodCategory;
import com.experion.pms.entity.Restriction;

/**
 * @author AneeshChandran
 * 
 */
public class RestrictionManagementHibernateDAO extends BaseHibernateDAO<Object>
		implements RestrictionManagementDAO {

	private static final long serialVersionUID = 6484250259100963808L;

	//private MessageSource messageSource;

	/**
	 * This method will query the Restrictions and return the Restriction entity based on
	 * the id passed.
	 */

	
	public List<Restriction> list() throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Restriction> restrictionList = getHibernateTemplate().find(
					"from Restriction order by restrictionName");
			if (restrictionList != null && !restrictionList.isEmpty()) {
				return restrictionList;
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	
	public Restriction loadEditDetails(String restrictionId) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Restriction> restriction = getHibernateTemplate().find("from Restriction where id = ?", restrictionId);			
			if (restriction != null && !restriction.isEmpty()) {
				return restriction.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	public List<FoodCategory> getFoodCategoryAndFood() throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<FoodCategory> catrgory = getHibernateTemplate().find("from FoodCategory fc order by fc.categoryName");
			if (catrgory != null && !catrgory.isEmpty()) {
				return catrgory;
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}	

	public void saveRestriction(Restriction restriction) throws Exception {
		try {			
			getHibernateTemplate().merge(restriction);
		} catch (Exception e) {
			throw e;
		}
		
	}


	public Restriction restrictionNameValidate(String restrictionName,String id)
			throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Restriction> restriction = getHibernateTemplate().find("from Restriction where restrictionName = ? and id != ?", restrictionName,id);			
			if (restriction != null && !restriction.isEmpty()) {
				return restriction.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}	

}

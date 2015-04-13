/**
 * 
 */
package com.experion.pms.dao.hibernate;

import java.util.List;

import com.experion.pms.dao.DiseaseManagementDAO;
import com.experion.pms.entity.Disease;

/**
 * @author AneeshChandran
 * 
 */
public class DiseaseManagementHibernateDAO extends BaseHibernateDAO<Object>
		implements DiseaseManagementDAO {

	private static final long serialVersionUID = 6484250259100963808L;

	public void saveDisease(Disease disease) throws Exception {		
		try {			
			getHibernateTemplate().merge(disease);				
			
		} catch (Exception e) {
			throw e;
		}		
	}

	public Disease diseaseNameValidate(String diseaseName, String id)
			throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<Disease> disease = getHibernateTemplate().find("from Disease where diseaseName = ? and id != ?", diseaseName,id);			
			if (disease != null && !disease.isEmpty()) {
				return disease.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	
	
}
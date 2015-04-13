/**
 * 
 */
package com.experion.pms.dao;

import com.experion.pms.entity.Disease;




/**
 * @author AneeshChandran
 *
 */
public interface DiseaseManagementDAO extends BaseDAO{

	public void saveDisease(Disease disease) throws Exception;
	public Disease diseaseNameValidate(String diseaseName,String id) throws Exception;
}

/**
 * 
 */
package com.experion.pms.service;

import java.util.List;

import com.experion.pms.entity.Disease;
import com.experion.pms.mvc.data.DiseaseManagementForm;




/**
 * @author AneeshChandran
 * 
 */
public interface DiseaseManagementService {

	public List<Object> getDetails(String entityName,String whereField,String whereValue,String orderBy) throws Exception;
	public void saveDisease(DiseaseManagementForm diseaseManagementForm,String userId) throws Exception;
	public void updateDisease(DiseaseManagementForm diseaseManagementForm,String userId) throws Exception;
	public Disease diseaseNameValidate(String diseaseName,String id) throws Exception;
}

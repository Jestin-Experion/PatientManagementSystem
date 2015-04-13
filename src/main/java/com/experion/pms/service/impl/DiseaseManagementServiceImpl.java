/**
 * 
 */
package com.experion.pms.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.experion.pms.dao.DiseaseManagementDAO;
import com.experion.pms.entity.Disease;
import com.experion.pms.mvc.data.DiseaseManagementForm;
import com.experion.pms.service.DiseaseManagementService;

/**
 * @author AneeshChandran
 * 
 */
public class DiseaseManagementServiceImpl implements
		DiseaseManagementService {

	// private MessageSource messageSource;
	/*private static final Log log = LogFactory
	.getLog(PatientSearchServiceImpl.class);*/

	private DiseaseManagementDAO diseaseManagementDAO;

	public DiseaseManagementDAO getDiseaseManagementDAO() {
		return diseaseManagementDAO;
	}

	public void setDiseaseManagementDAO(DiseaseManagementDAO diseaseManagementDAO) {
		this.diseaseManagementDAO = diseaseManagementDAO;
	}

	public List<Object> getDetails(String entityName, String whereField,
			String whereValue, String orderBy) throws Exception {
		
		return diseaseManagementDAO.getDetails(entityName, whereField, whereValue, orderBy);
	}

	public void saveDisease(DiseaseManagementForm diseaseManagementForm,String userId)
			throws Exception {		
		Disease disease =new Disease();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		disease.setDiseaseName(diseaseManagementForm.getDiseaseName().trim());
		disease.setAyurvedaName(diseaseManagementForm.getAyurvedaName().trim());
		disease.setClassificationId(diseaseManagementForm.getClassification());
		disease.setSubClassificationId(diseaseManagementForm.getSubClassification());
		if (StringUtils.isBlank(diseaseManagementForm.getStatus())) {
			disease.setStatus("Inactive");
		}else{		
			disease.setStatus(diseaseManagementForm.getStatus());
		}
		disease.setCreatedBy(userId);
		disease.setCreatedOn(dateFormat.format(date));
		
		diseaseManagementDAO.saveDisease(disease);
	}

	public Disease diseaseNameValidate(String diseaseName, String id)
			throws Exception {
		
		return diseaseManagementDAO.diseaseNameValidate(diseaseName, id);
	}

	public void updateDisease(DiseaseManagementForm diseaseManagementForm,
			String userId) throws Exception {
		Disease disease =new Disease();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		disease.setId(diseaseManagementForm.getDiseaseId());
		System.out.println("id-------"+diseaseManagementForm.getDiseaseId());
		disease.setDiseaseName(diseaseManagementForm.getDiseaseName().trim());
		disease.setAyurvedaName(diseaseManagementForm.getAyurvedaName().trim());
		disease.setClassificationId(diseaseManagementForm.getClassification());
		disease.setSubClassificationId(diseaseManagementForm.getSubClassification());
		if (StringUtils.isBlank(diseaseManagementForm.getStatus())) {
			disease.setStatus("Inactive");
		}else{		
			disease.setStatus(diseaseManagementForm.getStatus());
		}
		disease.setCreatedBy(diseaseManagementForm.getCreatedBy());
		disease.setCreatedOn(diseaseManagementForm.getCreatedOn());
		disease.setUpdatedBy(userId);
		disease.setUpdatedOn(dateFormat.format(date));
		
		diseaseManagementDAO.saveDisease(disease);
		
	}
	
	
	
}
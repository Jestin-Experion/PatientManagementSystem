/**
 * 
 */
package com.experion.pms.service.impl;

import java.util.List;

import com.experion.pms.dao.PatientSearchDAO;
import com.experion.pms.entity.PatientDisease;
import com.experion.pms.entity.PatientRegistration;
import com.experion.pms.mvc.data.PatientSearchForm;
import com.experion.pms.service.PatientSearchService;
import com.experion.pms.util.DOBToAge;
import com.experion.pms.vo.PatientSearchVO;

/**
 * @author AneeshChandran
 * 
 */
public class PatientSearchServiceImpl implements
		PatientSearchService {

	// private MessageSource messageSource;

	private PatientSearchDAO patientSearchDAO;

	/*private static final Log log = LogFactory
			.getLog(PatientSearchServiceImpl.class);*/


	public PatientSearchDAO getPatientSearchDAO() {
		return patientSearchDAO;
	}
	public void setPatientSearchDAO(PatientSearchDAO patientSearchDAO) {
		this.patientSearchDAO = patientSearchDAO;
	}
	public List<Object> getDetails(String entityName,String whereField,String whereValue, String orderBy)
			throws Exception {
		return patientSearchDAO.getDetails(entityName, whereField, whereValue, orderBy);
	}
	
	public List<PatientRegistration> searchPatients(PatientSearchForm patientSearchForm) throws Exception {
		
		PatientSearchVO patientSearchVO=new PatientSearchVO(); 
		patientSearchVO.setPatientName(patientSearchForm.getPatientName());
		patientSearchVO.setGender(patientSearchForm.getGender());
		patientSearchVO.setRegistrationNumber(patientSearchForm.getRegistrationNumber());
		patientSearchVO.setFileNumber(patientSearchForm.getFileNumber());
		patientSearchVO.setFacility(patientSearchForm.getFacilityName());
		patientSearchVO.setDiseaseSelected(patientSearchForm.getDiseaseSelected());
		patientSearchVO.setDiseaseClassification(patientSearchForm.getDiseaseClassification());
		patientSearchVO.setDiseaseSubClassification(patientSearchForm.getDiseaseSubClassification());
		patientSearchVO.setVisitDateFrom(patientSearchForm.getVisitDateFrom());
		patientSearchVO.setVisitDateTo(patientSearchForm.getVisitDateTo());
		patientSearchVO.setAgeFrom(patientSearchForm.getAgeFrom());
		patientSearchVO.setAgeTo(patientSearchForm.getAgeTo());
		
		List<PatientRegistration> patientLists=patientSearchDAO.searchPatients(patientSearchVO);
		
		if(patientLists!=null){
			DOBToAge dtoa=new DOBToAge();
			for(PatientRegistration pr:patientLists){
				
				pr.setDob(String.valueOf(dtoa.getAge(pr.getDob())));
			}
		}
		
		return patientLists;
	}
	public List<PatientDisease> getPatientDiseases(String patientId)
			throws Exception {		
		return patientSearchDAO.getPatientDiseases(patientId);
	}	
		

}

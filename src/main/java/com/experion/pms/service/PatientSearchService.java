/**
 * 
 */
package com.experion.pms.service;

import java.util.List;

import com.experion.pms.entity.PatientDisease;
import com.experion.pms.entity.PatientRegistration;
import com.experion.pms.mvc.data.PatientSearchForm;


/**
 * @author AneeshChandran
 * 
 */
public interface PatientSearchService {

	public List<Object> getDetails(String entityName,String whereField,String whereValue,String orderBy) throws Exception;
	public List<PatientRegistration> searchPatients(PatientSearchForm patientSearchForm) throws Exception;
	public List<PatientDisease> getPatientDiseases(String patientId) throws Exception;
	
}

/**
 * 
 */
package com.experion.pms.dao;

import java.util.List;

import com.experion.pms.entity.PatientDisease;
import com.experion.pms.entity.PatientRegistration;
import com.experion.pms.vo.PatientSearchVO;


/**
 * @author AneeshChandran
 *
 */
public interface PatientSearchDAO extends BaseDAO {
	public List<PatientRegistration> searchPatients(PatientSearchVO patientSearchVO) throws Exception;
	public List<PatientDisease> getPatientDiseases(String patientId) throws Exception;
}

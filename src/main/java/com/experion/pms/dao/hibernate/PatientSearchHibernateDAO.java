/**
 * 
 */
package com.experion.pms.dao.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.experion.pms.dao.PatientSearchDAO;
import com.experion.pms.entity.PatientDisease;
import com.experion.pms.entity.PatientRegistration;
import com.experion.pms.vo.PatientSearchVO;

/**
 * @author AneeshChandran
 * 
 */
public class PatientSearchHibernateDAO extends BaseHibernateDAO<Object>
		implements PatientSearchDAO {

	private static final long serialVersionUID = 6484250259100963808L;
	
	private String registrationNumber;
	private String facility;	
	private String fileNumber;
	private String patientName;
	private String gender;	
	private String diseaseClassification;
	private String diseaseSubClassification;	
	private String diseaseSelected;
	private String visitDateFrom;
	private String visitDateTo;
	private String ageFrom;
	private String ageTo;

	

	@SuppressWarnings("unchecked")
	public List<PatientRegistration> searchPatients(PatientSearchVO patientSearchVO) throws Exception {	
		
		registrationNumber=patientSearchVO.getRegistrationNumber().trim();
		facility=patientSearchVO.getFacility();	
		fileNumber=patientSearchVO.getFileNumber().trim();
		patientName=patientSearchVO.getPatientName().trim();
		gender=patientSearchVO.getGender();		
		diseaseClassification=patientSearchVO.getDiseaseClassification();
		diseaseSubClassification=patientSearchVO.getDiseaseSubClassification();	
		diseaseSelected=patientSearchVO.getDiseaseSelected();
		visitDateFrom=patientSearchVO.getVisitDateFrom();
		visitDateTo=patientSearchVO.getVisitDateTo();
		ageFrom=patientSearchVO.getAgeFrom().trim();
		ageTo=patientSearchVO.getAgeTo().trim();	
		
		patientName=patientName.replace("'","''" );
		registrationNumber=registrationNumber.replace("'","''" );
		fileNumber=fileNumber.replace("'","''" );
		visitDateFrom=visitDateFrom.replace("'","''" );
		visitDateTo=visitDateTo.replace("'","''" );
		ageFrom=ageFrom.replace("'","''" );
		ageTo=ageTo.replace("'","''" );
		
		String pattern = "\\d*";
		Pattern r = Pattern.compile(pattern);
		Matcher ageFromMatch = r.matcher(ageFrom);
		Matcher ageToMatch = r.matcher(ageTo);
		if(!ageFromMatch.matches()){
			ageFrom=StringUtils.EMPTY;			
		}
		if(!ageToMatch.matches()){
			ageTo=StringUtils.EMPTY;			
		}
		
		StringBuilder query = new StringBuilder(" SELECT DISTINCT pr FROM PatientRegistration pr, IN (pr.patientVisits) pv, "
					+ "IN(pv.patientDiseases) pd, IN(pd.disease) d  WHERE "
					+ "pr.patientName like '"+patientName+"%' and pr.gender like '"+gender+"%' and "
					+ "pr.registrationNumber like '"+registrationNumber+"%' and pr.fileNumber like '"+fileNumber+"%'");		

		/*StringBuilder query = new StringBuilder(" SELECT pr,pvv.visitDate FROM PatientRegistration pr, PatientVisit pvv, IN (pr.patientVisits) pv, "
					+ "IN(pv.patientDiseases) pd, IN(pd.disease) d  WHERE "
					+ "pr.id=pvv.patientId and pr.patientName like '"+patientName+"%' and pr.gender like '"+gender+"%' and "
					+ "pr.registrationNumber like '"+registrationNumber+"%' and pr.fileNumber like '"+fileNumber+"%'");	*/
	
		 if(Integer.parseInt(facility)!=0){
				
				query.append(" and pv.facilityId = "+facility+"");
				
		   }
		if(Integer.parseInt(diseaseClassification)!=0){
				
				query.append(" and d.classificationId = "+diseaseClassification+"");
			
		   }
		 if(Integer.parseInt(diseaseSubClassification)!=0){
				
				query.append(" and d.subClassificationId = "+diseaseSubClassification+"");
			
		   }
		 if(diseaseSelected!=null){
				
				query.append(" and pd.diseasesId IN("+diseaseSelected+")");		
			
		   }			
		 if(visitDateFrom!=StringUtils.EMPTY && visitDateTo!=StringUtils.EMPTY){			 
			
			String dateFrom=formatDate(visitDateFrom, "dd/MM/y", "y-MM-dd");
			String dateTo=formatDate(visitDateTo, "dd/MM/y", "y-MM-dd");			
			query.append(" and pv.visitDate BETWEEN '"+dateFrom+"' AND '"+dateTo+"'");
		 }
		 
		 if(ageFrom!=StringUtils.EMPTY && ageTo!=StringUtils.EMPTY){		 
			 		  
			 query.append(" and DATEDIFF(DAY,pr.dob,GETDATE())/365>='"+ageFrom+"' and (DATEDIFF(DAY,pr.dob,GETDATE())/365) <='"+ageTo+"'");		
		 }
						 
		 query.append(" order by pr.patientName");		
		 
		 
		 List<PatientRegistration> list = getHibernateTemplate().find(query.toString());	   
		 if (list != null && !list.isEmpty()) {
				return list;
			}	   
			   
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<PatientDisease> getPatientDiseases(String patientId)
			throws Exception {		
		StringBuilder query = new StringBuilder(" SELECT pd FROM PatientDisease pd, IN (pd.patientVisit) pv "
				+ "WHERE pv.patientId='"+patientId+"'");				
		 List<PatientDisease> list = getHibernateTemplate().find(query.toString());	   
		 if (list != null && !list.isEmpty()) {
				return list;
			}	   
		
		return null;
	}	

	public static String formatDate (String date, String initDateFormat, String endDateFormat) throws ParseException {

		Date initDate = new SimpleDateFormat(initDateFormat).parse(date);
		SimpleDateFormat formatter = new SimpleDateFormat(endDateFormat);
		String parsedDate = formatter.format(initDate);

		return parsedDate;
	}

}

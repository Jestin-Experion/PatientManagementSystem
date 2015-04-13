/**
 * 
 */
package com.experion.pms.mvc.controller;

import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.pms.entity.DiseaseSubClassification;
import com.experion.pms.entity.PatientDisease;
import com.experion.pms.entity.PatientRegistration;
import com.experion.pms.mvc.data.PatientSearchForm;
import com.experion.pms.service.PatientSearchService;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/home/*")
public class PatientSearchController {

	private static final String Patient_search = "/patientsearch";	

	private static final Log log = LogFactory
			.getLog(PatientSearchController.class);

	@Inject
	@Named("patientSearchService")
	public PatientSearchService patientSearchService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;
	

	/**
	 * 
	 * @param request
	 * @return
	 * 
	 *         This method will be invoked at the initial time when the
	 *         application is loaded.
	 * 
	 */
	@RequestMapping(value = "/search")
	public ModelAndView search(@ModelAttribute PatientSearchForm patientSearchForm,
			BindingResult result, Model model,@RequestParam(required = false) String msg) {	
		
		try {
			List<Object> facilities = patientSearchService.getDetails("Facility","status","Active", "facilityName");
			model.addAttribute("facilities", facilities);
			List<Object> diseaseClassifications = patientSearchService.getDetails("DiseaseClassification",StringUtils.EMPTY,StringUtils.EMPTY,"classification");
			model.addAttribute("diseaseClassifications", diseaseClassifications);
			List<Object> diseases=patientSearchService.getDetails("Disease","status","Active", "diseaseName");
			model.addAttribute("diseases", diseases);			
			model.addAttribute("menus", LoginController.menus);	
			model.addAttribute("userName", LoginController.userName);
			model.addAttribute("date",LoginController.date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("redirected");	
		return new ModelAndView(Patient_search, "patientSearchForm",
				new PatientSearchForm());		
	}
	
	/* For selecting disease sub classification from classification*/
	
	@RequestMapping(value = "/subClass")
	public @ResponseBody
	String getdiseaseSubClassification(@RequestParam(required = false) String id) {
		JSONArray jArray = new JSONArray();
		try {
			List<Object> diseaseSubClassifications = patientSearchService.getDetails("DiseaseSubClassification", "ClassificationId", id, "subClassification");
			
			if(diseaseSubClassifications!=null){
				
				@SuppressWarnings("unchecked")
				List<DiseaseSubClassification> subClassifications= (List<DiseaseSubClassification>)(List<?>) diseaseSubClassifications;			
					
				for (DiseaseSubClassification diseaseSubClassification : subClassifications) {
					JSONObject json = new JSONObject();
					json.put("id",diseaseSubClassification.getId());
					json.put("name",diseaseSubClassification.getSubClassification());
					jArray.put(json);
					
				}
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jArray.toString();
	}
	
	@RequestMapping(value = "/searchPatients")
	public ModelAndView searchPatient(HttpServletRequest request, PatientSearchForm patientSearchForm,
			BindingResult bindingResult,Model model) {	
			
		try {
			List<PatientRegistration> patientLists= patientSearchService.searchPatients(patientSearchForm);			
				model.addAttribute("patientLists", patientLists);
				
				/*ExcelWrite ex=new ExcelWrite();				
				for (PatientRegistration patientRegistration : patientLists) {
					ex.insertData(patientLists.size(),patientRegistration.getPatientName(), patientRegistration.getRegistrationNumber(), patientRegistration.getGender());
				}*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("redirected");	
		return new ModelAndView("patientsearchresult","patientSearchForm",
				new PatientSearchForm());
		
	}
	
	 @RequestMapping(value = "/getDiseases", method = RequestMethod.GET)
	 public @ResponseBody
	 String getRestriction(@RequestParam String id) {
		 ResourceBundle resource=ResourceBundle.getBundle("resources/Messages");
		 List<PatientDisease> patientDiseases=null;
		 StringBuilder result = new StringBuilder();			
			try {
				patientDiseases = patientSearchService.getPatientDiseases(id);				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(patientDiseases==null){			
			result.append(resource.getString("search.result.noDiseasesFound"));
			}else{		
				
				result.append("<div align='center' style='height:300px;overflow:auto;overflow-x:hidden;'><table border='2' width='550' class='tdBorder'><tr><th>"
				+resource.getString("search.result.disease")
				+"</th><th>"+resource.getString("search.result.diseaseClassification")
				+"</th><th>"+resource.getString("search.result.diseaseSubClassification")+"</th>"
				+"<th>"+resource.getString("search.result.status")+"</th></tr>");
				
				for (PatientDisease patientDisease : patientDiseases) {					
					result.append("<tr><td>"+patientDisease.getDisease().getDiseaseName()+"</td>");
					result.append("<td>"+patientDisease.getDisease().getDiseaseClassificationName().getClassification()+"</td>");
					result.append("<td>"+patientDisease.getDisease().getDiseaseSubClassificationName().getSubClassification()+"</td>");
					result.append("<td>"+patientDisease.getDiseaseStatus()+"</td></tr>");					
							
				}
				result.append("</table></div>");
			}
			
			return result.toString();
			
	 }
}

/**
 * 
 */
package com.experion.pms.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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

import com.experion.pms.entity.Disease;
import com.experion.pms.entity.DiseaseSubClassification;
import com.experion.pms.mvc.data.DiseaseManagementForm;
import com.experion.pms.service.DiseaseManagementService;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/disease/*")
public class DiseaseManagementController {

	private static final String Disease_management = "/diseasemanagement";

	private static final Log log = LogFactory
			.getLog(DiseaseManagementController.class);

	@Inject
	@Named("diseaseManagementService")
	public DiseaseManagementService diseaseManagementService;

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
	
	/*For listing all Diseases*/
	@RequestMapping(value = "/list")
	public ModelAndView listDiseases(
			@ModelAttribute DiseaseManagementForm diseaseManagementForm,
			BindingResult result, Model model,@RequestParam(required = false) String msg) {
		
		try {
			List<Object> diseases = diseaseManagementService.getDetails("Disease", StringUtils.EMPTY, StringUtils.EMPTY, "diseaseName");
			List<Object> diseaseClassifications=diseaseManagementService.getDetails("DiseaseClassification", StringUtils.EMPTY, StringUtils.EMPTY, "classification");
			model.addAttribute("diseases", diseases);
			model.addAttribute("diseaseClassifications",diseaseClassifications);
			model.addAttribute("menus",LoginController.menus);
			model.addAttribute("userName", LoginController.userName);
			model.addAttribute("date",LoginController.date);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		diseaseManagementForm.setMessageText(msg);
		return new ModelAndView(Disease_management, "diseaseManagementForm",
				new DiseaseManagementForm());
	}
	 
	 /*For saving new Disease details*/
	@RequestMapping(value = "/save")
	public String saveRestriction(@ModelAttribute DiseaseManagementForm  diseaseManagementForm,HttpSession session) {
		
		log.info("Reached the saveItem controller..........");	
		try {
			diseaseManagementService.saveDisease(diseaseManagementForm,session.getAttribute("userId").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:" + "list?msg=saved";
	}	
	
	 /*For getting sub-classification of disease with respect to classification id*/
	@RequestMapping(value = "/subClass")
	public @ResponseBody
	String getdiseaseSubClassification(@RequestParam(required = false) String id) {
		JSONArray jArray = new JSONArray();
		try {
			List<Object> diseaseSubClassifications = diseaseManagementService.getDetails("DiseaseSubClassification", "ClassificationId", id, "subClassification");
			
			if(diseaseSubClassifications!=null){
				
				@SuppressWarnings("unchecked")
				List<DiseaseSubClassification> subClassifications= (List<DiseaseSubClassification>)(List<?>) diseaseSubClassifications;			
					
				for (DiseaseSubClassification diseaseSubClassification : subClassifications) {
					JSONObject json = new JSONObject();
					json.put("id",diseaseSubClassification.getId());
					json.put("name",diseaseSubClassification.getSubClassification());
					jArray.put(json);
					
				}
				//System.out.println(jArray);
				}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jArray.toString();
	}
	

	 /*For checking Disease name is already in the database*/
	 @RequestMapping(value = "/diseseNameValidation", method = RequestMethod.GET)
	 public @ResponseBody
	 String chechName(@RequestParam String diseaseName,String id) {
			Disease diseaseObject=null;
			String result=StringUtils.EMPTY;			
			try {
				diseaseObject = diseaseManagementService.diseaseNameValidate(diseaseName, id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(diseaseObject!=null){			
			result="failed";
			}else{
			result="success";
			}			
			return result;
			
	 }
	 
	 /*For fetching details for updating Disease details*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/edit")
		public @ResponseBody
		String getdiseaseDetails(@RequestParam(required = false) String id) {
			JSONArray jArray = new JSONArray();
			try {
				List<Object> diseaseDetails = diseaseManagementService.getDetails("Disease", "id", id, "id");
				
				if(diseaseDetails!=null){					
					
					List<Disease> details= (List<Disease>)(List<?>) diseaseDetails;			
						
					for (Disease disease : details) {
						JSONObject json = new JSONObject();
						json.put("id",disease.getId());
						json.put("diseaseName",disease.getDiseaseName());
						json.put("ayurvedaName",disease.getAyurvedaName());
						json.put("classificationId",disease.getClassificationId());
						json.put("subClassificationId",disease.getSubClassificationId());
						json.put("status",disease.getStatus());
						json.put("createdOn",disease.getCreatedOn());
						json.put("createdBy",disease.getCreatedBy());
						
						jArray.put(json);
						
					}
					//System.out.println(jArray);
					}
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return jArray.toString();
		}
	/*For updating edited Disease details*/
	@RequestMapping(value = "/update")
	public String updateRestriction(@ModelAttribute DiseaseManagementForm  diseaseManagementForm,HttpSession session) {
		
		log.info("Reached the update controller..........");	
		try {
			diseaseManagementService.updateDisease(diseaseManagementForm,session.getAttribute("userId").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return "redirect:" + "list?msg=updated";
	}	
}

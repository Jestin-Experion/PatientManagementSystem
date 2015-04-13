/**
 * 
 */
package com.experion.pms.mvc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.pms.entity.FoodCategory;
import com.experion.pms.entity.Restriction;
import com.experion.pms.mvc.data.NewRestrictionForm;
import com.experion.pms.mvc.data.RestrictionManagementForm;
import com.experion.pms.service.RestrictionManagementService;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/restriction/*")
public class RestrictionManagementController {

	private static final String Restriction_management = "/restrictionmanagement";

	private static final Log log = LogFactory
			.getLog(RestrictionManagementController.class);

	@Inject
	@Named("restrictionManagementService")
	public RestrictionManagementService restrictionManagementService;

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
	@RequestMapping(value = "/test")
	public ModelAndView loginAction(HttpServletRequest request) {
		log.info("redirected");	
		return new ModelAndView(Restriction_management, "restrictionManagementForm",
				new RestrictionManagementForm());		
	}
	
	/*For listing all Restrictions*/
	@RequestMapping(value = "/list")
	public ModelAndView listRestrictions(
			@ModelAttribute RestrictionManagementForm restrictionManagementForm,
			BindingResult result, Model model,@RequestParam(required = false) String msg) {
		
		try {
			List<Restriction> restrictions = restrictionManagementService.list();
			model.addAttribute("restrictions", restrictions);
			model.addAttribute("menus",LoginController.menus);
			model.addAttribute("userName", LoginController.userName);
			model.addAttribute("date",LoginController.date);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		restrictionManagementForm.setMessageText(msg);
		return new ModelAndView(Restriction_management, "restrictionManagementForm",
				new RestrictionManagementForm());
	}
	
	/*For creating new Restriction*/
	 @RequestMapping(value="/create") 
	 public ModelAndView includeNewRestriction(ModelMap model) {
		 
		 try {
				List<FoodCategory> categories = restrictionManagementService.getFoodCategoryAndFood();				
				/*List<String> restrictionTypes = new ArrayList<String>();
				restrictionTypes.add("Do");
				restrictionTypes.add("Don't");
				restrictionTypes.add("Occasionally");				
				*/
				model.addAttribute("categories", categories);				
				/*model.addAttribute("restrictionTypes", restrictionTypes);*/
			} catch (Exception e) {
				log.error(e.getMessage());
			}	     
		 return new ModelAndView("newrestriction", "newRestrictionForm",new NewRestrictionForm());	     
	 }
	 
	 /*displaying a single restriction details for editing*/
	 @RequestMapping(value="/edit") 
	 public ModelAndView includeEditRestriction(@RequestParam String id,ModelMap model,NewRestrictionForm newRestrictionForm) {
		 Restriction restrictionObject=null;		 
			try {
				restrictionObject = restrictionManagementService.loadEditDetails(id);
				model.addAttribute("restrictiondetails", restrictionObject);			   		    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     newRestrictionForm.setRestrictionName(restrictionObject.getRestrictionName());
	     newRestrictionForm.setDescription(restrictionObject.getDescription());
	     newRestrictionForm.setRestrictionId(restrictionObject.getId());
	     newRestrictionForm.setCreatedOn(restrictionObject.getCreatedOn());
	     newRestrictionForm.setCreatedBy(restrictionObject.getCreatedBy());
	     return new ModelAndView("editrestriction", "newRestrictionForm",newRestrictionForm);		     
	 } 
	 
	 /*For checking restriction name is already in the database*/
	 @RequestMapping(value = "/restrictionNameValidation", method = RequestMethod.GET)
	 public @ResponseBody
	 String chechName(@RequestParam String restrictionName,String id) {
			Restriction restrictionObject=null;
			String result=StringUtils.EMPTY;			
			try {
				restrictionObject = restrictionManagementService.restrictionNameValidate((restrictionName.trim()),id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(restrictionObject!=null){			
			result="failed";
			}else{
				result="success";
			}			
			return result;
			
	 }
	 
	 /*For saving new Restriction details*/
	@RequestMapping(value = "/save")
	public String saveRestriction(@ModelAttribute NewRestrictionForm  newRestrictionForm,
			BindingResult result, Model model,HttpSession session) {
		
		
		Restriction restriction =new Restriction();
		restriction.setRestrictionName(newRestrictionForm.getRestrictionName().trim());
		restriction.setDescription(newRestrictionForm.getDescription().trim());
		if (StringUtils.isBlank(newRestrictionForm.getStatus())) {
			restriction.setStatus("Inactive");
		}else{		
		restriction.setStatus(newRestrictionForm.getStatus());
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		restriction.setCreatedOn(dateFormat.format(date));
		restriction.setCreatedBy((session.getAttribute("userId").toString()));	
		
		try {
			restrictionManagementService.saveRestriction(restriction,newRestrictionForm.getFoodRestrictions());
		} catch (Exception e) {
			log.error(e.getMessage());
		}	
		
		return "redirect:" + "list?msg=saved";
		
	}	
	
	/*For updating edited Restriction details*/
	@RequestMapping(value = "/update")
	public String updateRestriction(@ModelAttribute NewRestrictionForm  newRestrictionForm,
			BindingResult result, Model model,HttpSession session) {
		
		Restriction restriction =new Restriction();		
		restriction.setId(newRestrictionForm.getRestrictionId());
		restriction.setRestrictionName(newRestrictionForm.getRestrictionName().trim());
		restriction.setDescription(newRestrictionForm.getDescription().trim());
		if (StringUtils.isBlank(newRestrictionForm.getStatus())) {
			restriction.setStatus("Inactive");
		}else{		
		restriction.setStatus(newRestrictionForm.getStatus());
		}
		restriction.setCreatedOn(newRestrictionForm.getCreatedOn());
		restriction.setCreatedBy(newRestrictionForm.getCreatedBy());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		restriction.setUpdatedOn(dateFormat.format(date));
		restriction.setUpdatedBy((session.getAttribute("userId").toString()));	
		
		try {
			restrictionManagementService.editRestriction(restriction,newRestrictionForm.getFoodRestrictions());
		} catch (Exception e) {
			log.error(e.getMessage());
		}	
		
		return "redirect:" + "list?msg=updated";
		
	}
}

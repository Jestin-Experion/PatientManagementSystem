/**
 * 
 */
package com.experion.pms.mvc.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.experion.pms.mvc.data.PatientRegistrationForm;
import com.experion.pms.service.RestrictionManagementService;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/patient/*")
public class PatientRegistrationController {

	private static final String Patient_Registration = "/patientregistration";

	private static final Log log = LogFactory
			.getLog(PatientRegistrationController.class);

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
	@RequestMapping(value = "/register")
	public ModelAndView loginAction(Model model) {
		log.info("redirected");	
		model.addAttribute("menus",LoginController.menus);
		model.addAttribute("userName", LoginController.userName);
		model.addAttribute("date",LoginController.date);
		return new ModelAndView(Patient_Registration, "patientRegistrationForm",
				new PatientRegistrationForm());		
	}
	
}
/**
 * 
 */
package com.experion.pms.mvc.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.pms.entity.User;
import com.experion.pms.mvc.data.PasswordChangeForm;
import com.experion.pms.service.LoginService;
import com.experion.pms.util.MD5Encryption;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/password/*")
public class PasswordChangeController {

	private static final String password_change = "/passwordchange";
	
	private static final Log log = LogFactory
			.getLog(PasswordChangeController.class);

	@Inject
	@Named("loginService")
	public LoginService loginService;

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
	@RequestMapping(value = "/change")
	public ModelAndView passwordChangeAction(HttpServletRequest request,Model model) {
		log.info("redirected");	
		model.addAttribute("menus",LoginController.menus);
		model.addAttribute("userName", LoginController.userName);
		model.addAttribute("date",LoginController.date);
		return new ModelAndView(password_change, "passwordChangeForm",
				new PasswordChangeForm());		
	}

	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public @ResponseBody
	String Logout(HttpServletRequest request,HttpSession session,@RequestParam String oPass,String nPass)
	{		
		MD5Encryption md=new MD5Encryption();		
		if(session.getAttribute("userId")!=null){
			try {
				User user=loginService.updatePassword((session.getAttribute("userId").toString()),md.getMD5(oPass),md.getMD5(nPass));
				if(user!=null){
					return "success";
				}else{
					return "failed";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

		
	}
	
	

	
}
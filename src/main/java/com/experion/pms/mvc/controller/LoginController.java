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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.pms.entity.Facility;
import com.experion.pms.entity.Menu;
import com.experion.pms.entity.User;
import com.experion.pms.entity.UserLog;
import com.experion.pms.mvc.data.FacilitySelectForm;
import com.experion.pms.mvc.data.LoginForm;
import com.experion.pms.service.LoginService;
import com.experion.pms.util.MD5Encryption;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/pms/*")
public class LoginController {

	private static final String Login_page = "/login";
	private String facilityId;
	public static List<Menu> menus=null;
	public static String userName;
	public static String date;

	private static final Log log = LogFactory
			.getLog(LoginController.class);

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
	@RequestMapping(value = "/login")
	public ModelAndView loginAction(HttpServletRequest request,HttpSession session) {
		//request.getSession().invalidate();
		log.info("redirected");	
		return new ModelAndView(Login_page, "loginForm",
				new LoginForm());		
	}
	/*For checking login credentials*/
	
	@RequestMapping(value = "/loginMe", method = RequestMethod.POST)
	public @ResponseBody
	String getRestriction(HttpServletRequest request,@RequestParam String emailId,String password) {
		 StringBuilder result=new StringBuilder();
		 List<Object> userObject=null;
		 User user=null;		 
		 try {
			 
			 userObject=loginService.getDetails("User", "email", emailId, "email");
			 if(userObject!=null){

				 for (Object object : userObject) {
					
					 if(((User) object).getStatus().equalsIgnoreCase("New")){
						 result.append("new");
					 }
					 else if(((User) object).getStatus().equalsIgnoreCase("Reset")){
						 result.append("reset");
					 }
					 else if(((User) object).getStatus().equalsIgnoreCase("Inactive")){
						 result.append("inactive");
					 }
					 else if(((User) object).getStatus().equalsIgnoreCase("Active")){
						 MD5Encryption md=new MD5Encryption();
						 user=loginService.loginAction(emailId,(md.getMD5(password)));
						 if(user!=null){		
								request.getSession().setAttribute("userId", user.getId());
								facilityId=user.getPrimaryFacilityId();
								userName=user.getUserName();
								DateFormat dateFormat = new SimpleDateFormat("dd-MM-y"); 
								Date dates=new Date();
								date=dateFormat.format(dates);
								menus=loginService.getMenu((user.getRoleId().toString()));
								result.append("success");			
						}else{
								result.append("failed");
						
						}
					}
				}
				
			 }else{
				 result.append("failed");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		
			
			return result.toString();
			
	 }
	@RequestMapping(value = "/logout")
	public ModelAndView Logout(HttpServletRequest request,HttpSession session)
	{		
		if(session.getAttribute("userId")!=null){
			try {
				UserLog userLog=loginService.getMaxId((session.getAttribute("userId").toString()));
				if(userLog!=null){
					UserLog userLogSave = new UserLog();
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					Date date = new Date();				
					userLogSave.setId(userLog.getId());
					userLogSave.setUserId(userLog.getUserId());
					userLogSave.setLoginTime(userLog.getLoginTime());
					userLogSave.setLogoutTime((dateFormat.format(date)));					
					loginService.saveUserLog(userLogSave);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		request.getSession().setAttribute("userId", "");
		request.getSession().setAttribute("facilityId", "");
		request.getSession().invalidate();
		return new ModelAndView(Login_page,"loginForm",new LoginForm());
		
	}
	
	@RequestMapping(value="/facility") 
	 public ModelAndView getFacilities(ModelMap model) {
		 
		 try {
			List<Facility> facilities=loginService.getFacilities();
			model.addAttribute("facilities",facilities);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ModelAndView("facilityselect", "facilitySelectForm",new FacilitySelectForm());	     
	 }
	
	@RequestMapping(value="/getUserFacilityId") 
	public @ResponseBody
	String getFacilityId() {			
		return facilityId;	
	}
	
	@RequestMapping(value="/setFacility") 	
	public @ResponseBody
	String setFacilityId(HttpServletRequest request,HttpSession session,@RequestParam String id) {
		request.getSession().setAttribute("facilityId",id);
		UserLog userLog=new UserLog();		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		userLog.setUserId((session.getAttribute("userId").toString()));
		userLog.setLoginTime((dateFormat.format(date)));		
		try {
			loginService.saveUserLog(userLog);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	return "success";	
	}
	
	public void autoLogout() {
		System.out.println("In autoLogout-------------");
		
	}
	
}
/**
 * 
 */
package com.experion.pms.service.impl;

import java.util.List;

import com.experion.pms.dao.LoginDAO;
import com.experion.pms.entity.Facility;
import com.experion.pms.entity.Menu;
import com.experion.pms.entity.User;
import com.experion.pms.entity.UserLog;
import com.experion.pms.service.LoginService;

/**
 * @author AneeshChandran
 * 
 */
public class LoginServiceImpl implements
		LoginService {

	// private MessageSource messageSource;

	private LoginDAO loginDAO;
	
	/*private static final Log log = LogFactory
			.getLog(PatientSearchServiceImpl.class);*/
	
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public User loginAction(String email, String password) throws Exception {
		
		return loginDAO.loginAction(email, password);
	}

	public List<Facility> getFacilities() throws Exception {
		
		return loginDAO.getFacilities();
	}
	
	public List<Object> getDetails(String entityName, String whereField,
			String whereValue, String orderBy) throws Exception {
		
		return loginDAO.getDetails(entityName, whereField, whereValue, orderBy);
	}

	public void saveUserLog(UserLog userLog) throws Exception {
		
		loginDAO.saveUserLog(userLog);
	}

	public UserLog getMaxId(String userId) throws Exception {
		
		return loginDAO.getMaxId(userId);
	}

	public List<Menu> getMenu(String roleId) throws Exception {
		
		return loginDAO.getMenu(roleId);
	}

	public User updatePassword(String id, String oldPassword,String newPassword) throws Exception {
		
		return loginDAO.updatePassword(id, oldPassword, newPassword);
	}

	
}
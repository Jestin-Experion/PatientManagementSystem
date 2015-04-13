/**
 * 
 */
package com.experion.pms.service;

import java.util.List;

import com.experion.pms.entity.Facility;
import com.experion.pms.entity.Menu;
import com.experion.pms.entity.User;
import com.experion.pms.entity.UserLog;



/**
 * @author AneeshChandran
 * 
 */
public interface LoginService {

	public User loginAction(String email,String password) throws Exception;	
	public List<Facility> getFacilities() throws Exception;	
	public List<Object> getDetails(String entityName,String whereField,String whereValue,String orderBy) throws Exception;
	public void saveUserLog(UserLog userLog) throws Exception;
	public UserLog getMaxId(String userId) throws Exception;
	public List<Menu> getMenu(String roleId) throws Exception;
	public User updatePassword(String id,String oldPassword,String newPassword) throws Exception;
}

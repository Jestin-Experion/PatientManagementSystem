/**
 * 
 */
package com.experion.pms.dao.hibernate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.experion.pms.dao.LoginDAO;
import com.experion.pms.entity.Facility;
import com.experion.pms.entity.Menu;
import com.experion.pms.entity.User;
import com.experion.pms.entity.UserLog;

/**
 * @author AneeshChandran
 * 
 */
public class LoginHibernateDAO extends BaseHibernateDAO<Object>
		implements LoginDAO {

	private static final long serialVersionUID = 6484250259100963808L;
	
	
	
	public User loginAction(String email, String password) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<User> users = getHibernateTemplate().find("from User where email = ? and password=? and status='Active'", email,password);			
			if (users != null && !users.isEmpty()) {
				return users.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	public List<Facility> getFacilities() throws Exception {
		@SuppressWarnings("unchecked")
		List<Facility> facilities = getHibernateTemplate().find("from Facility where status='Active'");			
		if (facilities != null && !facilities.isEmpty()) {
			return facilities;
		}
		return null;
	}

	public void saveUserLog(UserLog userLog) throws Exception {
		
		getHibernateTemplate().merge(userLog);
	}

	public UserLog getMaxId(String userId) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<UserLog> userLogs = getHibernateTemplate().find("from UserLog where userId = ? and id=(select max(id) from UserLog)",userId);			
			if (userLogs != null && !userLogs.isEmpty()) {
				return userLogs.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Menu> getMenu(String roleId) throws Exception {		
		String query=" Select m from Menu as m inner join fetch m.subMenus as sm inner join sm.privileges as p inner join p.PrivilageUserRole as pur "
				+ "where m.id=sm.menuId and sm.id=p.subMenuId and p.roleId=pur.id and pur.id=? order by m.id ASC";
		
		List<Menu> menus = getHibernateTemplate().find(query,roleId);	
		if (menus != null && !menus.isEmpty()) {
			Set<Menu> menuSet=new HashSet<Menu>();
			for (Menu menu : menus) {
				menuSet.add(menu);
			}
			List<Menu> menuList=new LinkedList<Menu>();
			for (Menu menu : menuSet) {
				menuList.add(menu);
			}
			Collections.sort(menuList, new Comparator<Menu>() {
		        public int compare(final Menu object1, final Menu object2) {
		            return object1.getId().compareTo(object2.getId());
		        }
		       } );
			return menuList;
		}
		return null;
	}

	public User updatePassword(String id, String oldPassword,String newPassword) throws Exception {
		try {
			@SuppressWarnings("unchecked")
			List<User> user = getHibernateTemplate().find("from User where id = ? and password=?)",id,oldPassword);			
			if (user != null && !user.isEmpty()) {	
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				User u=new User();
				u.setId(id);
				u.setEmail(user.get(0).getEmail());
				u.setPassword(newPassword);
				u.setUserName(user.get(0).getUserName());
				u.setPrimaryFacilityId(user.get(0).getPrimaryFacilityId());
				u.setRoleId(user.get(0).getRoleId());
				u.setStatus(user.get(0).getStatus());
				u.setCreatedBy(user.get(0).getCreatedBy());
				u.setCreatedOn(user.get(0).getCreatedOn());
				u.setUpdatedBy(id);			
				u.setUpdatedOn(dateFormat.format(date));
				getHibernateTemplate().merge(u);
				return user.get(0);
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	
}
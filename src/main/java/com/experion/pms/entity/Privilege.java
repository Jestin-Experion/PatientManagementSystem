/**
 * 
 */
package com.experion.pms.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "Privileges")
public class Privilege implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "RoleId")
	private String roleId;
	
	@Column(name = "SubMenuId")
	private String subMenuId;
	
	@Column(name = "Status")
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL,optional=false)	
	@JoinColumn(name = "RoleId", insertable=false, updatable=false )
	private UserRole PrivilageUserRole;
	
	@ManyToOne(cascade = CascadeType.ALL,optional=false)	
	@JoinColumn(name = "SubMenuId", insertable=false, updatable=false )
	private SubMenu privilageSubMenu;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(String subMenuId) {
		this.subMenuId = subMenuId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserRole getPrivilageUserRole() {
		return PrivilageUserRole;
	}

	public void setPrivilageUserRole(UserRole privilageUserRole) {
		PrivilageUserRole = privilageUserRole;
	}

	public SubMenu getPrivilageSubMenu() {
		return privilageSubMenu;
	}

	public void setPrivilageSubMenu(SubMenu privilageSubMenu) {
		this.privilageSubMenu = privilageSubMenu;
	}
	
	
}
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
@Table(name = "UserDetails")
public class User implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "UserName")
	private String userName;
	
	@Column(name = "PrimaryFacilityId")
	private String primaryFacilityId;
	
	@Column(name = "RoleId")
	private String roleId;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "CreatedOn")
	private String createdOn;
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name = "UpdatedOn")
	private String updatedOn;
	
	@Column(name = "UpdatedBy")
	private String updatedBy;
	
	
	@ManyToOne(cascade = CascadeType.ALL,optional=false)	
	@JoinColumn(name = "RoleId", insertable=false, updatable=false )
	private UserRole userUserRole;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPrimaryFacilityId() {
		return primaryFacilityId;
	}

	public void setPrimaryFacilityId(String primaryFacilityId) {
		this.primaryFacilityId = primaryFacilityId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserRole getUserUserRole() {
		return userUserRole;
	}

	public void setUserUserRole(UserRole userUserRole) {
		this.userUserRole = userUserRole;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	
}
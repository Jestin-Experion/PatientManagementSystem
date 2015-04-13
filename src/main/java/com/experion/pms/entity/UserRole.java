/**
 * 
 */
package com.experion.pms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "UserRole")
public class UserRole implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "RoleName")
	private String roleName;
	
	@Column(name = "Description")
	private String description;
	
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "PrivilageUserRole", fetch = FetchType.LAZY)	
	private List<Privilege> privilages;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userUserRole", fetch = FetchType.LAZY)	
	private List<User> users;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public List<Privilege> getPrivilages() {
		return privilages;
	}

	public void setPrivilages(List<Privilege> privilages) {
		this.privilages = privilages;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}	
	
	
}
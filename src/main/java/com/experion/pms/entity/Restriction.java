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
@Table(name = "Restrictions")
public class Restriction implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "RestrictionName",unique=true)
	private String restrictionName;
	
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
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restriction", fetch = FetchType.EAGER)	
	private List<RestrictionList> restrictionLists;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRestrictionName() {
		return restrictionName;
	}

	public void setRestrictionName(String restrictionName) {
		this.restrictionName = restrictionName;
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

	public List<RestrictionList> getRestrictionLists() {
		return restrictionLists;
	}

	public void setRestrictionLists(List<RestrictionList> restrictionLists) {
		this.restrictionLists = restrictionLists;
	}

	@Override
	public String toString() {
		return "Restriction [restrictionName=" + restrictionName
				+ ", restrictionLists=" + restrictionLists + "]";
	}

	

}

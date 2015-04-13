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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
/*@FilterDef(name = "diseaseFilter", parameters = {@ParamDef(name = "diseaseList", type = "string")})*/
@Table(name = "PatientRegistration")
public class PatientRegistration implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "RegistrationNumber",unique=true)
	private String registrationNumber;
	
	@Column(name = "RegAt")
	private String regAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RegAt", nullable = false,insertable=false,updatable=false)
	private Facility regFacility;
	
	@Column(name = "RegOn")
	private String regOn;
	
	@Column(name = "FileNumber")
	private String fileNumber;
	
	@Column(name = "PatientName")
	private String patientName;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "DOB")
	private String dob;
	

	@Column(name = "Email")
	private String email;
	
	@Column(name = "Address")
	private String address;	
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patient", fetch = FetchType.EAGER)
	private List<PatientVisit> patientVisits;
	/*@Filter(name = "diseaseFilter", condition = "city_name = :cityName")*/
	/*@Where(clause="Id=3")*/
	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}	

	public String getRegOn() {
		return regOn;
	}


	public void setRegOn(String regOn) {
		this.regOn = regOn;
	}


	public String getFileNumber() {
		return fileNumber;
	}


	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<PatientVisit> getPatientVisits() {
		return patientVisits;
	}


	public void setPatientVisits(List<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}


	public Facility getRegFacility() {
		return regFacility;
	}


	public void setRegFacility(Facility regFacility) {
		this.regFacility = regFacility;
	}


	public String getRegAt() {
		return regAt;
	}


	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	
}

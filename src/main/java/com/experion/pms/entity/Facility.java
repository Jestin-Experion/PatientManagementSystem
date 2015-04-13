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
@Table(name = "Facility")
public class Facility implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "FacilityName")
	private String facilityName;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "DistrictId")
	private String districtId;
	
	@Column(name = "StateId")
	private String stateId;
	
	@Column(name = "NearestPharmacy")
	private String nearestPharmacy;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Remarks")
	private String remarks;
	
	@Column(name = "PhoneNumber1")
	private String phoneNumber1;
	
	@Column(name = "PhoneNumber2")
	private String phoneNumber2;
	
	@Column(name = "MobileNumber")
	private String mobileNumber;
	
	@Column(name = "VisitTime")
	private String visitTime;
	
	@Column(name = "HasPharmacy")
	private String hasPharmacy;
		
	@Column(name = "IsHospital")
	private String isHospital;
	
	@Column(name = "Status")
	private String status;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facility", fetch = FetchType.EAGER)	
	private List<PatientVisit> patientVisits;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regFacility", fetch = FetchType.LAZY)	
	private List<PatientRegistration> regDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getNearestPharmacy() {
		return nearestPharmacy;
	}

	public void setNearestPharmacy(String nearestPharmacy) {
		this.nearestPharmacy = nearestPharmacy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getHasPharmacy() {
		return hasPharmacy;
	}

	public void setHasPharmacy(String hasPharmacy) {
		this.hasPharmacy = hasPharmacy;
	}

	public String getIsHospital() {
		return isHospital;
	}

	public void setIsHospital(String isHospital) {
		this.isHospital = isHospital;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PatientVisit> getPatientVisits() {
		return patientVisits;
	}

	public void setPatientVisits(List<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}

	public List<PatientRegistration> getRegDetails() {
		return regDetails;
	}

	public void setRegDetails(List<PatientRegistration> regDetails) {
		this.regDetails = regDetails;
	}

	@Override
	public String toString() {
		return "Facility [id=" + id + ", facilityName=" + facilityName + "]";
	}

	

	
	
	
}
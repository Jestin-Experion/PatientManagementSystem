package com.experion.pms.vo;


public class PatientSearchVO {
	
	private String id;
	private String registrationNumber;
	private String facility;	
	private String fileNumber;
	private String patientName;
	private String gender;
	
	
	private String diseaseClassification;
	private String diseaseSubClassification;	
	private String diseaseSelected;
	private String visitDateFrom;
	private String visitDateTo;
	private String ageFrom;
	private String ageTo;

	

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

	public String getFacility() {
		return facility;
	}


	public void setFacility(String facility) {
		this.facility = facility;
	}
	
	
	

	public String getDiseaseClassification() {
		return diseaseClassification;
	}


	public void setDiseaseClassification(String diseaseClassification) {
		this.diseaseClassification = diseaseClassification;
	}


	public String getDiseaseSubClassification() {
		return diseaseSubClassification;
	}


	public void setDiseaseSubClassification(String diseaseSubClassification) {
		this.diseaseSubClassification = diseaseSubClassification;
	}


	public String getDiseaseSelected() {
		return diseaseSelected;
	}


	public void setDiseaseSelected(String diseaseSelected) {
		this.diseaseSelected = diseaseSelected;
	}


	public String getVisitDateFrom() {
		return visitDateFrom;
	}


	public void setVisitDateFrom(String visitDateFrom) {
		this.visitDateFrom = visitDateFrom;
	}


	public String getVisitDateTo() {
		return visitDateTo;
	}


	public void setVisitDateTo(String visitDateTo) {
		this.visitDateTo = visitDateTo;
	}


	public String getAgeFrom() {
		return ageFrom;
	}


	public void setAgeFrom(String ageFrom) {
		this.ageFrom = ageFrom;
	}


	public String getAgeTo() {
		return ageTo;
	}


	public void setAgeTo(String ageTo) {
		this.ageTo = ageTo;
	}



}
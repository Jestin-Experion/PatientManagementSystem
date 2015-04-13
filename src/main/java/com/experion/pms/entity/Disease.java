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
@Table(name = "Diseases")
public class Disease implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "DiseaseName",unique=true)
	private String diseaseName;
	
	@Column(name = "AyurvedaName")
	private String ayurvedaName;
	
	@Column(name = "ClassificationId")
	private String classificationId;
	
	@Column(name = "SubClassificationId")
	private String subClassificationId;
	
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
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ClassificationId", nullable = false,insertable=false,updatable=false)
	private DiseaseClassification diseaseClassificationName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SubClassificationId", nullable = false,insertable=false,updatable=false)
	private DiseaseSubClassification diseaseSubClassificationName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "disease", fetch = FetchType.LAZY)	
	private List<PatientDisease> patientDiseases;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getAyurvedaName() {
		return ayurvedaName;
	}

	public void setAyurvedaName(String ayurvedaName) {
		this.ayurvedaName = ayurvedaName;
	}

	public List<PatientDisease> getPatientDiseases() {
		return patientDiseases;
	}

	public void setPatientDiseases(List<PatientDisease> patientDiseases) {
		this.patientDiseases = patientDiseases;
	}

	public String getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(String classificationId) {
		this.classificationId = classificationId;
	}

	public String getSubClassificationId() {
		return subClassificationId;
	}

	public void setSubClassificationId(String subClassificationId) {
		this.subClassificationId = subClassificationId;
	}

	public DiseaseClassification getDiseaseClassificationName() {
		return diseaseClassificationName;
	}

	public void setDiseaseClassificationName(
			DiseaseClassification diseaseClassificationName) {
		this.diseaseClassificationName = diseaseClassificationName;
	}

	public DiseaseSubClassification getDiseaseSubClassificationName() {
		return diseaseSubClassificationName;
	}

	public void setDiseaseSubClassificationName(
			DiseaseSubClassification diseaseSubClassificationName) {
		this.diseaseSubClassificationName = diseaseSubClassificationName;
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
	
}

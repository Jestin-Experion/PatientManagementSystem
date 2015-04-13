/**
 * 
 */
package com.experion.pms.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "PatientDiseases")
public class PatientDisease implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;

	@Id
	@Column(name = "Id")
	private String id;
	
	@Column(name = "DiseasesId")
	private String diseasesId;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DiseasesId", nullable = false,insertable=false,updatable=false)
	private Disease disease;
	
	@Column(name = "DiseaseStatus")
	private String diseaseStatus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "VisitId", nullable = false)
	private PatientVisit patientVisit;
	
	@Column(name = "Description")
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public String getDiseaseStatus() {
		return diseaseStatus;
	}

	public void setDiseaseStatus(String diseaseStatus) {
		this.diseaseStatus = diseaseStatus;
	}

	public PatientVisit getPatientVisit() {
		return patientVisit;
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit = patientVisit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiseasesId() {
		return diseasesId;
	}

	public void setDiseasesId(String diseasesId) {
		this.diseasesId = diseasesId;
	}

	@Override
	public String toString() {
		return "PatientDisease [id=" + id + ", diseasesId=" + diseasesId
				+ ", description=" + description + "]";
	}

		
}
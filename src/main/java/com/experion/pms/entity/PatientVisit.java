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
@Table(name = "PatientVisit")
public class PatientVisit implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;	
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "PatientId")
	private String patientId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PatientId", nullable = false,insertable=false,updatable=false)
	private PatientRegistration patient;
	
	@Column(name = "FacilityId")
	private String facilityId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FacilityId", nullable = false,insertable=false,updatable=false)
	private Facility facility;
	
	@Column(name = "DoctorId")
	private String doctorId;
	
	@Column(name = "VisitDate")
	private String visitDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "patientVisit", fetch = FetchType.LAZY)	
	private List<PatientDisease> patientDiseases;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public PatientRegistration getPatient() {
		return patient;
	}

	public void setPatient(PatientRegistration patient) {
		this.patient = patient;
	}


	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public List<PatientDisease> getPatientDiseases() {
		return patientDiseases;
	}

	public void setPatientDiseases(List<PatientDisease> patientDiseases) {
		this.patientDiseases = patientDiseases;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	
	
}

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
@Table(name = "DiseaseClassification")
public class DiseaseClassification implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "Classification",unique=true)
	private String classification;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "diseaseClassification", fetch=FetchType.EAGER )	
	private List<DiseaseSubClassification> diseaseSubClassification;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "diseaseClassificationName", fetch=FetchType.LAZY )	
	private List<Disease> diseasesByClassification ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public List<DiseaseSubClassification> getDiseaseSubClassification() {
		return diseaseSubClassification;
	}

	public void setDiseaseSubClassification(
			List<DiseaseSubClassification> diseaseSubClassification) {
		this.diseaseSubClassification = diseaseSubClassification;
	}

	public List<Disease> getDiseasesByClassification() {
		return diseasesByClassification;
	}

	public void setDiseasesByClassification(List<Disease> diseasesByClassification) {
		this.diseasesByClassification = diseasesByClassification;
	}


}

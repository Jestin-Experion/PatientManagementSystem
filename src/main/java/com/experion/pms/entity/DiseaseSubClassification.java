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
@Table(name = "DiseaseSubClassification")
public class DiseaseSubClassification implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "SubClassification",unique=true)
	private String subClassification;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ClassificationId", nullable = false)
	private DiseaseClassification diseaseClassification;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "diseaseSubClassificationName", fetch=FetchType.LAZY )	
	private List<Disease> diseasesBySubClassification ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubClassification() {
		return subClassification;
	}

	public void setSubClassification(String subClassification) {
		this.subClassification = subClassification;
	}

	public DiseaseClassification getDiseaseClassification() {
		return diseaseClassification;
	}

	public void setDiseaseClassification(DiseaseClassification diseaseClassification) {
		this.diseaseClassification = diseaseClassification;
	}

	public List<Disease> getDiseasesBySubClassification() {
		return diseasesBySubClassification;
	}

	public void setDiseasesBySubClassification(
			List<Disease> diseasesBySubClassification) {
		this.diseasesBySubClassification = diseasesBySubClassification;
	}

	
}

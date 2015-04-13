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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * @author AneeshChandran
 *
 */

@Entity
@Table(name = "Menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "MenuName",unique=true)
	private String menuName;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "RedirectionUrl")
	private String redirectionUrl;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "menu", fetch = FetchType.EAGER)	
	@Where(clause="status='Active'")
	@OrderBy("id")
	private List<SubMenu> subMenus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	
	public String getRedirectionUrl() {
		return redirectionUrl;
	}

	public void setRedirectionUrl(String redirectionUrl) {
		this.redirectionUrl = redirectionUrl;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuName=" + menuName + ", subMenus="
				+ subMenus + "]";
	}
	
	
}
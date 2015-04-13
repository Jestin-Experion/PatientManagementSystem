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
@Table(name = "SubMenu")
public class SubMenu implements Serializable {

	private static final long serialVersionUID = 5110000555475069551L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private String id;
	
	@Column(name = "SubMenuName",unique=true)
	private String subMenuName;
	
	@Column(name = "MenuId")
	private String menuId;
	
	@Column(name = "Status")
	private String status;
	
	@Column(name = "TypeIdentifier")
	private String typeIdentifier;
	
	@Column(name = "RedirectionUrl")
	private String redirectionUrl;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MenuId",insertable=false,updatable=false)
	private Menu menu;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "privilageSubMenu", fetch = FetchType.LAZY)	
	private List<Privilege> privileges;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeIdentifier() {
		return typeIdentifier;
	}

	public void setTypeIdentifier(String typeIdentifier) {
		this.typeIdentifier = typeIdentifier;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
	public String getRedirectionUrl() {
		return redirectionUrl;
	}

	public void setRedirectionUrl(String redirectionUrl) {
		this.redirectionUrl = redirectionUrl;
	}

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "SubMenu [id=" + id + ", subMenuName=" + subMenuName
				+ ", menuId=" + menuId + "]";
	}

	
	
	
}
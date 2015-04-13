package com.experion.pms.mvc.data;

import java.io.Serializable;

public class RestrictionManagementForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -169626869927070996L;
	
	private String restrictionId;
	private String restrictionName;
	private String description;
	private String status;
	private String messageText;
	
	
	
	public String getRestrictionId() {
		return restrictionId;
	}
	public void setRestrictionId(String restrictionId) {
		this.restrictionId = restrictionId;
	}
	public String getRestrictionName() {
		return restrictionName;
	}
	public void setRestrictionName(String restrictionName) {
		this.restrictionName = restrictionName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	
}
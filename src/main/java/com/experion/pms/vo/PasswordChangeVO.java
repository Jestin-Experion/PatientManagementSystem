package com.experion.pms.vo;

import java.io.Serializable;

public class PasswordChangeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -169626869927070996L;
	
	private String oldPassword;
	private String newPassword;
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	

	
}
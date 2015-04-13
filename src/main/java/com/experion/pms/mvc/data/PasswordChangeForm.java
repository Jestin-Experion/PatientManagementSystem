package com.experion.pms.mvc.data;

import java.io.Serializable;

public class PasswordChangeForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -169626869927070996L;
	
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
}
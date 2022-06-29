package com.cinemaEgrid.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty(message = "{IDnotEmpty}")
	@Size(max = 20, message = "{IDcheck}")
	private String id;

	@NotEmpty(message = "{PASSnotEmpty}")
	@Size(max = 60, message = "{PASScheck}")
	private String pass;

	private String adminId;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

}

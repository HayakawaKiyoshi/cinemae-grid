package com.cinemaEgrid.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SubmitForm {

	@NotEmpty(message = "{IDnotEmpty}")
	@Size(max = 20, message = "{IDcheck}")
	private String id;

	@NotEmpty(message = "{MAILnotEmpty}")
	@Size(max = 60, message = "{MAILcheck}")
	private String mail;

	@NotEmpty(message = "{NAMEnotEmpty}")
	@Size(max = 60, message = "{NAMEcheck}")
	private String name;

	@NotEmpty(message = "{PASSnotEmpty}")
	@Size(max = 60,  message = "{PASScheck}")
	private String pass;

	@NotEmpty(message = "{AUTHORITYnotEmpty}")
	private String authority;

	@NotEmpty
	private String del_flg;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

}

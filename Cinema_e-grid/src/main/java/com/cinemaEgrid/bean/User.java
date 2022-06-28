package com.cinemaEgrid.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty(message = "{0}を入力してください。")
	private String user_id;

	@NotEmpty(message = "{0}を入力してください。")
	@Email(message = "{0}を正しく入力してください。")
	private String user_mail;

	@NotEmpty(message = "{0}を入力してください。")
	private String user_name;

	@NotEmpty(message = "{0}を入力してください。")
//	@Pattern(regexp = "^[0-9]+$", message = "数値を入力してください。")
	private String password;

	@NotEmpty(message = "{0}を入力してください。")
	private String authority;

	private String user_del_flg;


	public User(String user_id, String user_mail, String user_name,
			String password, String authority, String user_del_flg) {
		this.user_id = user_id;
		this.user_mail = user_mail;
		this.user_name = user_name;
		this.password = password;
		this.authority = authority;
		this.user_del_flg = user_del_flg;
	}

	public User() {

	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUser_del_flg() {
		return user_del_flg;
	}

	public void setUser_del_flg(String user_del_flg) {
		this.user_del_flg = user_del_flg;
	}

}

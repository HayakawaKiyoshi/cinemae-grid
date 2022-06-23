package com.cinemaEgrid.bean;

public class User_TableBean {

	private String user_id;
	private String user_mail;
	private String user_name;
	private String password;
	private String authority;
	private String user_del_flg;


	public User_TableBean(String user_id, String user_mail, String user_name,
			String password, String authority, String user_del_flg) {
		this.user_id = user_id;
		this.user_mail = user_mail;
		this.user_name = user_name;
		this.password = password;
		this.authority = authority;
		this.user_del_flg = user_del_flg;
	}

	public User_TableBean() {

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

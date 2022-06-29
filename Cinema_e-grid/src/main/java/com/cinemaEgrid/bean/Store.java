package com.cinemaEgrid.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
* 店舗情報
* @author iwai
*
*/
public class Store {

	private int store_no;

	@NotEmpty(message = "{0}を入力してください。")
	@Size(max = 60)
	private String store_name;

	@NotEmpty(message = "{0}を入力してください。")
	@Size(max = 60)
	private String store_location;

	private int store_del_flg;

	public Store(){}

	public int getStore_no() {
		return store_no;
	}

	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_location() {
		return store_location;
	}

	public void setStore_location(String store_location) {
		this.store_location = store_location;
	}

	public int getStore_del_flg() {
		return store_del_flg;
	}

	public void setStore_del_flg(int store_del_flg) {
		this.store_del_flg = store_del_flg;
	}

}

package com.cinemaEgrid.bean;

/**
* 店舗情報
* @author iwai
*
*/
public class Store {

	private int store_id;
	private String store_name;
	private String store_location;
	private int store_del_flg;

	public Store(){}

	public Store(int store_id, String store_name,
			String store_location, int store_del_flg){
		this.store_id = store_id;
		this.store_name = store_name;
		this.store_location = store_location;
		this.store_del_flg = store_del_flg;
	}


	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
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

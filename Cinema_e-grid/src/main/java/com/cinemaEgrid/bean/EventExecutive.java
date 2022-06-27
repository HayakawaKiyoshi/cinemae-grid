package com.cinemaEgrid.bean;

public class EventExecutive {

	private String event_id;
	private String update_title;
	private String event_content;
	private String update_daet;

	public EventExecutive(String id, String title, String content, String date) {
		this.event_id = id;
		this.update_title = title;
		this.event_content = content;
		this.update_daet = date;
	}

	public EventExecutive() {

	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getUpdate_title() {
		return update_title;
	}

	public void setUpdate_title(String update_title) {
		this.update_title = update_title;
	}

	public String getEvent_content() {
		return event_content;
	}

	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}

	public String getUpdate_daet() {
		return update_daet;
	}

	public void setUpdate_daet(String update_daet) {
		this.update_daet = update_daet;
	}

}

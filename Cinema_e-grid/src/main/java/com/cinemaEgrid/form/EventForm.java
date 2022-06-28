package com.cinemaEgrid.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EventForm {

	@NotEmpty
	@Size(max = 25)
	private String eventTitle;

	@NotEmpty
	@Size(max = 150)
	private String eventContent;

	@NotEmpty
	private String updateDate;


	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}

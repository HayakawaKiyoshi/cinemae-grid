package com.cinemaEgrid.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ScheduleForm {

	@NotEmpty(message = "{DATEnotEmpty}")
	private String date;

	@NotEmpty(message = "{NAMEnotEmpty}")
	@Size(max = 30, message = "{NAMEcheck}")
	private String name;

	@NotEmpty(message = "{TIMEnotEmpty}")
	@Size(max = 15, message = "{TIMEcheck}")
	private String movieTime;

	private String ageLevel;

	@Size(max = 150, message = "{REMARKSnotEmpty}")
	private String content;

	@NotEmpty(message = "{STATUSnotEmpty}")
	private String statusSchedule;

	@NotEmpty(message = "{NOnotEmpty}")
	private String no;

	@NotEmpty(message = "{TIMEnotEmpty}")
	private String time;


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public String getAgeLevel() {
		return ageLevel;
	}
	public void setAgeLevel(String ageLevel) {
		this.ageLevel = ageLevel;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStatusSchedule() {
		return statusSchedule;
	}
	public void setStatusSchedule(String status) {
		this.statusSchedule = status;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}


}

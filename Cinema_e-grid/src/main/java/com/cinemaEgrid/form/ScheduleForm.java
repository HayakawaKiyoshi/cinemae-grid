package com.cinemaEgrid.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class ScheduleForm {

	@NotEmpty
	private String date;

	@NotEmpty
	@Size(max = 30)
	private String name;

	@NotEmpty
	@Size(max = 15)
	private String movieTime;

	@NotEmpty
	private String ageLevel;

	@Size(max = 150)
	private String content;

	@NotEmpty
	private String statusSchedule;

	@NotEmpty
	private String no;

	@NotEmpty
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

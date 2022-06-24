package com.cinemaEgrid.bean;

public class Schedule {

	String schedule_date;
	int schedule_no;
	String schedule_time;
	String schedule_name;
	String schedule_movie_time;
	String schedule_age_level;
	String schedule_content;

	public Schedule(String schedule_date,int schedule_no, String schedule_time, String schedule_name, String schedule_movie_time,
			String schedule_age_level, String schedule_content) {
		this.schedule_date = schedule_date;
		this.schedule_no = schedule_no;
		this.schedule_time = schedule_time;
		this.schedule_name = schedule_name;
		this.schedule_movie_time = schedule_movie_time;
		this.schedule_age_level = schedule_age_level;
		this.schedule_content = schedule_content;
	}
	public int getSchedule_no() {
		return schedule_no;
	}
	public void setSchedule_no(int schedule_no) {
		this.schedule_no = schedule_no;
	}
	public String getSchedule_time() {
		return schedule_time;
	}
	public void setSchedule_time(String schedule_time) {
		this.schedule_time = schedule_time;
	}
	public String getSchedule_name() {
		return schedule_name;
	}
	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}
	public String getSchedule_movie_time() {
		return schedule_movie_time;
	}
	public void setSchedule_movie_time(String schedule_movie_time) {
		this.schedule_movie_time = schedule_movie_time;
	}
	public String getSchedule_age_level() {
		return schedule_age_level;
	}
	public void setSchedule_age_level(String schedule_age_level) {
		this.schedule_age_level = schedule_age_level;
	}
	public String getSchedule_content() {
		return schedule_content;
	}
	public void setSchedule_content(String schedule_content) {
		this.schedule_content = schedule_content;
	}
	public String getSchedule_date() {
		return schedule_date;
	}
	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}
}

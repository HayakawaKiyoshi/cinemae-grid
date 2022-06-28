package com.cinemaEgrid.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScheduleExecutive {

	private String Schedule_date;
	private String Schedule_no;
	private String Schedule_time;
	private String Schedule_name;
	private String Schedule_movie_time;
	private String Schedule_age_level;
	private String Schedule_content;
	private String Schedule_status;

	public ScheduleExecutive(Date date, String no, String time, String name,
			String movie, String age, String content, String status) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy/MM/dd");
		this.Schedule_date = sm.format(date);
		this.Schedule_no = no;
		this.Schedule_time = time;
		this.Schedule_name = name;
		this.Schedule_movie_time = movie;
		this.Schedule_age_level = age;
		this.Schedule_content = content;
		this.Schedule_status = status;
	}

	public ScheduleExecutive() {

	}

	public String getSchedule_date() {
		return Schedule_date;
	}

	public void setSchedule_date(String schedule_date) {
		Schedule_date = schedule_date;
	}

	public String getSchedule_no() {
		return Schedule_no;
	}

	public void setSchedule_no(String schedule_no) {
		Schedule_no = schedule_no;
	}

	public String getSchedule_time() {
		return Schedule_time;
	}

	public void setSchedule_time(String schedule_time) {
		Schedule_time = schedule_time;
	}

	public String getSchedule_name() {
		return Schedule_name;
	}

	public void setSchedule_name(String schedule_name) {
		Schedule_name = schedule_name;
	}

	public String getSchedule_movie_time() {
		return Schedule_movie_time;
	}

	public void setSchedule_movie_time(String schedule_movie_time) {
		Schedule_movie_time = schedule_movie_time;
	}

	public String getSchedule_age_level() {
		return Schedule_age_level;
	}

	public void setSchedule_age_level(String schedule_age_level) {
		Schedule_age_level = schedule_age_level;
	}

	public String getSchedule_content() {
		return Schedule_content;
	}

	public void setSchedule_content(String schedule_content) {
		Schedule_content = schedule_content;
	}

	public String getSchedule_status() {
		return Schedule_status;
	}

	public void setSchedule_status(String schedule_status) {
		Schedule_status = schedule_status;
	}
}

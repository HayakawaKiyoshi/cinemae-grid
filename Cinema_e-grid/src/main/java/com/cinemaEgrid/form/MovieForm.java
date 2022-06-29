package com.cinemaEgrid.form;

public class MovieForm {

	private String movie_title;
	private int genre_1;
	private int genre_2;
	private String time;
	private int age_level;
	private String release_day;
	private String remarks;
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public int getGenre_1() {
		return genre_1;
	}
	public void setGenre_1(int genre_1) {
		this.genre_1 = genre_1;
	}
	public int getGenre_2() {
		return genre_2;
	}
	public void setGenre_2(int genre_2) {
		this.genre_2 = genre_2;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRelease_day() {
		return release_day;
	}
	public void setRelease_day(String release_day) {
		this.release_day = release_day;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getAge_level() {
		return age_level;
	}
	public void setAge_level(int age_level) {
		this.age_level = age_level;
	}

}

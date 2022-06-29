package com.cinemaEgrid.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Movie {

	private int movie_no;

	@NotEmpty
	@Size(max = 60)
	private String movie_title;

	@NotNull
	private int genre1;

	@NotNull
	private int genre2;
	private String genre_name1;
	private String genre_name2;

	@NotEmpty
	@Size(max = 5)
	private String time;

	@NotNull
	private int age_level;

	@NotEmpty
	private String release_day;

	@NotEmpty
	@Size(max = 150)
	private String remarks;
	private int movie_del_flg;


	public String getGenre_name1() {
		return genre_name1;
	}

	public void setGenre_name1(String genre_name1) {
		this.genre_name1 = genre_name1;
	}

	public String getGenre_name2() {
		return genre_name2;
	}

	public void setGenre_name2(String genre_name2) {
		this.genre_name2 = genre_name2;
	}


	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public int getGenre1() {
		return genre1;
	}

	public void setGenre1(int genre1) {
		this.genre1 = genre1;
	}

	public int getGenre2() {
		return genre2;
	}

	public void setGenre2(int genre2) {
		this.genre2 = genre2;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getAge_level() {
		return age_level;
	}

	public void setAge_level(int age_level) {
		this.age_level = age_level;
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

	public int getMovie_del_flg() {
		return movie_del_flg;
	}

	public void setMovie_del_flg(int movie_del_flg) {
		this.movie_del_flg = movie_del_flg;
	}
}

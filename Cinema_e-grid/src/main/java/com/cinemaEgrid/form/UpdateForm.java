package com.cinemaEgrid.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateForm {

	@NotEmpty
	private String name;

	@NotEmpty
	private String email;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

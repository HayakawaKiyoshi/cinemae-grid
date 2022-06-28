package com.cinemaEgrid.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateForm {

	@NotEmpty
	@Size(max = 60)
	private String name;

	@NotEmpty
	@Size(max = 60)
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

package com.cinemaEgrid.form;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateForm {

	@NotEmpty(message = "{NAMEnotEmpty}")
	@Size(max = 60, message = "{NAMEcheck}")
	private String name;

	@NotEmpty(message = "{MAILnotEmpty}")
	@Size(max = 60, message = "{MAILcheck}")
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

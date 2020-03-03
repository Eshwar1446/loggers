package com.org.register.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component

public class LoginDTO {

	private String email;
	private String password;
	
	public LoginDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

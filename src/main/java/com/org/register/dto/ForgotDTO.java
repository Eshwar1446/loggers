package com.org.register.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component

public class ForgotDTO {
	
	private String email;
	private String password;
	private String confirmPassword;
	public ForgotDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}
	@Override
	public String toString() {
		return "ForgotDTO [email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}



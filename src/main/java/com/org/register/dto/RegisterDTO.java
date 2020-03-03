package com.org.register.dto;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component


public class RegisterDTO {
	private static Logger logger = Logger.getLogger(RegisterDTO.class);


	private String userName;
	private String email;
	private long phnNum;
	private String password;
	private String confirmPassword;
	
	public RegisterDTO() {
		logger.info(this.getClass().getSimpleName() + " obj created!");
		}

	@Override
	public String toString() {
		return "RegisterDTO [userName=" + userName + ", email=" + email + ", phnNum=" + phnNum + ", password="
				+ password + ", confirmPassword=" + confirmPassword + "]";
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		RegisterDTO.logger = logger;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhnNum() {
		return phnNum;
	}

	public void setPhnNum(long phnNum) {
		this.phnNum = phnNum;
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

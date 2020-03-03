package com.org.register.service;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.register.dao.ForgotDAO;
import com.org.register.dao.RegisterDAO;
import com.org.register.dto.ForgotDTO;
import com.org.register.entity.RegisterEntity;

@Service
public class ForgotServiceImpl implements ForgotService {

	@Autowired
	private ForgotDAO dao;

	public ForgotServiceImpl() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	public boolean validateForgotPassword(ForgotDTO dto) {
		boolean valid = false;
		try {
			System.out.println(" invoked validateForgot....");

			if (Objects.nonNull(dto)) {
				System.out.println("starting validation for " + dto);

				String Email = dto.getEmail();

				if (Email != null && Email.contains("@") && Email.length() >= 10) {
					System.out.println("Email is valid");
					valid = true;
					String Password = dto.getPassword();

					if (valid && Password != null && !Password.isEmpty() && Password.length() >= 6) {
						System.out.println("Password is valid");
						valid = true;

						String ConfirmPassword = dto.getConfirmPassword();
						if (valid && ConfirmPassword != null && !ConfirmPassword.isEmpty()
								&& ConfirmPassword.length() >= 6) {
							System.out.println("ConfirmPassword is valid");
							valid = true;

						} else {
							System.out.println("ConfirmPassword is invalid becuase its not same");
							valid = false;

						}

					} else {

						System.out.println("Password is invalid");
						valid = false;

					}
				} else {
					System.out.println("Email is invalid");
					valid = false;

				}

			}

			return valid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;

	}

	public String validateForgot(ForgotDTO dto) {

		RegisterEntity regEntity = new RegisterEntity();

		RegisterEntity regEntity1 = dao.fetchByEmail(dto.getEmail(), dto.getPassword());
		if (Objects.nonNull(regEntity1)) {

			System.out.println("Email Exist" + regEntity1);

		} else {
			System.out.println("Email doesnt exist");
		}
		return null;
	}
}

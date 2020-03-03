package com.org.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.register.dto.ForgotDTO;
import com.org.register.service.ForgotService;

@Component
@RequestMapping
public class ForgotController {

	@Autowired
	private ForgotService service;

	public ForgotController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/forgot.do")
	public String onForgot(ForgotDTO dto, ModelMap map) {

		try {

			String C = this.service.validateForgot(dto);
			boolean valid = this.service.validateForgotPassword(dto);
			if (valid) {
				ModelMap success = map.addAttribute("email", dto.getEmail());
				ModelMap success1 = map.addAttribute("password", dto.getPassword());
				ModelMap success2 = map.addAttribute("confirmPassword", dto.getConfirmPassword());
			} else {
				ModelMap failure = map.addAttribute("failureMessage", "forgotPassword unsuccessfull");
			}

			System.out.println("Invoked onForgot method");
			System.out.println(dto);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Forgot";
	}
}

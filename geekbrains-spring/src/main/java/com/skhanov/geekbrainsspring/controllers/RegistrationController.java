package com.skhanov.geekbrainsspring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skhanov.geekbrainsspring.domain.auth.Users;
import com.skhanov.geekbrainsspring.services.RegistrationService;

@Controller
@RequestMapping("registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@GetMapping
	public String showRegisitrationForm(Model model) {
		Users user = new Users();
		model.addAttribute("user", user);
		return "registration";
	}
	
	@PostMapping("add")
	public String registrateUser(@Valid @ModelAttribute("user") Users user, Errors errors) {
		if(errors.hasErrors()) {
			return "registration";
		}
		registrationService.addNewUser(user);
		return "home";
	}
}

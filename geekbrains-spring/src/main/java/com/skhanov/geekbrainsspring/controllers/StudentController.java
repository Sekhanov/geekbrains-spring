package com.skhanov.geekbrainsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skhanov.geekbrainsspring.data.AcademicPerformanceRepository;



@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private AcademicPerformanceRepository academicPerformanceRepository;

	
	@ModelAttribute
	public void addModelAttributes(Model model) {		
		model.addAttribute("academicPerformances", academicPerformanceRepository.findAll());
	}
	
	@GetMapping
	public String showStudentView() {
		return "student";
	}

	
}

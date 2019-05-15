package com.skhanov.geekbrainsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhanov.geekbrainsspring.data.AcademicPerformanceRepository;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;



@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private AcademicPerformanceRepository academicPerformanceRepository;
		

	
	@ModelAttribute
	public void addModelAttributes(Model model) {
		
		Pageable pageable = PageRequest.of(0, 3);
		Page<AcademicPerformance> data = academicPerformanceRepository.findAll(pageable);
		model.addAttribute("academicPerformances", data);
		model.addAttribute("pageNumber", data.getNumber());
	}
	
	@GetMapping
	public String showStudentView() {
		return "student";
	}
	
	@GetMapping("next")	
	public void nextPage(@ModelAttribute("academicPerformances") Page<AcademicPerformance> academicPerformances) {	
		academicPerformances = academicPerformanceRepository.findAll(academicPerformances.nextPageable()); 
		
	}

	
}

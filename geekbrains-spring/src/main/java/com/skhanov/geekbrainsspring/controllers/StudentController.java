package com.skhanov.geekbrainsspring.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skhanov.geekbrainsspring.data.AcademicPerformanceRepository;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;
import com.skhanov.geekbrainsspring.domain.university.Student;
import com.skhanov.geekbrainsspring.services.StudentService;



@Controller
@RequestMapping("student")
@Scope("session")
public class StudentController {
	
	@Autowired
	private AcademicPerformanceRepository academicPerformanceRepository;
	private Page<AcademicPerformance> data;
	@Autowired
	private StudentService studentService;
		

	
	@ModelAttribute
	public void addModelAttributes(Model model) {		
		Pageable pageable = PageRequest.of(0, 3);
		data = academicPerformanceRepository.findAll(pageable);	
		model.addAttribute("academicPerformances", data);
		model.addAttribute("pageNumber", data.getNumber() + 1);
	}
	
	@GetMapping
	public String showStudentView() {
		return "student";
	}
	

	@GetMapping("next")	
	public String nextPage(Model model) {
		if(data.hasNext()) {
			data = academicPerformanceRepository.findAll(data.nextPageable());
		}
		model.addAttribute("academicPerformances", data);
		model.addAttribute("pageNumber", data.getNumber() + 1);
		return "student";
	}
	
	@GetMapping("previous")
	public String previousPage(Model model) {
		if(data.hasPrevious()) {
			data = academicPerformanceRepository.findAll(data.previousPageable());
		}		
		model.addAttribute("academicPerformances", data);
		model.addAttribute("pageNumber", data.getNumber() + 1);
		return "student";
	}

	@PostMapping
	public String findStudentsByScore(Model model, @ModelAttribute("minScore") Optional<Integer> minScore, @ModelAttribute("maxScore") Optional<Integer> maxScore) {
		int min = minScore.orElse(0);
		int max = maxScore.orElse(0);
		
		List<AcademicPerformance> listAP =  academicPerformanceRepository.findByScoreBetween(min, max);		
		model.addAttribute("academicPerformances", listAP);
		return "student";
	}
	
	@GetMapping("add")
	public String showAddForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add-student";
	}
	
	@PostMapping("add")
	public String addStudent(@ModelAttribute("student") Student student, Principal principal) {
		studentService.addNewStudent(student, principal);
		return "student";
	}

	
}

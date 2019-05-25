package com.skhanov.geekbrainsspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skhanov.geekbrainsspring.data.CourseRepository;
import com.skhanov.geekbrainsspring.domain.university.Course;

@Controller
@RequestMapping("course")
public class CourceController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@PostMapping("add-course")
	public String addCourse(@ModelAttribute("courseName") String courceName) {
		Course course = new Course(courceName);	
		courseRepository.save(course);
		return "home";
	}
	
}

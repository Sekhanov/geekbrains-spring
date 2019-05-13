package com.skhanov.geekbrainsspring.data;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.university.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
	
	Course findByName(String name);
}

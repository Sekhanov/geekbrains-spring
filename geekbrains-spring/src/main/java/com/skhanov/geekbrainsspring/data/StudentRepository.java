package com.skhanov.geekbrainsspring.data;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.university.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
	Student findByName(String name);	
}

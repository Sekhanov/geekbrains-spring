package com.skhanov.geekbrainsspring.services;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhanov.geekbrainsspring.data.EmailRepository;
import com.skhanov.geekbrainsspring.data.PhoneRepository;
import com.skhanov.geekbrainsspring.data.StudentRepository;
import com.skhanov.geekbrainsspring.data.auth.UserRepository;
import com.skhanov.geekbrainsspring.domain.auth.Users;
import com.skhanov.geekbrainsspring.domain.university.Email;
import com.skhanov.geekbrainsspring.domain.university.Phone;
import com.skhanov.geekbrainsspring.domain.university.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private EmailRepository emailRepository;	

	
	public void addNewStudent(Student student, Principal principal) {
		Users user = userRepository.findById(principal.getName()).get();
		student.setAddUser(user);
		studentRepository.save(student);
		phoneRepository.save(new Phone(student.getNewPhone(), student));
		emailRepository.save(new Email(student.getNewEmail(), student));
		System.out.println("new student with Email and Phone was added");
		
	}

}

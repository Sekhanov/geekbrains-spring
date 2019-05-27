package com.skhanov.geekbrainsspring.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skhanov.geekbrainsspring.data.auth.UserRepository;
import com.skhanov.geekbrainsspring.domain.auth.Role;
import com.skhanov.geekbrainsspring.domain.auth.Users;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepository;
	
	
	public void addNewUser(Users user) {
		Role role = new Role();
		role.setName(user.getNewRole());
		Set<Role> set = new HashSet<>();
		set.add(role);
		user.setRoles(set);
		userRepository.save(user);
	}
}

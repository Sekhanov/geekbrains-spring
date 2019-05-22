package com.skhanov.geekbrainsspring.data.auth;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.auth.User;

public interface UserRepository extends CrudRepository<User, String>{

}

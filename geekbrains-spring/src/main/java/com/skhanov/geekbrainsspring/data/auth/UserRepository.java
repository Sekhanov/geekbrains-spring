package com.skhanov.geekbrainsspring.data.auth;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.auth.Users;

public interface UserRepository extends CrudRepository<Users, String>{

}

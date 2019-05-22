package com.skhanov.geekbrainsspring.data.auth;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.auth.Role;

public interface RoleRepository extends CrudRepository<Role, String> {

}

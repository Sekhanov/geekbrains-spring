package com.skhanov.geekbrainsspring.data;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.university.Email;

public interface EmailRepository extends CrudRepository<Email, Integer>{

}

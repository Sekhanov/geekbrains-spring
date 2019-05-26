package com.skhanov.geekbrainsspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skhanov.geekbrainsspring.domain.university.Phone;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer> {

}

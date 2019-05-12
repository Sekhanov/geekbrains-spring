package com.skhanov.geekbrainsspring.data;

import org.springframework.data.repository.CrudRepository;

import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformanceId;

public interface AcademicPerformanceRepository extends CrudRepository<AcademicPerformance, AcademicPerformanceId> {

}

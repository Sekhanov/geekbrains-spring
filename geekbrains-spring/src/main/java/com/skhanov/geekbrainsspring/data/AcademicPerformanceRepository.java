package com.skhanov.geekbrainsspring.data;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformanceId;

public interface AcademicPerformanceRepository extends PagingAndSortingRepository<AcademicPerformance, AcademicPerformanceId> {

	List<AcademicPerformance> findByScoreBetween(int min, int max);

}

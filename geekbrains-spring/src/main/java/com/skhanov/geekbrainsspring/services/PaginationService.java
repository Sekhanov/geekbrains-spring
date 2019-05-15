package com.skhanov.geekbrainsspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.skhanov.geekbrainsspring.data.AcademicPerformanceRepository;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;

@Service
public class PaginationService {
	
	@Autowired
	private AcademicPerformanceRepository academicPerformanceRepository;
	
	
	public Page<AcademicPerformance> findAllAcademicPerformanceByCondition(String orderBy, String direction, int page, int size) {
		Sort sort = new Sort(Direction.valueOf(orderBy), orderBy);
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<AcademicPerformance> data = academicPerformanceRepository.findAll(pageable);
		return data;
	}
}

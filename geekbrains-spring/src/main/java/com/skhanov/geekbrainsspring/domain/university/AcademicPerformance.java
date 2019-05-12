package com.skhanov.geekbrainsspring.domain.university;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class AcademicPerformance {
	
	@EmbeddedId
	@NonNull
	private AcademicPerformanceId academicPerformanceId;
	private int score;
	private int lessonsCount;

}

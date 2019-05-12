package com.skhanov.geekbrainsspring.domain.university;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AcademicPerformanceId implements Serializable {
	
	private static final long serialVersionUID = 8364546481967052042L;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	

}

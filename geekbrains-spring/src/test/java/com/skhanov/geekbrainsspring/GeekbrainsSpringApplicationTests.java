package com.skhanov.geekbrainsspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skhanov.geekbrainsspring.data.AcademicPerformanceRepository;
import com.skhanov.geekbrainsspring.data.CourseRepository;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;
import com.skhanov.geekbrainsspring.domain.university.Course;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeekbrainsSpringApplicationTests {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private AcademicPerformanceRepository academicPerformanceRepository;

	@Test	
	public void coursePersist() {
		Iterable<Course> courses = courseRepository.findAll();
		for (Course course : courses) {
			System.out.println(course.getStudents());			
		}			
	}
	
	@Test
	public void AcademicPerformancePersist() {
		Iterable<AcademicPerformance> academicPerformance = academicPerformanceRepository.findAll();
		for (AcademicPerformance ap : academicPerformance) {
			System.out.println(ap.getAcademicPerformanceId().getStudent().getName());
			System.out.println(ap.getAcademicPerformanceId().getCourse().getName());
			System.out.println(ap.getScore());
			System.out.println(ap.getLessonsCount());
			System.out.println("-------------------");
		}
		
	}	

}

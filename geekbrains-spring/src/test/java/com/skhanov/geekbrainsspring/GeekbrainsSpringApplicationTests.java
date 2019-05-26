package com.skhanov.geekbrainsspring;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skhanov.geekbrainsspring.data.AcademicPerformanceRepository;
import com.skhanov.geekbrainsspring.data.CourseRepository;
import com.skhanov.geekbrainsspring.data.StudentRepository;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;
import com.skhanov.geekbrainsspring.domain.university.Course;
import com.skhanov.geekbrainsspring.domain.university.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeekbrainsSpringApplicationTests {
	
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private AcademicPerformanceRepository academicPerformanceRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Test	
	@Ignore
	public void coursePersist() {
		Iterable<Course> courses = courseRepository.findAll();
		for (Course course : courses) {
			System.out.println(course.getStudents());			
		}			
	}
	
	@Test
	@Ignore
	public void academicPerformancePersist() {
		Iterable<AcademicPerformance> academicPerformance = academicPerformanceRepository.findAll();
		for (AcademicPerformance ap : academicPerformance) {
			System.out.println(ap.getAcademicPerformanceId().getStudent().getName());
			System.out.println(ap.getAcademicPerformanceId().getCourse().getName());
			System.out.println(ap.getScore());
			System.out.println(ap.getLessonsCount());
			System.out.println("-------------------");
		}
		
	}
	
	@Test
	public void studentPersist() {
		Iterable<Student> students = studentRepository.findAll();
		for(Student student: students) {
			System.out.println(student.getName());
			System.out.println(student.getSurname());
			System.out.println(student.getPhoneNumberList());
			System.out.println(student.getEmailList());
			System.out.println(student.getAddTime());
		}
	}

}

package com.skhanov.geekbrainsspring;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skhanov.geekbrainsspring.data.AcademicPerformanceRepository;
import com.skhanov.geekbrainsspring.data.CourseRepository;
import com.skhanov.geekbrainsspring.data.StudentRepository;
import com.skhanov.geekbrainsspring.domain.university.AcademicPerformance;
import com.skhanov.geekbrainsspring.domain.university.Course;
import com.skhanov.geekbrainsspring.domain.university.Student;

@SpringBootApplication
public class GeekbrainsSpringApplication implements CommandLineRunner {	
	
	@Autowired
	AcademicPerformanceRepository academicPerformanceRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(GeekbrainsSpringApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello~!");	
//		Iterable<AcademicPerformance> academicPerformance = academicPerformanceRepository.findAll();
//		for (AcademicPerformance ap : academicPerformance) {
//			System.out.println(ap.getAcademicPerformanceId().getStudent().getName());
//			System.out.println(ap.getAcademicPerformanceId().getCourse().getName());
//			System.out.println(ap.getScore());
//			System.out.println(ap.getLessonsCount());
//			System.out.println("-------------------");
//		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a name");
		String name = scanner.nextLine();
		List<Course> studentCources = getStudentsCources(name);
		for (Course course : studentCources) {
			System.out.println(course.getName());
		}
		
	}
	
	private List<Course> getStudentsCources(String name) {
		Student student = studentRepository.findByName(name);
		return student.getCourses();
	}

}



//@SpringBootApplication
//public class GeekbrainsSpringApplication implements WebMvcConfigurer {	
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("home");
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(GeekbrainsSpringApplication.class, args);
//	}
//
//}



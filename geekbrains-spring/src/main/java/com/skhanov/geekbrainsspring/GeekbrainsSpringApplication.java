package com.skhanov.geekbrainsspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class GeekbrainsSpringApplication implements WebMvcConfigurer {	

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/admin").setViewName("admin");
		}

	public static void main(String[] args) {
		SpringApplication.run(GeekbrainsSpringApplication.class, args);
	}

}

//@SpringBootApplication
//public class GeekbrainsSpringApplication implements CommandLineRunner {	
	
//	@Autowired
//	private AcademicPerformanceRepository academicPerformanceRepository;
//	@Autowired
//	private StudentRepository studentRepository;
//	@Autowired
//	private CourseRepository courseRepository;
//
//	public static void main(String[] args) {
//		SpringApplication.run(GeekbrainsSpringApplication.class, args);
//		
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("hello!");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("enter a name:");
//		String studentname = scanner.nextLine();
//		List<Course> studentCources = getStudentsCources(studentname);
//		System.out.println("Student with name " + studentname + " studies the following courses:");
//		for (Course course : studentCources) {
//			System.out.println(course.getName());
//		}
//		System.out.println("---------------");
//		
//		System.out.println("ender the course:");
//		String courceName = scanner.nextLine();
//		List<Student> students = getStudensFromCourse(courceName);
//		System.out.println("Course contains following students:");
//		for (Student student : students) {
//			System.out.println(student.getName());
//		}
//		System.out.println("-----------------");
//		System.out.println("enter studen and course name to show academic performance");
//		System.out.println("student name:");
//		String perfStud = scanner.nextLine();
//		System.out.println("course name:");
//		String perfCourse = scanner.nextLine();
//		AcademicPerformance academicPerformance = getAcademicPerformance(perfStud, perfCourse);
//		System.err.println("performance: " + academicPerformance.getScore());
//		System.out.println("lesson passed: " + academicPerformance.getLessonsCount() );
//		scanner.close();
//		
//		
//	}
//	
//	private List<Course> getStudentsCources(String name) {
//		Student student = studentRepository.findByName(name);
//		return student.getCourses();
//	}
//	
//	private List<Student> getStudensFromCourse(String name) {
//		Course course = courseRepository.findByName(name);
//		return course.getStudents();
//	}
//	
//	private AcademicPerformance getAcademicPerformance(String studentName, String courseName) {
//		Student student = studentRepository.findByName(studentName);
//		Course course = courseRepository.findByName(courseName);
//		AcademicPerformanceId academicPerformanceId = new AcademicPerformanceId(student, course);
//		return academicPerformanceRepository.findById(academicPerformanceId).get();
//	}
//
//}



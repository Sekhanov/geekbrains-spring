package com.skhanov.geekbrainsspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeekbrainsSpringApplication implements CommandLineRunner {	

	public static void main(String[] args) {
		SpringApplication.run(GeekbrainsSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello~!");		
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



package com.skhanov.geekbrainsspring;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder(10));
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("{noop}qwer")
//		.authorities("ROLE_USER")
//		.and()
//		.withUser("skhanov")
//		.password("{noop}asdf")
//		.authorities("ROLE_USER");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
//		.antMatchers("/", "/**").permitAll()
		.antMatchers("/student/add/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_MANAGER")
		.antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")	
		.antMatchers("/human/**").hasAnyAuthority("ROLE_ADMIN")	
		.and().httpBasic();
//		.and().formLogin().loginPage("/login").failureUrl("/accessDenied").loginProcessingUrl("/authenticateTheUser")		
//		.and().logout().logoutSuccessUrl("/").permitAll();
	}
	
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	

}

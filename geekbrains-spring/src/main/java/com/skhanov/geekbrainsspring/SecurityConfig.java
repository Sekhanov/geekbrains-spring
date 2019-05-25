package com.skhanov.geekbrainsspring;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
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
		.antMatchers("/", "/**").permitAll()
		.antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")		
		.and().formLogin().loginPage("/login").failureUrl("/accessDenied").loginProcessingUrl("/authenticateTheUser")		
		.and().logout().logoutSuccessUrl("/").permitAll();
	}
	
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//	

}

package com.skhanov.geekbrainsspring.domain.auth;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.skhanov.geekbrainsspring.validation.FieldMatch;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@FieldMatch(first = "password", second = "confirmPassword", message = "password not match")
public class Users {
	
	@Id
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	@Transient
	private String confirmPassword;
	
	private boolean enabled;
	
	@ManyToMany
	@JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "username"),
	inverseJoinColumns = @JoinColumn(name = "authority"))
	private Set<Role> roles;
	
	@Transient
	@NotBlank
	private String newRole;

}

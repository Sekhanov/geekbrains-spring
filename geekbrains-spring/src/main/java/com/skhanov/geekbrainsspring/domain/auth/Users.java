package com.skhanov.geekbrainsspring.domain.auth;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Users {
	
	@Id
	private String username;
	private String password;
	private boolean enabled;
	@ManyToMany
	@JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "username"),
	inverseJoinColumns = @JoinColumn(name = "authority"))
	private Set<Role> roles;

}

package com.skhanov.geekbrainsspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Human {

	public enum Gender {
		MALE, FAMALE
	}
	
	@NonNull
	private String name;
	@NonNull
	private Integer age;
	@NonNull
	private Gender gender;
	private Pet pet;
}

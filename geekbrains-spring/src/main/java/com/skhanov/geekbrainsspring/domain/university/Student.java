package com.skhanov.geekbrainsspring.domain.university;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Student {	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "student_course",
			joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "couce_id", referencedColumnName = "id")}
			)	
	private List<Course> courses;
	
	

}

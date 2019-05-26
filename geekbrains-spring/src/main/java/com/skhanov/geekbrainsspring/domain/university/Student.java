package com.skhanov.geekbrainsspring.domain.university;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.skhanov.geekbrainsspring.domain.auth.Users;

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
	
	@NonNull
	private String surname;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "student_course",
			joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "couce_id", referencedColumnName = "id")}
			)	
	private List<Course> courses;
	
	@ManyToOne
	@JoinColumn(name = "add_user_id")
	private Users addUser;
	
	//always user "Set" on unique value!
	@OneToMany(mappedBy = "ownerStudent", fetch = FetchType.EAGER)	
	private Set<Phone> phoneNumberList;
	
	@OneToMany(mappedBy = "ownerStudent", fetch = FetchType.EAGER)
	private Set<Email> emailList;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date addTime;
	
	@PrePersist
	private void timeStamp() {
		this.addTime = new Date();
	}
	
	
	
	

}

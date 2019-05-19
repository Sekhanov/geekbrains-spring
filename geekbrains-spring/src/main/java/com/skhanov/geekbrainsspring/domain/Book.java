package com.skhanov.geekbrainsspring.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;	
	private String description;	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	@Transient
	private int releaseYear;
	
	@PostLoad
	private void initReleaseYear() {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(releaseDate);
		releaseYear = calendar.get(Calendar.YEAR);
	}

	public Book(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int year) {
		Calendar calendar = new GregorianCalendar(year, 0, 1);
		this.releaseDate = calendar.getTime();
		
	}
	
	
	
	
}

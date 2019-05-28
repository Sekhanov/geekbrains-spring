package com.skhanov.geekbrainsspring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.skhanov.geekbrainsspring.domain.Human;
import com.skhanov.geekbrainsspring.domain.Human.Gender;
import com.skhanov.geekbrainsspring.domain.Pet;

@RestController
@RequestMapping("human")
@SessionScope
public class HumanRestController {
	
	private List<Human> humanList;
	
	@PostConstruct
	public void initModelParameters() {
		humanList = new ArrayList<>();
		humanList.add(new Human("Ivan", 20, Gender.MALE, new Pet("Cat", 4)));
		humanList.add(new Human("Sergey", 37, Gender.MALE, new Pet("Dog", 2)));
		humanList.add(new Human("Nastya", 30, Gender.FAMALE, new Pet("parrot", 3)));
		humanList.add(new Human("Irina", 20, Gender.FAMALE, new Pet("hamster", 1)));
		
	}	

	
	@GetMapping	
	public List<Human> getAllHumans() {
		return humanList;
	}
	
	@GetMapping("{humanAge}")
	public Human getHumanByAge(@PathVariable int humanAge) {
		for (Human human : humanList) {
			if(human.getAge() == humanAge) {
				return human;
			}			
		}
		return null;
	}	
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void addHuman(@RequestBody Human human) {
		humanList.add(human);
	}
	
	@DeleteMapping("{humanAge}")
	public void deleteHuman(@PathVariable int humanAge) {
		for (Human human : humanList) {
			if(human.getAge() == humanAge) {
				humanList.remove(human);
			}
		}
	}
	
	
	
//	@GetMapping
//	public String showHumanView() {
//		return "human";
//	}

}

package com.skhanov.geekbrainsspring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skhanov.geekbrainsspring.domain.Human;
import com.skhanov.geekbrainsspring.domain.Human.Gender;
import com.skhanov.geekbrainsspring.domain.Pet;

@Controller
@RequestMapping("human")
public class HumanController {
	
	@ModelAttribute
	public void initModelParameters(Model model) {
		List<Human> humans = new ArrayList<>();
		humans.add(new Human("Ivan", 20, Gender.MALE, new Pet("Cat", 4)));
		humans.add(new Human("Sergey", 37, Gender.MALE, new Pet("Dog", 2)));
		humans.add(new Human("Nastya", 30, Gender.FAMALE, new Pet("parrot", 3)));
		humans.add(new Human("Irina", 20, Gender.FAMALE, new Pet("hamster", 1)));
		model.addAttribute("humans", humans);
	}	
	
	@GetMapping
	public String showHumanView() {
		return "human";
	}
	
	@GetMapping("all")
	@ResponseBody
	public List<Human> getAllHumans(@ModelAttribute("humans") List<Human> humans) {
		return humans;
	}

}

package com.skhanov.geekbrainsspring.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("math")
public class MathCotroller {

	
	@PostMapping(path = "summ")
	public int getSumm(@RequestParam int a,  @RequestParam int b) {
		return a + b;
	}
}

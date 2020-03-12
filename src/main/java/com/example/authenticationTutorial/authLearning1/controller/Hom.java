package com.example.authenticationTutorial.authLearning1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Hom {
	
	@GetMapping("/")
	public String Home() {
		return "HI from home";
	}
	@GetMapping("/user")
	public String user() {
		return "HI from user";
	}
	@GetMapping("/admin")
	public String admin() {
		return "HI from Admin";
	}
}

package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
// @CrossOrigin("https://44.203.138.109:8080")
public class AttendenceController {


	@GetMapping()
	public String signup() { 
		return "sign Up done";
	}
	
}	
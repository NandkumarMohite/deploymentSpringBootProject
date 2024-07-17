package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/attendence")
public class AttendenceController {


	@GetMapping("/signin")
	public String signup(@PathVariable("id") int id) { 
		return "sign Up done";
	}
	
}	
package com.example.demo.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResp;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserDtoForAdmin;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/user")

// @CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	public UserService userservice;
	
	@Autowired
	public ModelMapper mapper;
	
	@PostMapping("/signup")
	public User Signup(@RequestBody @Valid UserDto userdto)

	{      
		userdto.setUserRole("User");
		User puser = userservice.addUser(userdto);	
		return  puser;		
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> signInEmployee(@RequestBody AuthRequest request) {
		System.out.println("auth req " + request);
	
			AuthResp resp = userservice.Signin(request);
			return ResponseEntity.ok(resp);			
	} 
		
		@GetMapping
		public List<UserDtoForAdmin> getAllUserForAdminPage(){
			 List<UserDtoForAdmin> original = userservice.getAllUser();
			 return original;
		}
	}


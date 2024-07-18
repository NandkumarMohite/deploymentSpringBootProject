package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResp;
import com.example.demo.dto.Converterdto;
import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserDtoForAdmin;
import com.example.demo.pojo.User;

import com.example.demo.custom_exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
	
@Service
@Transactional
public class UserService  {

	@Autowired
	public UserDao userdao;
	

	@Autowired
	public ModelMapper mapper;

	
	
	public User addUser(UserDto user) {

		Converterdto dto = new Converterdto();
		
		User u = dto.toUser(user);
		User u1 = userdao.save(u);
		return u1;
	}

	
	public AuthResp Signin(AuthRequest req) {
		User user = userdao.findByEmailAndPassword(req.getEmail(),req.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("invalid email or Password....!"));
		System.out.println(user);
		return mapper.map(user, AuthResp.class);
	}
	
	public List<UserDtoForAdmin> getAllUser(){
		List<User> original = userdao.findByUserRole("User");
		List<UserDtoForAdmin> list = new ArrayList<>();
		list = Arrays.asList(mapper.map(original, UserDtoForAdmin[].class));
		
		return list;
		
	}

	
	
	
}

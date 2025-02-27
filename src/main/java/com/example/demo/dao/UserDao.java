package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;

public interface UserDao extends JpaRepository<User, Long> {
 

	Optional<User> findByEmailAndPassword(String email, String password);	
	User findByEmail(String email);
	List<User> findByUserRole(String userRole);
	User findById(int id);

}
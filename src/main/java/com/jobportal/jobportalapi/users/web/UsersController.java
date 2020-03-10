package com.jobportal.jobportalapi.users.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.jobportalapi.users.data.UsersData;
import com.jobportal.jobportalapi.users.data.jpa.UserRepository;

@RestController
public class UsersController {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping("/users")
	public String test() {
		return "Inside users controller";
	}
	

	
	
	@PostMapping("/users")
	public ResponseEntity<?> newUser(@RequestBody UsersData user) {
		
		// UsersData user = new UsersData("Boss", "User");
		UsersData res = repository.save(user);
		
		return ResponseEntity.status(200).body(res);
		
		
		
		// return res;	
		
	}
}



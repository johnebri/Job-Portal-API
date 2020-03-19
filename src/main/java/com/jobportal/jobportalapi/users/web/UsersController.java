package com.jobportal.jobportalapi.users.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jobportal.jobportalapi.users.data.UsersData;
import com.jobportal.jobportalapi.users.data.jpa.UserRepository;

@RestController
public class UsersController {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping("/users")
	public List<UsersData> getallusers() {
		List<UsersData> res = (List<UsersData>) repository.findAll();
		return res;
	}	
	
	@PostMapping("/users")
	public ResponseEntity<?> newUser(@RequestBody UsersData user) {
		
		// UsersData user = new UsersData("Boss", "User");
		UsersData res = repository.save(user);
		
		return ResponseEntity.status(200).body(res);
		// return res;	
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
		return "";
	}
	
//	@PostMapping("/users2")
//	public ResponseEntity<Void> addQuestionToSurvey(@RequestBody UsersData user) {
//		
//		
////		if(question==null) {
////			return ResponseEntity.noContent().build();
////		}
//		UsersData res = repository.save(user);
//		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//		.path("/{id}").buildAndExpand(res.getId()).toUri();
//		return ResponseEntity.created(location).build();
//		
//	}
}



package com.jobportal.jobportalapi.users.data.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jobportal.jobportalapi.users.data.UsersData;

@Component
public class UserCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		repository.save(new UsersData("Sam", "Admin"));
		repository.save(new UsersData("Tom", "User"));
		repository.save(new UsersData("Bob", "User"));
		repository.save(new UsersData("Tam", "Admin"));
		
		for(UsersData user:repository.findAll()) {
			log.info(user.toString());
		}
		
	}
	
}

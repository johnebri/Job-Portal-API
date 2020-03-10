package com.jobportal.jobportalapi.users.data.jpa;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.jobportalapi.users.data.UsersData;

public interface UserRepository extends CrudRepository<UsersData, Long>{

}

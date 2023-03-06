package com.mohmmad.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohmmad.Entities.User;

public interface UserRepo extends JpaRepository<User, String> {  // here User is the entity class and type of it is String 

	
	// if you want  to implement any custom method or query;
	
}

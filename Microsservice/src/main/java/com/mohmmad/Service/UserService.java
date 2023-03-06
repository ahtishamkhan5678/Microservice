package com.mohmmad.Service;

import java.util.List;

import com.mohmmad.Entities.User;

public interface UserService {

	// create ----------------------->
	
	User saveUser(User user);
	
	
	
	// get all user------------------->
	
	List<User> getAllUser();
	
	
	
	
	
	//get single user of given userid;
	
	User getUser(String userId);
	
	
	
	
}

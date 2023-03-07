package com.mohmmad.Service;

import java.util.List;

import com.mohmmad.Entity.Hotel;

public interface HotelService {
	
	// create Hotel
	
	Hotel create (Hotel hotel);
	
	
	//get all Hotel
	
	
	List<Hotel> getAll();
	
	
	// get single
	
	Hotel get(String id);

}

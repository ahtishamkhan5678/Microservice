package com.mohmmad.Service;

import java.util.List;



import com.mohmmad.Entity.Rating;


public interface RatingService {
	
	
	// create 
	
	Rating create(Rating rating);
	
	
	
	
	//getAll by rating
	
	List<Rating> getRatings();
	
	
	
	
	
	//get all by userid
	
	List<Rating> getRatingByUserId(String userId);
	
	
	
	
	
	// get all by hotel
	
	List<Rating> getRatingHotelId(String hotelId);
	

}

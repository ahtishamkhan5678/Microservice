package com.mohmmad.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohmmad.Entity.Rating;
import com.mohmmad.Repo.RatingRepo;
import com.mohmmad.Service.RatingService;

@Service
public class RatingImpl implements RatingService {

	
	@Autowired
	private RatingRepo rRepo;
	
	
	
	@Override
	public Rating create(Rating rating) {
		
		return rRepo.save(rating);
	}
	
	
	
	

	@Override
	public List<Rating> getRatings() {
		
		return rRepo.findAll();
	}

	
	
	
	
	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return rRepo.findByUserId(userId);
	}

	
	
	
	
	
	@Override
	public List<Rating> getRatingHotelId(String hotelId) {
		return rRepo.findByHotelId(hotelId);
	}

}

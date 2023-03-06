package com.mohmmad.ExtenalService.Services;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.mohmmad.Entities.Rating;


@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	// get
	
	
	// post
	@PostMapping("/ratings")
	public ResponseEntity<Rating> createRating(Rating values);
	
	
	//put
	@PutMapping("/ratings/{ratingId}")
	public ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId,Rating rating);
	
	
	//delete
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);

}

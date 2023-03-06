package com.mohmmad;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.mohmmad.Entities.Rating;
import com.mohmmad.ExtenalService.Services.RatingService;

@SpringBootTest
class UserMicrosserviceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
//	@Test
//	void createRating() {
//		
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is crested by using feign client").build();
//	    ResponseEntity<Rating> ratingResponeEntity = ratingService.createRating(rating);
//	    
//	    System.out.println("new rating is created");
//	}

}

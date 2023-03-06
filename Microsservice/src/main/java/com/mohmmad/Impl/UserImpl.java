package com.mohmmad.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mohmmad.Entities.Hotel;
import com.mohmmad.Entities.Rating;
import com.mohmmad.Entities.User;
import com.mohmmad.Exception.ResourceNotFoundException;
import com.mohmmad.ExtenalService.Services.HotelSevice;
import com.mohmmad.Repo.UserRepo;
import com.mohmmad.Service.UserService;


@Service
public class UserImpl implements UserService {
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelSevice hotelService;
	
	
	
	private Logger logger = LoggerFactory.getLogger(UserImpl.class);

	@Override
	public User saveUser(User user) {
		
		// unique id ;
		
	    String  randomUserId = UUID.randomUUID().toString();
	    
	    user.setUserId(randomUserId);
		
		return userRepo.save(user);
	}

	
	
	@Override
	public List<User> getAllUser() {
	
		return userRepo.findAll();

	}

	@Override
	public User getUser(String userId) {

	User user =	 userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! "+userId));
    
	// fetch rating of the above user from Rating Service;
	//http://localhost:8083/ratings/users/16598c81-4d53-428b-8438-03ede00f101c
	
	Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),Rating[].class);
	logger.info("{}",ratingOfUser);
	
    List<Rating> ratings = Arrays.stream(ratingOfUser).toList();
	
	List<Rating> ratingList = ratings.stream().map(rating -> {
        // api call to hotel service to get hotel
	    // http://localhost:8082/hotels/e264b6ff-1c17-4b1a-a7b9-53d37def581c
		
	//	ResponseEntity<Hotel> forEntity =	restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
	    Hotel hotel =	hotelService.getHotel(rating.getHotelId());
	   // logger.info("Respone Status Code :{}",forEntity.getStatusCode());
	    
	    
		// set the hotel to rating
	         rating.setHotel(hotel);
	         return rating;
    }).collect(Collectors.toList());


	user.setRatings(ratingList);
	return user;
	}
	
	

}

package com.mohmmad.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.mohmmad.Entity.Rating;
import com.mohmmad.Service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService rService;
	
	
	// create rating api below here!
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(rService.create(rating));
		
	}
	
	// getAll
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(rService.getRatings());
	}
	
	
	//by userid
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(rService.getRatingByUserId(userId));
	}

	//by hotelid
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(rService.getRatingHotelId(hotelId));
	}
}

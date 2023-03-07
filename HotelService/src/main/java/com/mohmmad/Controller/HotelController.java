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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohmmad.Entity.Hotel;
import com.mohmmad.Service.HotelService;

@RestController
@RequestMapping("/hotels") // url for hotel given here!
public class HotelController {
	
	 @Autowired
	    private HotelService hotelService;

	    //create

	    @PreAuthorize("hasAuthority('Admin')")
	    @PostMapping
	    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
	        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	    }


	    //get single
	    
	    @PreAuthorize("hasAuthority('SCOPE_internal')")
	    @GetMapping("/{hotelId}")
	    public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId) {
	        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
	    }


	    //get all
	    
	    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	    @GetMapping
	    public ResponseEntity<List<Hotel>> getAll(){
	        return ResponseEntity.ok(hotelService.getAll());
	    }
	
	

}

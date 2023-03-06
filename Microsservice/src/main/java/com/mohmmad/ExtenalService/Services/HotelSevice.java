package com.mohmmad.ExtenalService.Services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mohmmad.Entities.Hotel;



@FeignClient(name = "HOTEL-SERVICE")
public interface HotelSevice {
	
	// making method below of hotel
	
     @GetMapping("/hotels/{hotelId}")	
	 Hotel getHotel(@PathVariable("hotelId")  String hotelId);
	

}

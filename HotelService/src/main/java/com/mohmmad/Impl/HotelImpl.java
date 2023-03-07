package com.mohmmad.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohmmad.Entity.Hotel;
import com.mohmmad.Exception.ResourceNotFoundException;
import com.mohmmad.Repo.HotelRepo;
import com.mohmmad.Service.HotelService;


@Service
public class HotelImpl implements HotelService {
	
	
	@Autowired
	private HotelRepo hotelRepo;
	
	

	@Override
	public Hotel create(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		
		return hotelRepo.save(hotel);
	}
	
	
	

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepo.findAll();
	}
	
	
	

	@Override
	public Hotel get(String id) {
		
		return hotelRepo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Hotel with given id is not found on server !! "));
	}

}

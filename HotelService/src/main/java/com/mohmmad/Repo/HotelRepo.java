package com.mohmmad.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohmmad.Entity.Hotel;

public interface HotelRepo extends  JpaRepository<Hotel,String>{

}

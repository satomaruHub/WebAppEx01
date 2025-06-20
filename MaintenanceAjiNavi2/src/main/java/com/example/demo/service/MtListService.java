package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.MtRestaurant;

public interface MtListService {

	List<MtRestaurant> findByNameWildcard(String restaurantName);
	
}

package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.MtRestaurant;
import com.example.demo.repository.MtRestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MtListServiceImpl implements MtListService {

	private final MtRestaurantRepository repository;

	@Override
	public List<MtRestaurant> findByNameWildcard(String restaurantName) {

		List<MtRestaurant> list 
			= repository.selectByNameWildcard(restaurantName);
	
		return list;
	}

}

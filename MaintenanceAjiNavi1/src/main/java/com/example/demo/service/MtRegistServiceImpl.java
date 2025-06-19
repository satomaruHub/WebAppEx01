package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.MtRestaurant;
import com.example.demo.repository.MtRestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MtRegistServiceImpl implements MtRegistService {

	private final MtRestaurantRepository repository;
	
	@Override
	public void regist(MtRestaurant r) {

		repository.add(r);
		
	}

}

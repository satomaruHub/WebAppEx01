package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.MtRestaurant;

public interface MtRestaurantRepository {

	void add(MtRestaurant r);

	List<MtRestaurant> selectByNameWildcard(String restaurantName);

	void update(MtRestaurant r);

	void delete(MtRestaurant r);

}

package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MtRestaurant;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MtRestaurantRepositoryImpl implements MtRestaurantRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(MtRestaurant r) {

		String sql =
				" INSERT INTO m_restaurant " +
				" (restaurant_name, catch_phrase) " +
				" VALUES (?, ?) ";	

		jdbcTemplate.update(sql, 
				r.getRestaurantName(),
				r.getCatchPhrase()			);
		
	}

}

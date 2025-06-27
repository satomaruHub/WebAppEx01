package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Review;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(Review review) {

		String sql =
			" INSERT INTO t_review " +
			" (restaurant_id, user_id, visit_date, rating, comment) " +
			" VALUES (?, ?, ?, ?, ?) ";	

		jdbcTemplate.update(sql, review.getRestaurantId(),
								 review.getUserId(),
								 review.getVisitDate(),
								 review.getRating(),
								 review.getComment()		);
		
	}

}

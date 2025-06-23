package com.example.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Study;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegistRepositoryImpl implements RegistRepository {
	
	private final JdbcTemplate jdbcTemplate;

	@Override
	public void add(Study study) {
		
		System.out.println("-----------");
		System.out.println(study);

	}

}

package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Study;
import com.example.demo.repository.RegistRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {
	
	private final RegistRepository repository;

	@Override
	public void regist(Study study) {
		
		repository.add(study);
		
	}

}

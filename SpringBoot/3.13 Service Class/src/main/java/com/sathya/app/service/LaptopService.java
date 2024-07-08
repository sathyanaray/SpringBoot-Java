package com.sathya.app.service;

import com.sathya.app.repo.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.app.model.Laptop;

@Service
public class LaptopService {
	@Autowired
	private LaptopRepository repo;

	public void add(Laptop lap) {
		repo.save(lap);
		
	}

	public boolean isGoodForProg(Laptop lap) {
		return true;
	}
	
}

package com.example.unesso.services.db;

import com.example.unesso.repository.CatRegionRepository;
import com.example.unesso.services.ICatRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatRegionServiceJPA implements ICatRegionService {
	@Autowired
	private CatRegionRepository catRegionRepo;

}

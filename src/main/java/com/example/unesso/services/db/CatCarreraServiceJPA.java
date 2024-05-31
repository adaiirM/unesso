package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatCarreraRepository;
import com.example.unesso.services.CatCarreraService;

@Service
@Primary
public class CatCarreraServiceJPA implements CatCarreraService {
	@Autowired
	private CatCarreraRepository catCarreraRepo;
	
}

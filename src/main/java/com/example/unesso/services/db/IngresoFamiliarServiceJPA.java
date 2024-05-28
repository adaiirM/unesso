package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.IngresoFamiliarRepository;
import com.example.unesso.services.IngresoFamiliarService;

@Service
@Primary
public class IngresoFamiliarServiceJPA implements IngresoFamiliarService {
	@Autowired
	private IngresoFamiliarRepository ingresoFamiliarRepo;
	
}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.services.CatEscolaridadService;

@Service
@Primary
public class CatEscolaridadServiceJPA implements CatEscolaridadService{
	@Autowired
	private CatEscolaridadRepository catEscolaridadRepo;
	
}

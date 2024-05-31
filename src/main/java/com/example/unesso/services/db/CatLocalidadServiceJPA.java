package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatLocalidadRepository;
import com.example.unesso.services.CatLocalidadService;

@Service
@Primary
public class CatLocalidadServiceJPA implements CatLocalidadService{
	@Autowired
	private CatLocalidadRepository catLocalidadRepo;
	
}

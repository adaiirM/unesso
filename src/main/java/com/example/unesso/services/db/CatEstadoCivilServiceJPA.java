package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.CatEstadoCivilRepository;
import com.example.unesso.services.CatEstadoCivilService;

@Service
@Primary
public class CatEstadoCivilServiceJPA implements CatEstadoCivilService{
	@Autowired
	private CatEstadoCivilRepository catEstadoCivilRepo;
	
}

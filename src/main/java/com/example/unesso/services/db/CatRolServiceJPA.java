package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.CatRolRepository;
import com.example.unesso.services.ICatRolService;

@Service
@Primary
public class CatRolServiceJPA implements ICatRolService {
	@Autowired
	private CatRolRepository catRolRepo;
	
}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatMaterialViviendaRepository;
import com.example.unesso.services.CatMaterialViviendaService;

@Service
@Primary
public class CatMaterialViviendaServiceJPA implements CatMaterialViviendaService {
	@Autowired
	private CatMaterialViviendaRepository catMaterialViviendaRepo;
	
}

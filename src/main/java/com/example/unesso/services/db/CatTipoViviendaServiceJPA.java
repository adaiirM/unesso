package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatTipoViviendaRepository;
import com.example.unesso.services.CatTipoViviendaService;

@Service
@Primary
public class CatTipoViviendaServiceJPA implements  CatTipoViviendaService {
	@Autowired
	private CatTipoViviendaRepository catTipoViviendaRepo;
}

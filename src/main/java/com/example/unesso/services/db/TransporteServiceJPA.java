package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.TransporteRepository;
import com.example.unesso.services.TransporteService;

@Service
@Primary
public class TransporteServiceJPA implements TransporteService {
	@Autowired
	private TransporteRepository transporteRepo;
	
	
}

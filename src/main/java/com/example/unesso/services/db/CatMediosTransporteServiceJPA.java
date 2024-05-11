package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatMediosTransporteRepository;
import com.example.unesso.services.CatMediosTransporteService;

@Service
@Primary
public class CatMediosTransporteServiceJPA implements CatMediosTransporteService {
	@Autowired
	private CatMediosTransporteRepository catMediosTransporteRepo;

}

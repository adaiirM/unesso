package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatTipoTransporteRepository;
import com.example.unesso.services.CatTipoTransporteService;

@Service
@Primary
public class CatTipoTransporteServiceJPA implements CatTipoTransporteService {
	@Autowired
	private CatTipoTransporteRepository catTipoTransporteRepo;
}

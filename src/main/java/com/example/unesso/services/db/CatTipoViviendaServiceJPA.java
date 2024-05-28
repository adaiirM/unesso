package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatTipoVivienda;
import com.example.unesso.repository.CatTipoViviendaRepository;
import com.example.unesso.services.ICatTipoViviendaService;

@Service
@Primary
public class CatTipoViviendaServiceJPA implements  ICatTipoViviendaService {
	@Autowired
	private CatTipoViviendaRepository catTipoViviendaRepo;

	@Override
	public List<CatTipoVivienda> listarTipoVivienda() {
		return catTipoViviendaRepo.findAll();
	}
}

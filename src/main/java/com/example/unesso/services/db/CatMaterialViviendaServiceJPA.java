package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatMaterialVivienda;
import com.example.unesso.repository.CatMaterialViviendaRepository;
import com.example.unesso.services.ICatMaterialViviendaService;

@Service
@Primary
public class CatMaterialViviendaServiceJPA implements ICatMaterialViviendaService {
	@Autowired
	private CatMaterialViviendaRepository catMaterialViviendaRepo;

	@Override
	public List<CatMaterialVivienda> listarMaterialVivienda() {
		return catMaterialViviendaRepo.findAll();
	}
	
}

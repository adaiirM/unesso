package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatSituacionVivienda;
import com.example.unesso.repository.CatSituacionViviendaRepository;
import com.example.unesso.services.ICatSituacionViviendaService;

@Service
@Primary
public class CatSituacionViviendaServiceJPA implements ICatSituacionViviendaService {
	@Autowired
	private CatSituacionViviendaRepository catSituacionViviendaRepo;

	@Override
	public List<CatSituacionVivienda> buscarTodas() {
		return catSituacionViviendaRepo.findAll();
	}

}

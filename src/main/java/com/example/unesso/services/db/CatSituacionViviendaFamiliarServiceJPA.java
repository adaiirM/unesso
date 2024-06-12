package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatSituacionViviendaFamiliar;
import com.example.unesso.repository.CatSituacionViviendaFamiliarRepository;
import com.example.unesso.services.ICatSituacionViviendaFamiliarService;

@Service
@Primary
public class CatSituacionViviendaFamiliarServiceJPA implements ICatSituacionViviendaFamiliarService {
	@Autowired
	private CatSituacionViviendaFamiliarRepository catSituacionViviendaFamiliarRepo;

	@Override
	public List<CatSituacionViviendaFamiliar> buscarTodas() {
		return catSituacionViviendaFamiliarRepo.findAll();
	}
}

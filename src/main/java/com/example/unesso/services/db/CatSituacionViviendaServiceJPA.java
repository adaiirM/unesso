package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatSituacionViviendaRepository;
import com.example.unesso.services.CatSituacionViviendaService;

@Service
@Primary
public class CatSituacionViviendaServiceJPA implements CatSituacionViviendaService {
	@Autowired
	private CatSituacionViviendaRepository catSituacionViviendaRepo;

}

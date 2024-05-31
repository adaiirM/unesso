package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatSituacionViviendaFamiliarRepository;
import com.example.unesso.services.CatSituacionViviendaFamiliarService;

@Service
@Primary
public class CatSituacionViviendaFamiliarServiceJPA implements CatSituacionViviendaFamiliarService {
	@Autowired
	private CatSituacionViviendaFamiliarRepository catSituacionViviendaFamiliarRepo;
}

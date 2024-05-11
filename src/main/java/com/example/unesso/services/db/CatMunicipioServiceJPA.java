package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatMunicipioRepository;
import com.example.unesso.services.CatMunicipioService;

@Service
@Primary
public class CatMunicipioServiceJPA implements CatMunicipioService {
	@Autowired
	private CatMunicipioRepository catMunicipioRepo;
}

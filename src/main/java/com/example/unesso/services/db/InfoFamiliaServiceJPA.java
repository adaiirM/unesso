package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.unesso.repository.InfoFamiliaRepository;
import com.example.unesso.services.InfoFamiliaService;

public class InfoFamiliaServiceJPA implements InfoFamiliaService {
	@Autowired
	private InfoFamiliaRepository infoFamiliaRepo;
}

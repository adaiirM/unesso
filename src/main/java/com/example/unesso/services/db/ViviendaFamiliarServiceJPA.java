package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.ViviendaFamiliarRepository;
import com.example.unesso.services.ViviendaFamiliarService;

@Service
@Primary
public class ViviendaFamiliarServiceJPA implements ViviendaFamiliarService {
	@Autowired
	private ViviendaFamiliarRepository viviendaFamiliarRepo;
}

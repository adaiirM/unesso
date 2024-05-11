package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.MediosTrasladoRepository;
import com.example.unesso.services.MediosTrasladoService;

@Service
@Primary
public class MediosTrasladoServiceJPA implements MediosTrasladoService{
	@Autowired
	private MediosTrasladoRepository mediosTrasladoRepo;
	
}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Domicilio;
import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.DomicilioRepository;
import com.example.unesso.services.IDomicilioService;

@Service
@Primary
public class DomicilioServiceJPA implements IDomicilioService {
	@Autowired
	private DomicilioRepository domicilioRepo;

	@Override
	public Domicilio guardar(Domicilio domicilio) {
		return domicilioRepo.save(domicilio);
	}
}

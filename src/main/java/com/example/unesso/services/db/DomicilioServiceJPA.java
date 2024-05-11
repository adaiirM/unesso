package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.DomicilioRepository;
import com.example.unesso.services.DomicilioService;

@Service
@Primary
public class DomicilioServiceJPA implements DomicilioService {
	@Autowired
	private DomicilioRepository domicilioRepo;
}

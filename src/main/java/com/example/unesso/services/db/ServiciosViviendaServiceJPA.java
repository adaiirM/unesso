package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.ServiciosViviendaRepository;
import com.example.unesso.services.ServiciosViviendaService;

@Service
@Primary
public class ServiciosViviendaServiceJPA implements ServiciosViviendaService {
	@Autowired
	private ServiciosViviendaRepository serviciosViviendaRepo;
}

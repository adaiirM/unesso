package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.ViviendaFamiliar;
import com.example.unesso.repository.ViviendaFamiliarRepository;
import com.example.unesso.services.IViviendaFamiliarService;

@Service
@Primary
public class ViviendaFamiliarServiceJPA implements IViviendaFamiliarService {
	@Autowired
	private ViviendaFamiliarRepository viviendaFamiliarRepo;

	@Override
	public ViviendaFamiliar guardar(ViviendaFamiliar viviendaFamiliar) {
		return viviendaFamiliarRepo.save(viviendaFamiliar);
	}
}

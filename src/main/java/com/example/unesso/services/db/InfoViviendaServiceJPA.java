package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.InfoVivienda;
import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.InfoViviendaRepository;
import com.example.unesso.services.IInfoViviendaService;

@Service
@Primary
public class InfoViviendaServiceJPA implements IInfoViviendaService {
	@Autowired
	private InfoViviendaRepository infoViviendaRepo;

	@Override
	public InfoVivienda guardar(InfoVivienda infoVivienda) {
		return infoViviendaRepo.save(infoVivienda);
	}
}

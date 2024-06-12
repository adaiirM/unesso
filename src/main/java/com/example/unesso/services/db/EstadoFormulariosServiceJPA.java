package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.EstadoFormularios;
import com.example.unesso.repository.EstadoFormulariosRepository;
import com.example.unesso.services.IEstadoFormulariosService;

@Service
@Primary
public class EstadoFormulariosServiceJPA implements IEstadoFormulariosService{
	
	@Autowired
	private EstadoFormulariosRepository estadoFormulariosRepo;
	
	@Override
	public EstadoFormularios guardarEstadoFormularios(EstadoFormularios estadoFormularios) {
		return estadoFormulariosRepo.save(estadoFormularios);
	}
	
}

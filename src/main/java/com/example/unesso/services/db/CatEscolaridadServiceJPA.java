package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatEscolaridad;
import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.services.ICatEscolaridadService;

@Service
@Primary
public class CatEscolaridadServiceJPA implements ICatEscolaridadService{
	@Autowired
	private CatEscolaridadRepository catEscolaridadRepo;

	@Override
	public List<CatEscolaridad> listarEscolaridades() {
		return catEscolaridadRepo.findAll();
	}
	@Override
	public List<CatEscolaridad> buscarTodas() {
		return catEscolaridadRepo.findAll();
	}
}

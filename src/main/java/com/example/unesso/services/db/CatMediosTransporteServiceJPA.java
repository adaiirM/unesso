package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatMediosTransporte;
import com.example.unesso.repository.CatMediosTransporteRepository;
import com.example.unesso.services.ICatMediosTransporteService;

@Service
@Primary
public class CatMediosTransporteServiceJPA implements ICatMediosTransporteService {
	@Autowired
	private CatMediosTransporteRepository catMediosTransporteRepo;
	/**
     * Obtiene la lista de todos los medios de transporte de la base de datos;
     * @return  List<CatMediosTransporte> lista de todos los medios de transporte.
     */
	@Override
	public List<CatMediosTransporte> buscarTodos() {
		return catMediosTransporteRepo.findAll();
	}
}

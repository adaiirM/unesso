package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCarrera;
import com.example.unesso.repository.CatCarreraRepository;
import com.example.unesso.services.ICatCarreraService;

@Service
@Primary
public class CatCarreraServiceJPA implements ICatCarreraService {
	@Autowired
	private CatCarreraRepository catCarreraRepo;
	/**
     * Obtiene todas las carreras de la base de datos.
     * @return List<CatCarrera> lista de carreras. 
     */
	@Override
	public List<CatCarrera> buscarTodas() {
		return catCarreraRepo.findAll();
	}

	public CatCarrera save(CatCarrera catCarrera) {
		return catCarreraRepo.save(catCarrera);
	}
}

package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatOcupacion;
import com.example.unesso.repository.CatOcupacionRepository;
import com.example.unesso.services.ICatOcupacionService;

@Service
@Primary
public class CatOcupacionServiceJPA implements ICatOcupacionService{
	@Autowired
	private CatOcupacionRepository catOcupacionRepo;

	@Override
	public List<CatOcupacion> listaOcupaciones() {
		return catOcupacionRepo.findAll();
	}

	/**
	 * Recupera los registro de la tabla catOcupacion de la BD
	 * @return List<CatOcupacion> con los registros ó null en caso de encontrar nada
	 */
	@Override
	public List<CatOcupacion> buscarTodas() {
		return catOcupacionRepo.findAll();
	}
}

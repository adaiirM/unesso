package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatEstadoCivil;
import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.CatEstadoCivilRepository;
import com.example.unesso.services.ICatEstadoCivilService;


/**
 * Clase de servicio para operaciones relacionadas con CatEstadocivil.
 */
@Service
@Primary
public class CatEstadoCivilServiceJPA implements ICatEstadoCivilService{
	@Autowired
	private CatEstadoCivilRepository catEstadoCivilRepo;

	/**
     * Obtiene todos los estados civiles de la base de datos
     * @return List<CatEstadoCivil> con todos los estados civiles registrados en la base de datos.
     */
	@Override
	public List<CatEstadoCivil> buscarTodos() {
		return catEstadoCivilRepo.findAll();
	}
	
}

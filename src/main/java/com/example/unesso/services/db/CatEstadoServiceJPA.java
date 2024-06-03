package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatEstado;
import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.CatEstadoRepository;
import com.example.unesso.services.ICatEstadoService;


/**
 * Clase de servicio para operaciones relacionadas con CatEstado.
 */
@Service
@Primary
public class CatEstadoServiceJPA implements ICatEstadoService{
	@Autowired
	private CatEstadoRepository catEstadoRepo;

	/**
     * Obtiene todos los estados de la base de datos
     * @return List<CatEstado> lista con todos los estados encontrados.
     */
	@Override
	public List<CatEstado> buscarTodos() {
		return catEstadoRepo.findAll();
	}


}

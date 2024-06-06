package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatTipoTransporte;
import com.example.unesso.repository.CatTipoTransporteRepository;
import com.example.unesso.services.ICatTipoTransporteService;

/**
 * Clase de servicio para operaciones relacionadas con catTipoTransporte.
 * Implementa los metodos de consulta a la Base de Datos
 */
@Service
@Primary
public class CatTipoTransporteServiceJPA implements ICatTipoTransporteService {
	@Autowired
	private CatTipoTransporteRepository catTipoTransporteRepo;

	
	/**
     * Obtiene la lista de los registros de la tabla catTipoTransporte de la base de datos.
     * @return List<CatTipoTransporte> con los registros encontrados ó null en caso de no encontrar registros. 
     */
	@Override
	public List<CatTipoTransporte> buscarTodos() {
		return catTipoTransporteRepo.findAll();
	}
}

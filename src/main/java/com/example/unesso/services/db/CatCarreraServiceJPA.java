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

	/**
	 * Busca una carrera por su idCatCarrera en la base de datos.
	 *
	 * @param idCatCarrera El ID de la carrera a buscar.
	 * @return Optional<CatCarrera> La carrera encontrada, o vacío si no existe.
	 */
	@Override
	public CatCarrera findByIdCatCarrera(Integer idCatCarrera) {
		return catCarreraRepo.findById(idCatCarrera).orElse(null);
	}

	@Override
	public CatCarrera findByNombreCarrera(String carrera) {
		return catCarreraRepo.findByCarrera(carrera);
	}

	@Override
	public CatCarrera findById(Integer id) {
		return catCarreraRepo.findById(id).orElse(null);
	}



}

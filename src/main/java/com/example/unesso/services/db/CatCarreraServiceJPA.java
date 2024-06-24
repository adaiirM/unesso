package com.example.unesso.services.db;

import java.util.ArrayList;
import java.util.List;

import com.example.unesso.model.FechasRegistradas;
import com.example.unesso.services.FechasRegistradasService;
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

	@Autowired
	private FechasRegistradasServiceJPA fechasRegistradasService;
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


	@Override
	public List<CatCarrera> buscarCarrerasSinFecha() {
		List<CatCarrera> carrerasSinFecha = new ArrayList<>();

		// Obtener todas las carreras
		List<CatCarrera> todasLasCarreras = catCarreraRepo.findAll();

		// Obtener todas las fechas registradas (opcional dependiendo de tu lógica)
		List<FechasRegistradas> fechasRegistradas = fechasRegistradasService.findAll();

		// Iterar sobre todas las carreras y verificar si tienen fechas asignadas
		for (CatCarrera carrera : todasLasCarreras) {
			boolean tieneFechaAsignada = false;

			// Verificar si la carrera tiene alguna fecha asignada
			for (FechasRegistradas fecha : fechasRegistradas) {
				if (fecha.getCarrera().equals(carrera)) {
					tieneFechaAsignada = true;
					break;
				}
			}

			// Si no tiene fecha asignada, agregar a la lista de carreras sin fecha
			if (!tieneFechaAsignada) {
				carrerasSinFecha.add(carrera);
			}
		}

		return carrerasSinFecha;
	}
}

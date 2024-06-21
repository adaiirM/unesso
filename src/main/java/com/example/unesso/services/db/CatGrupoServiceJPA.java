package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCarrera;
import com.example.unesso.model.CatGrupo;
import com.example.unesso.model.CatSemestre;
import com.example.unesso.repository.CatGrupoRepository;
import com.example.unesso.services.ICatGrupoService;

@Service
@Primary
public class CatGrupoServiceJPA implements ICatGrupoService {
	@Autowired
	private CatGrupoRepository catGrupoRepo;

	@Override
	public CatGrupo grupoPorIdCatCarreraAndIdCatSemestre(Integer idCatCarrera, Integer idCatSemestre) {
		return catGrupoRepo.findByCarreraAndSemestre(idCatCarrera, idCatSemestre);
	}

	@Override
	public CatCarrera carreraPorGrupo(Integer idCatGrupo) {
		return catGrupoRepo.findCarreraByIdCatGrupo(idCatGrupo);
	}

	@Override
	public CatSemestre carSemestrePorGrupo(Integer idGrupo) {
		return catGrupoRepo.findSemestreByIdCatGrupo(idGrupo);
	}

	@Override
	public CatGrupo findByNombreGrupo(String nombreGrupo) {
		return catGrupoRepo.findByNombreGrupo(nombreGrupo);
	}


}

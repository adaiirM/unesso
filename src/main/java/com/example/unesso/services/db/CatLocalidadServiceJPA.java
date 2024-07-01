package com.example.unesso.services.db;

import java.util.List;
import java.util.Optional;

import com.example.unesso.model.CatDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.CatMunicipio;
import com.example.unesso.repository.CatLocalidadRepository;
import com.example.unesso.services.ICatLocalidadService;

@Service
@Primary
public class CatLocalidadServiceJPA implements ICatLocalidadService{
	@Autowired
	private CatLocalidadRepository catLocalidadRepo;


	@Override
	public List<CatLocalidad> listaLocalidadesPorMunicipio(CatMunicipio municipio) {
		return catLocalidadRepo.findByCatMunicipio(municipio);
	}


	@Override
	public CatLocalidad buscarPorId(Integer id) {
		Optional<CatLocalidad> op = catLocalidadRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
	@Override
	public List<CatLocalidad> localidadesPorIdCatMunicipio(Integer idCatMunicipio) {
		return catLocalidadRepo.findLocalidadesByCatMunicipio_IdCatMunicipio(idCatMunicipio);
	}

	@Override
	public CatMunicipio municipioPorIdCatLocalidad(Integer idCatLocalidad) {
		return catLocalidadRepo.municipioPorLocalidad(idCatLocalidad);
	}


}

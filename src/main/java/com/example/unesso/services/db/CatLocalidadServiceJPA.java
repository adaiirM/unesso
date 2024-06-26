package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCodigoPostal;
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
	public List<CatLocalidad> localidadesPorIdCatMunicipio(Integer idCatMunicipio) {
		return catLocalidadRepo.findLocalidadesByCatMunicipio_IdCatMunicipio(idCatMunicipio);
	}

	@Override
	public CatMunicipio municipioPorIdCatLocalidad(Integer idCatLocalidad) {
		return catLocalidadRepo.municipioPorLocalidad(idCatLocalidad);
	}

	/*
	@Override
	public CatCodigoPostal cpPorLocalidad(Integer idCatLocalidad) {
		return catLocalidadRepo.codigoPostalPorIdCatLocalidad(idCatLocalidad);
	}
	*/
	
}

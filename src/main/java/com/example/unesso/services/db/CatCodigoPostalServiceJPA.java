package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.repository.CatCodigoPostalRepository;
import com.example.unesso.services.ICatCodigoPostalService;


@Service
@Primary
public class CatCodigoPostalServiceJPA implements ICatCodigoPostalService{
	@Autowired
	private CatCodigoPostalRepository catCodigoPostalRepo;

	@Override
	public CatCodigoPostal cpPorLocalidad(Integer idCatLocalidad) {
		return catCodigoPostalRepo.codigoPostalPorIdCatLocalidad(idCatLocalidad);
	}

	
	
}

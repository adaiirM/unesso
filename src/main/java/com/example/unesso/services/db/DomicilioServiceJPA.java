package com.example.unesso.services.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.Domicilio;
import com.example.unesso.repository.DomicilioRepository;
import com.example.unesso.services.IDomicilioService;

@Service
@Primary
public class DomicilioServiceJPA implements IDomicilioService {
	@Autowired
	private DomicilioRepository domicilioRepo;

	@Override
	public Domicilio guardarDomicilio(Domicilio domicilio) {
		return domicilioRepo.save(domicilio);
	}

	@Override
	public CatCodigoPostal buscarPorLocalidad(CatLocalidad catLocalidad) {
		Optional<CatCodigoPostal> op = domicilioRepo.findByCatLocalidad(catLocalidad);
		System.out.println(op);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
}

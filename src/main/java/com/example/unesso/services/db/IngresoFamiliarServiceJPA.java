package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Familia;
import com.example.unesso.model.IngresoFamiliar;
import com.example.unesso.repository.IngresoFamiliarRepository;
import com.example.unesso.services.IFamiliaService;
import com.example.unesso.services.IIngresoFamiliarService;

@Service
@Primary
public class IngresoFamiliarServiceJPA implements IIngresoFamiliarService {
	@Autowired
	private IngresoFamiliarRepository ingresoFamiliarRepo;

	@Override
	public void eliminar(Integer idIngresoFamiliar) {
		ingresoFamiliarRepo.deleteById(idIngresoFamiliar);	
	}
}

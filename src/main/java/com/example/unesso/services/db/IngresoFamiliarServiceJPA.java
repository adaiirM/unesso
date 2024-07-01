package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.unesso.repository.IngresoFamiliarRepository;
import com.example.unesso.services.IIngresoFamiliarService;

@Service
@Primary
public class IngresoFamiliarServiceJPA implements IIngresoFamiliarService {
	@Autowired
	private IngresoFamiliarRepository ingresoFamiliarRepo;

	@Override
	@Transactional
	public void eliminarIngresosFamiliares(List<Integer> idsIngresosFamiliar) {
		ingresoFamiliarRepo.deleteAllById(idsIngresosFamiliar);	
	}
}

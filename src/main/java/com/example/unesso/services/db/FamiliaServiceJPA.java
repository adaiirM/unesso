package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Familia;
import com.example.unesso.repository.FamiliaRepository;
import com.example.unesso.services.IFamiliaService;

@Service
@Primary
public class FamiliaServiceJPA implements IFamiliaService {
	@Autowired
	private FamiliaRepository familiaRepo;

	@Override
	public Familia guardar(Familia familia) {
		return familiaRepo.save(familia);
	}

}

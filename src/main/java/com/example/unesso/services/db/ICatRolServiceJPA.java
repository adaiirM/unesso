package com.example.unesso.services.db;

import com.example.unesso.model.CatRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatRolRepository;
import com.example.unesso.services.ICatRolService;

@Service
@Primary
public class ICatRolServiceJPA implements ICatRolService {
	@Autowired
	private CatRolRepository catRolRepo;

	@Override
	public CatRol findByIdRol(Integer id) {
		return catRolRepo.findByIdCatRol(id);
	}
}

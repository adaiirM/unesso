package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatParentesco;
import com.example.unesso.repository.CatParentescoRepository;
import com.example.unesso.services.ICatParentescoService;

@Service
@Primary
public class CatParentescoServiceJPA implements ICatParentescoService {
	@Autowired
	private CatParentescoRepository catParentescoRepo;

	@Override
	public List<CatParentesco> listarParentescos() {
		return catParentescoRepo.findAll();
	}
}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatParentescoRepository;
import com.example.unesso.services.CatParentescoService;

@Service
@Primary
public class CatParentescoServiceJPA implements CatParentescoService {
	@Autowired
	private CatParentescoRepository catParentescoRepo;
}

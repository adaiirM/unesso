package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatGrupoRepository;
import com.example.unesso.services.CatGrupoService;

@Service
@Primary
public class CatGrupoServiceJPA implements CatGrupoService {
	@Autowired
	private CatGrupoRepository catGrupoRepo;	

}

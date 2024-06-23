package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatSituacionTrabajoRepository;
import com.example.unesso.services.CatSituacionTrabajoService;

@Service
@Primary
public class CatSituacionTrabajoServiceJPA implements CatSituacionTrabajoService {
	@Autowired
	private CatSituacionTrabajoRepository catSituacionTrabajoRepo;
}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatSemestreRepository;
import com.example.unesso.services.CatSemestreService;

@Service
@Primary
public class CatSemestreServiceJPA implements CatSemestreService {
	@Autowired
	private CatSemestreRepository catSemestreRepo;

}

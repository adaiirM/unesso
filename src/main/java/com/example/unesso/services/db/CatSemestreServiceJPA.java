package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatSemestre;
import com.example.unesso.repository.CatSemestreRepository;
import com.example.unesso.services.ICatSemestreService;

@Service
@Primary
public class CatSemestreServiceJPA implements ICatSemestreService {
	@Autowired
	private CatSemestreRepository catSemestreRepo;

	@Override
	public List<CatSemestre> buscarTodos() {
		return catSemestreRepo.findAll();
	}

}

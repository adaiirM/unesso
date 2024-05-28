package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatInternet;
import com.example.unesso.repository.CatInternetRepository;
import com.example.unesso.services.CatInternetService;

@Service
@Primary
public class CatInternetServiceJPA implements CatInternetService {
	@Autowired
	private CatInternetRepository catInternetRepo;

	@Override
	public List<CatInternet> buscarTodos() {
		return catInternetRepo.findAll();
	}

}

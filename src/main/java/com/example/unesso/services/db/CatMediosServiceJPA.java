package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatMedios;
import com.example.unesso.repository.CatMediosRepository;
import com.example.unesso.services.ICatMediosService;

@Service
@Primary
public class CatMediosServiceJPA implements ICatMediosService{

	@Autowired
	private CatMediosRepository catMediosRepo;
	
	

	@Override
	public List<CatMedios> buscraTodos() {
		return catMediosRepo.findAll();
	}

}

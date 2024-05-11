package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatCodigoPostalRepository;
import com.example.unesso.services.CatCodigoPostalService;


@Service
@Primary
public class CatCodigoPostalServiceJPA implements CatCodigoPostalService{
	@Autowired
	private CatCodigoPostalRepository catCodigoPostalRepo;
	
}

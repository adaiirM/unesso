package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatOcupacionRepository;
import com.example.unesso.services.CatOcupacionService;

@Service
@Primary
public class CatOcupacionServiceJPA implements CatOcupacionService{
	@Autowired
	private CatOcupacionRepository catOcupacionRepo;

}

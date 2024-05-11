package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.GastosFamRepository;
import com.example.unesso.services.GastosFamService;

@Service
@Primary
public class GastosFamServiceJPA implements GastosFamService {
	@Autowired
	private GastosFamRepository gastosFamRepo;

}

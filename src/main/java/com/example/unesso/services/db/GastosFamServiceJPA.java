package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.GastosFamRepository;
import com.example.unesso.services.IGastosFamService;

@Service
@Primary
public class GastosFamServiceJPA implements IGastosFamService {
	@Autowired
	private GastosFamRepository gastosFamRepo;

}

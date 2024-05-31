package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.HermanosRepository;
import com.example.unesso.services.HermanosService;

@Service
@Primary
public class HermanosServiceJPA implements HermanosService {
	@Autowired
	private HermanosRepository hermanosRepo;
}

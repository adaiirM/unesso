package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.MediosEstudiosRepository;
import com.example.unesso.services.MediosEstudiosService;

@Service
@Primary
public class MediosEstudiosServiceJPA implements MediosEstudiosService {
	@Autowired
	private MediosEstudiosRepository mediosEstudiosRepo;
	
}

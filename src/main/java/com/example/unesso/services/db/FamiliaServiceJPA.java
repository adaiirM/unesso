package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.FamiliaRepository;
import com.example.unesso.services.FamiliaService;

@Service
@Primary
public class FamiliaServiceJPA implements FamiliaService {
	@Autowired
	private FamiliaRepository familiaRepo;

}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.ReciboLuzRepository;
import com.example.unesso.services.ReciboLuzService;

@Service
@Primary
public class ReciboLuzServiceJPA implements ReciboLuzService {
	@Autowired
	private ReciboLuzRepository reciboLuzRepo;
	
	
}

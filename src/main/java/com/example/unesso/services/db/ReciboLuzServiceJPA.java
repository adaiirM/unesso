package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.ReciboLuzRepository;
import com.example.unesso.services.IReciboLuzService;

@Service
@Primary
public class ReciboLuzServiceJPA implements IReciboLuzService {
	@Autowired
	private ReciboLuzRepository reciboLuzRepo;
	
	
}

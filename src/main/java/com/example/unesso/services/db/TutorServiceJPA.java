package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.TutorRepository;
import com.example.unesso.services.ITutorService;

@Service
@Primary
public class TutorServiceJPA implements ITutorService {
	@Autowired
	private TutorRepository tutorRepo;
	
	
}

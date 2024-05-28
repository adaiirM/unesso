package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.TutorEconomico;
import com.example.unesso.repository.TutorRepository;
import com.example.unesso.services.ITutorEconomicoService;

@Service
@Primary
public class TutorEconomicoServiceJPA implements ITutorEconomicoService {
	@Autowired
	private TutorRepository tutorRepo;

	@Override
	public TutorEconomico guardarTutor(TutorEconomico tutor) {
		return tutorRepo.save(tutor);
	}
	
	
}

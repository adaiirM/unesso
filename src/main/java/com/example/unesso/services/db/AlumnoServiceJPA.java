package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.AlumnoRepository;
import com.example.unesso.services.AlumnoService;


@Service
@Primary
public class AlumnoServiceJPA implements  AlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepo;

}

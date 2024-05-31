package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.CatEstadoRepository;
import com.example.unesso.services.CatEstadoService;

@Service
@Primary
public class CatEstadoServiceJPA implements CatEstadoService{
	@Autowired
	private CatEstadoRepository catEstadoRepo;

}

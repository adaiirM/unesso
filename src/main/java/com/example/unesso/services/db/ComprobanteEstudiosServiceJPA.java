package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.ComprobanteEstudiosRepository;
import com.example.unesso.services.ComprobanteEstudiosService;

@Service
@Primary
public class ComprobanteEstudiosServiceJPA implements ComprobanteEstudiosService{
	@Autowired
	private ComprobanteEstudiosRepository comprobanteEstudiosRepo;
}

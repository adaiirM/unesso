package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.UsuarioRepository;
import com.example.unesso.services.UsuarioService;

@Service
@Primary
public class UsuarioServiceJPA implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepo;
	
}

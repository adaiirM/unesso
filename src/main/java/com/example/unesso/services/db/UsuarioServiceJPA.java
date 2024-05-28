package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Usuario;
import com.example.unesso.repository.UsuarioRepository;
import com.example.unesso.services.IUsuarioService;

@Service
@Primary
public class UsuarioServiceJPA implements IUsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public Usuario buscarPorCorreo(String correo) {
		return usuarioRepo.getByCorreo(correo);
	}
	
}

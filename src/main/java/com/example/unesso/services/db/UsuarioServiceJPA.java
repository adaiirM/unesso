package com.example.unesso.services.db;

import com.example.unesso.model.Usuario;
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

	@Override
	public Usuario findByCorreo(String correo) {
		return usuarioRepo.findByCorreo(correo);
	}
	@Override
	public void saveUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }
}

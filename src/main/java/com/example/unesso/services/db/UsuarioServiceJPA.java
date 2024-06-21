package com.example.unesso.services.db;

import com.example.unesso.model.Usuario;
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
	public Usuario findByCorreo(String correo) {
		return usuarioRepo.findByCorreo(correo);
	}
	@Override
	public void saveUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

	@Override
	public void deleteUsuarioByCorreo(String correo) {
		usuarioRepo.deleteByCorreo(correo);
	}

	public Usuario buscarPorCorreo(String correo) {
		return usuarioRepo.getByCorreo(correo);
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}

}

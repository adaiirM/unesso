package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Usuario;
import com.example.unesso.repository.UsuarioRepository;
import com.example.unesso.services.IUsuarioService;

/**
 * Clase de servicio para operaciones relacionadas con usuarios, implementada con JPA.
 */
@Service
@Primary
public class UsuarioServiceJPA implements IUsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepo;

	/**
	 * Obtiene el usuario correspondiente al correo especificado.
	 * @param correo: Correo electrónico del usuario.
	 * @return Usuario correspondiente al correo, o null si no se encuentra.
	 */
	@Override
	public Usuario buscarPorCorreo(String correo) {
		return usuarioRepo.findByCorreo(correo);
	}
	
}

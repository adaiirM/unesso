package com.example.unesso.controller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.EstadoFormularios;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.IAlumnoService;
import com.example.unesso.services.IUsuarioService;

@Service
public class SolicitarBecaService {
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private IAlumnoService alumnoService;
	
	
	public EstadoFormularios getEstadoFormularios(Authentication authentication) {
		//Obtiene el correo del usuario que se logeo
		String username = authentication.getName();
		//System.out.println(username);
		
		//Se obtiene usuario pormedio del correo
		Usuario usuario = usuarioService.buscarPorCorreo(username);
		System.out.println(usuario);
		
		//Se obtiene alumno pormedio del atributo idUser de usuario
		Alumno alumno = alumnoService.buscarAlumnoPorIdUsuario(usuario.getIdUser());
		
		EstadoFormularios estadoFormularios = alumno.getEstadoFormularios();
		
		return estadoFormularios;
		
	}
	
}

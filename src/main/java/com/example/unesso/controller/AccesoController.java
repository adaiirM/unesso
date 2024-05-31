package com.example.unesso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatParentesco;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.IUsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AccesoController {
	
	@Autowired
	private IUsuarioService serviceUsuario;

	@GetMapping("/login")
	public String login() {
		return "formLogin";
	}
	
	@GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);
        return "redirect:/";
    }
	
	@PostMapping("/cambiarContraseña")
	public String cambiarContraseña(Authentication auth, HttpSession sesion, String contraseñaActual, String contraseñaNueva2) {
		String correo = auth.getName();

		Usuario u = serviceUsuario.buscarPorCorreo(correo);
		u.setPassword("{noop}"+contraseñaNueva2);
		u = serviceUsuario.guardarUsuario(u);
		
		return "redirect:/";
	}
}

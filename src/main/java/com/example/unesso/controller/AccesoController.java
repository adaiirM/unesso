package com.example.unesso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String cambiarContraseña(Authentication auth, HttpSession sesion,@RequestParam("contraseñaNueva2") String contraseñaNueva2) {
		String correo = auth.getName();

		Usuario u = serviceUsuario.buscarPorCorreo(correo);
		u.setPassword("{noop}"+contraseñaNueva2);
		u = serviceUsuario.guardarUsuario(u);
		System.out.println(u);
		return "redirect:/";
	}
	
	@GetMapping("/validarContraseñaActual")
	@ResponseBody
	public boolean validarContraseñaActual(Authentication auth, @RequestParam("contraseñaActual") String contraseñaActual) {
		String correo = auth.getName();
		Usuario u = serviceUsuario.buscarPorCorreo(correo);
		System.out.println("Usuario a cambiar contraseña: " + u.toString());
		contraseñaActual = "{noop}"+contraseñaActual;
		return contraseñaActual.equals(u.getPassword());
	}
}

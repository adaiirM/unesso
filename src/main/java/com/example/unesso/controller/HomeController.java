package com.example.unesso.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.IAlumnoService;
import com.example.unesso.services.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	public IUsuarioService serviceUsuario;
	
	@Autowired
	public IAlumnoService serviceAlumno;

	
	@GetMapping("/")
	public String index(Authentication auth, HttpSession sesion, Model model) {
		String correo = auth.getName();
		ArrayList<String> rols = new ArrayList<>();
		
		for (GrantedAuthority rol : auth.getAuthorities()) {
			System.out.println(rol.getAuthority());
			rols.add(rol.getAuthority());
		}
		
		
		if(rols.get(0).equals("Alumno")) {
			Usuario u = serviceUsuario.buscarPorCorreo(correo);
			Alumno a = serviceAlumno.buscarPorUsuario(u);
			System.out.println(a);
			model.addAttribute("alumnoSesion", a);
			/*Alumno a = serviceAlumno.buscarPorUsuario(serviceUsuario.buscarPorCorreo(correo));
			model.addAttribute("nombreAlumno", a.getNombre());
			System.out.println(a.getNombre());*/
			return "menuAlumno";
		}else {
			return "administrador/menuAdministrador";
		}
	}
	
	@GetMapping("/inicio")
	public String index1() {
		return "menuAlumno";
	}
	
	@GetMapping("/comentariosSolicitud")
	public String comentarios() {
		return "alumno/comentarios";
	}
	
	@GetMapping("/lineamientos")
	public String lineamientos() {
		return "lineamientos";
	}
	
	@ModelAttribute
	public void setGenericos(Authentication auth, HttpSession sesion, Model model) {
		String correo = auth.getName();
		ArrayList<String> rols = new ArrayList<>();
		
		for (GrantedAuthority rol : auth.getAuthorities()) {
			System.out.println(rol.getAuthority());
			rols.add(rol.getAuthority());
		}
		
		if(rols.get(0).equals("Alumno")) {
			Usuario u = serviceUsuario.buscarPorCorreo(correo);
			Alumno a = serviceAlumno.buscarPorUsuario(u);
			System.out.println(a);
			model.addAttribute("alumnoSesion", a);
		}
	}
}


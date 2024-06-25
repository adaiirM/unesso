package com.example.unesso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.unesso.model.Alumno;

@Controller
public class AdminC {
	@GetMapping("/menuAdmin")
	public String menuSolicitar(Authentication auth, Model model) {
		return "administrador/formActualizarAlumno";
	}
	
}

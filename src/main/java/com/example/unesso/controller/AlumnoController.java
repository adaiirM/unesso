package com.example.unesso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/alumno")
public class AlumnoController {
	@GetMapping("/menuSolicitar")
	public String menuSolicitar() {
		return "alumno/menuSolicitarBeca";
	}
}

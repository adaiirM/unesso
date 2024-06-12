package com.example.unesso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/administrador")
public class AdministradorController {

    @GetMapping("/menuAdministrador")
    public String menuAdministrador() {
        return "/menuAdministrador";
    }

    @GetMapping("/estudiosSocieconomicos")
    public String todasLasSolicitudes(){
        return "/todasSolicitudes";
    }
    @GetMapping("/solicitudesRevisadas")
    public String solicitudesRevisadas(){
        return "/solicitudesRevisadas";
    }
    @GetMapping("/alumnos")
    public String alumnos(){
        return "/administrarAlumno";
    }
    @GetMapping("/fechas")
    public String fechas(){
        return "/administrarFecha";
    }
    @GetMapping("/agregarAlumno")
    public String agregarAlumno(){
        return "/formAgregarAlumno";
    }
}

package com.example.unesso.controller;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.db.AlumnoServiceJPA;
import com.example.unesso.services.db.UsuarioServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AlumnoServiceJPA alumnoService;
    @Autowired
    private UsuarioServiceJPA usuarioService;


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
    public String agregarAlumno(Model model){
        model.addAttribute("alumno", new Alumno());
        return "/formAgregarAlumno";
    }
    @PostMapping("/guardarAlumno")
    public String guardarAlumno(Alumno alumno) {
        String usuarioCorreo = alumno.getUsuario().getUsername();
        Usuario usuario = usuarioService.findByCorreo(usuarioCorreo);
        if (usuario == null) {
            usuario = new Usuario();
            usuario.setUsername(usuarioCorreo);
            usuario.setPassword("{noop}UNSIJ2024");
            usuario.setStatus(true);
            usuarioService.saveUsuario(usuario);
            alumno.setUsuario(usuario);
            alumnoService.saveAlumno(alumno);
            return "redirect:/administrador/alumnos"; // Redirige a la lista de alumnos después de guardar
        }else{
            return "error"; // Redirige a la lista de alumnos después de guardar
        }

    }
}

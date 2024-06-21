package com.example.unesso.controller;

import com.example.unesso.model.*;
import com.example.unesso.services.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AlumnoServiceJPA alumnoService;
    @Autowired
    private UsuarioServiceJPA usuarioService;
    @Autowired
    private EstadoFormulariosServiceJPA estadoFormularioService;
    @Autowired
    private ICatRolServiceJPA catRolService;
    @Autowired
    private CatGrupoServiceJPA catGrupoService;
    @Autowired
    private CatSemestreServiceJPA catSemestreService;
    @Autowired
    private CatCarreraServiceJPA catCarreraService;



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
        List<CatSemestre> semestres = catSemestreService.buscarTodos(); // Obtener los semestres desde el servicio
        List<CatCarrera> carreras = catCarreraService.buscarTodas(); // Obtener las carreras desde el servicio
        model.addAttribute("semestres", semestres); // Agregar los semestres al modelo
        model.addAttribute("carreras", carreras); // Agregar las carreras al modelo
        return "/formAgregarAlumno";
    }
    @PostMapping("/guardarAlumno")
    public String guardarAlumno(Alumno alumno,@RequestParam("nombreGrupo") String nombreGrupo) {
        String usuarioCorreo = alumno.getUsuario().getUsername();
        //busca si ya existe el usuario en la base de datos
        Usuario usuario = usuarioService.findByCorreo(usuarioCorreo);
        if (usuario == null) {
            //si no existe, crea el usuario y el alumno
            usuario = new Usuario();
            usuario.setUsername(usuarioCorreo);
            usuario.setPassword("{noop}UNSIJ2024");
            usuario.setStatus(true);

            CatRol catRol = catRolService.findByIdRol(1);
            usuario.setCatRol(catRol);
            usuario.setCatRol(catRol);

            usuarioService.saveUsuario(usuario);
            alumno.setUsuario(usuario);
            //alumnoService.saveAlumno(alumno);

            //se crea el estatus formulario
            EstadoFormularios estadoFormularios = new EstadoFormularios();
            estadoFormularios.setFormMisDatos(false);
            estadoFormularios.setFormMiFamilia(false);
            estadoFormularios.setFormDependienteEconomico(false);
            estadoFormularios.setFormMisGatos(false);
            alumno.setEstadoFormularios(estadoFormularios);

            //se relaciona con el grupo del alumno
            CatGrupo grupo = catGrupoService.findByNombreGrupo(nombreGrupo);
            alumno.setCatGrupo(grupo);

            estadoFormularioService.guardarEstadoFormularios(estadoFormularios);
            alumnoService.saveAlumno(alumno);
            return "redirect:/administrador/alumnos"; // Redirige a la lista de alumnos después de guardar
        }else{
            return "error";
        }

    }
}

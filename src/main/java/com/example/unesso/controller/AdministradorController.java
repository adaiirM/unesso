package com.example.unesso.controller;

import com.example.unesso.model.*;
import com.example.unesso.services.db.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String alumnos(Model model){
        List<Alumno> alumnos = alumnoService.getAllAlumnos();  // Método que obtiene todos los alumnos
        System.out.println(alumnos);
        model.addAttribute("alumnos", alumnos);
        return "/administrarAlumno";
    }
    @PostMapping("/eliminarAlumno")
    @Transactional
    public String eliminarAlumno(@RequestParam Integer idAlumno) {
        Alumno alumnoExistente = alumnoService.getByIdAlumno(idAlumno);
        if (alumnoExistente == null) {
            return "redirect:/administrador/error"; // Redirige si el alumno no se encuentra
        }
        if (alumnoExistente.getUsuario() != null) {
            usuarioService.deleteUsuarioByCorreo(alumnoExistente.getUsuario().getUsername());
        }

        alumnoService.deleteAlumno(idAlumno);
        return "redirect:/administrador/alumnos";
    }
    @GetMapping("/actualizarAlumno")
    public String mostrarFormularioActualizacion(@RequestParam Integer idAlumno, Model model) {
        System.out.println(idAlumno);
        Alumno alumno = alumnoService.getByIdAlumno(idAlumno);

        if (alumno == null) {
            return "redirect:/administrador/error"; // Redirige si el alumno no se encuentra
        }

        // Remover {noop} del password
        if (alumno.getUsuario() != null && alumno.getUsuario().getPassword().startsWith("{noop}")) {
            alumno.getUsuario().setPassword(alumno.getUsuario().getPassword().substring(6));
        }

        List<CatCarrera> carreras = catCarreraService.buscarTodas();
        List<CatSemestre> semestres = catSemestreService.buscarTodos();

        model.addAttribute("alumno", alumno);
        model.addAttribute("carreras", carreras);
        model.addAttribute("semestres", semestres);

        return "/formActualizarAlumno";
    }
    @PostMapping("/actualizarAlumno")
    @Transactional // Asegura que este método esté dentro de una transacción
    public String actualizarAlumno(@RequestParam("idAlumno") Integer idAlumno,@ModelAttribute("alumno") Alumno alumno,
                                   @RequestParam("correoParam") String correoParam,
                                   @RequestParam("contraseniaParam") String contraseniaParam) {
        // Buscar el alumno existente en la base de datos
        Alumno alumnoExistente = alumnoService.getByIdAlumno(idAlumno);
        if (alumnoExistente == null) {
            return "redirect:/administrador/ERROR";
        }

        // Buscar el usuario existente en la base de datos
        String usuarioCorreo = alumnoExistente.getUsuario().getUsername();
        String usuarioContrasenia = alumnoExistente.getUsuario().getPassword();

        Usuario usuario = usuarioService.findByCorreo(usuarioCorreo);

        //si se cambio el correo o la contraseña se actualiza a el usuario
        if(!usuarioCorreo.equals(correoParam) || !usuarioContrasenia.equals(contraseniaParam)){
            usuario.setUsername(usuarioCorreo);
            usuario.setPassword("{noop}"+contraseniaParam);
            usuarioService.saveUsuario(usuario);
            alumnoExistente.setUsuario(usuario);
        }


        CatGrupo grupo = catGrupoService.findByNombreGrupo(alumno.getCatGrupo().getNombreGrupo());
        if (grupo == null) {
            // Manejar el caso donde el grupo no existe
            return "redirect:/administrador/ERROR";
        }

        alumnoExistente.setCatGrupo(grupo);

        EstadoFormularios estadoFormularios = alumnoExistente.getEstadoFormularios();
        if (estadoFormularios == null) {
            estadoFormularios = new EstadoFormularios();
            estadoFormularios.setFormMisDatos(false);
            estadoFormularios.setFormMiFamilia(false);
            estadoFormularios.setFormDependienteEconomico(false);
            estadoFormularios.setFormMisGatos(false);
            estadoFormularioService.guardarEstadoFormularios(estadoFormularios);
        }
        alumnoExistente.setEstadoFormularios(estadoFormularios);

        // Actualizar otros campos del alumno según sea necesario
        alumnoExistente.setNombre(alumno.getNombre());
        alumnoExistente.setApellidoP(alumno.getApellidoP());
        alumnoExistente.setApellidoM(alumno.getApellidoM());
        alumnoExistente.setCurp(alumno.getCurp());
        alumnoExistente.setTelefono(alumno.getTelefono());
        alumnoExistente.setMatricula(alumno.getMatricula());

        alumnoService.saveAlumno(alumnoExistente);

        return "redirect:/administrador/alumnos";
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

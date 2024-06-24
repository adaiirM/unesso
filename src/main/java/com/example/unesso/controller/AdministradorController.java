package com.example.unesso.controller;

import com.example.unesso.model.*;
import com.example.unesso.services.FechasRegistradasService;
import com.example.unesso.services.db.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private FechasRegistradasServiceJPA fechasRegistradasService;



    @GetMapping("/menuAdministrador")
    public String menuAdministrador() {
        return "/menuAdministrador";
    }

    @GetMapping("/estudiosSocieconomicos")
    public String todasLasSolicitudes() {
        return "/todasSolicitudes";
    }

    @GetMapping("/solicitudesRevisadas")
    public String solicitudesRevisadas() {
        return "/solicitudesRevisadas";
    }

    @GetMapping("/alumnos")
    public String alumnos(Model model) {
        List<Alumno> alumnos = alumnoService.getAllAlumnos();  // Método que obtiene todos los alumnos
        System.out.println(alumnos);
        model.addAttribute("alumnos", alumnos);
        return "/administrarAlumno";
    }
    public String listarAlumnos(Model model, @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                @RequestParam("keyword") Optional<String> keyword) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(1); // Valor por defecto

        String currentKeyword = keyword.orElse("");

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("nombre").ascending());

        Page<Alumno> alumnoPage = alumnoService.buscarAlumno(currentKeyword, pageable);

        model.addAttribute("alumnos", alumnoPage.getContent());
        model.addAttribute("totalPages", alumnoPage.getTotalPages());
        model.addAttribute("totalAlumnos", alumnoPage.getTotalElements());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("keyword", currentKeyword);

        return "administrarAlumno";

    }

    @PostMapping("/eliminarAlumno")
    @Transactional
    public String eliminarAlumno(@RequestParam Integer idAlumno) {
        Alumno alumnoExistente = alumnoService.getByIdAlumno(idAlumno);
        if (alumnoExistente == null) {
            return "redirect:/administrador/error"; // Redirige si el alumno no se encuentra
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
    public String actualizarAlumno(@RequestParam("idAlumno") Integer idAlumno, @ModelAttribute("alumno") Alumno alumno,
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
        if (!usuarioCorreo.equals(correoParam) || !usuarioContrasenia.equals(contraseniaParam)) {
            usuario.setUsername(usuarioCorreo);
            usuario.setPassword("{noop}" + contraseniaParam);
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

    @GetMapping("/agregarAlumno")
    public String agregarAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        List<CatSemestre> semestres = catSemestreService.buscarTodos(); // Obtener los semestres desde el servicio
        List<CatCarrera> carreras = catCarreraService.buscarTodas(); // Obtener las carreras desde el servicio
        model.addAttribute("semestres", semestres); // Agregar los semestres al modelo
        model.addAttribute("carreras", carreras); // Agregar las carreras al modelo
        return "/formAgregarAlumno";
    }
    @PostMapping("/guardarAlumno")
    public String guardarAlumno(Alumno alumno, @RequestParam("nombreGrupo") String nombreGrupo) {
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
        } else {
            return "error";
        }

    }

    @GetMapping("/fechas")
    public String fechas(Model model) {
        List<CatCarrera> carreras = catCarreraService.buscarTodas();
        List<FechasRegistradas> fechasRegistradas = fechasRegistradasService.getAllFechasRegistradas();
        model.addAttribute("carreras", carreras);
        model.addAttribute("fechasRegistradas",fechasRegistradas);

        return "administrarFecha";
    }


    @PostMapping("/guardarFecha")
    public String guardarFecha(@RequestParam("carreraFecha") Integer idCatCarrera,
                               @RequestParam("fechaInicio")  Date fechaInicioStr,
                               @RequestParam("fechaFin")  Date fechaFinStr) {

        // Imprimir valores para depuración
        System.out.println("Received carreraFecha: " + idCatCarrera);
        System.out.println("Received fechaInicio: " + fechaInicioStr);
        System.out.println("Received fechaFin: " + fechaFinStr);

        // Buscar la carrera en la base de datos usando el id
        CatCarrera carrera = catCarreraService.findById(idCatCarrera);
        System.out.println("Found carrera: " + carrera);

        if (carrera == null) {
            throw new RuntimeException("No se encontró la carrera para el id: " + idCatCarrera);
        }

        // Crear una nueva instancia de FechasRegistradas y asignar los valores
        FechasRegistradas fechasRegistradas = new FechasRegistradas();
        fechasRegistradas.setCarrera(carrera);
        fechasRegistradas.setFechaInicio(fechaInicioStr);
        fechasRegistradas.setFechaFin(fechaFinStr);

        // Guardar las fechas registradas en la base de datos
        fechasRegistradasService.guardar(fechasRegistradas);

        return "redirect:/administrador/fechas"; // Redirigir a la vista de administración de fechas
    }

    @PostMapping("/eliminarFecha")
    @Transactional
    public String eliminarFecha(@RequestParam("idFechasRegistradas") Integer idFecha) {
        FechasRegistradas fechaExistente = fechasRegistradasService.getByIdFechasRegistradas(idFecha);
        if (fechaExistente == null) {
            return "redirect:/administrador/error"; // Redirige si la fecha no se encuentra
        }

        fechasRegistradasService.deleteFechasRegistradas(idFecha);
        return "redirect:/administrador/fechas";
    }

    @GetMapping("/actualizarFecha")
    public String mostrarFormularioActualizacionFecha(@RequestParam Integer idFecha, Model model) {
        // Obtener la fecha registrada por su ID
        FechasRegistradas fechaRegistrada = fechasRegistradasService.getByIdFechasRegistradas(idFecha);

        // Verificar si la fecha existe
        if (fechaRegistrada == null) {
            // Manejar caso de error, redireccionar o mostrar mensaje de error
            return "redirect:/error";
        }

        // Obtener lista de carreras u otros datos necesarios
        List<CatCarrera> carreras = catCarreraService.buscarTodas();

        // Agregar objetos necesarios al modelo
        model.addAttribute("fechaRegistrada", fechaRegistrada);
        model.addAttribute("carreras", carreras);

        // Devolver la vista del formulario de actualización de fecha
        return "formActualizarFecha";
    }

    @PostMapping("/actualizarFecha")
    public String actualizarFecha(@ModelAttribute("fechaRegistrada") FechasRegistradas fechaRegistrada) {
        // Guardar la fecha actualizada en la base de datos
        fechasRegistradasService.guardar(fechaRegistrada);

        // Redireccionar a una página de confirmación o a la lista de fechas actualizadas
        return "redirect:/administrador/fechas";
    }


}


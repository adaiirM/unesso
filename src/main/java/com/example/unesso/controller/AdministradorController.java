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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    @Autowired
    private AdministradorServiceJPA administradorService;



    @GetMapping("/menuAdministrador")
    public String menuAdministrador() {
        return "administrador/menuAdministrador";
    }

    @GetMapping("/administradores")
    public String Administradores(Model model, @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size,
                                  @RequestParam("keyword") Optional<String> keyword) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10); // Valor por defecto (solicitudes que muestra)

        String currentKeyword = keyword.orElse("");

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("nombre").ascending());

        Page<Administrador> adminPage = administradorService.buscarAdministrador(currentKeyword, pageable);

        model.addAttribute("administradores", adminPage.getContent());
        model.addAttribute("totalPages", adminPage.getTotalPages());
        model.addAttribute("totalAdministradores", adminPage.getTotalElements());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("keyword", currentKeyword);

        return "administrador/Administradores";
    }

    @GetMapping("/alumnos")
    public String listarAlumnos(Model model, @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                @RequestParam("keyword") Optional<String> keyword) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10); // Valor por defecto (solicitudes que muestra)

        String currentKeyword = keyword.orElse("");

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("nombre").ascending());

        Page<Alumno> alumnoPage = alumnoService.buscarAlumno(currentKeyword, pageable);

        model.addAttribute("alumnos", alumnoPage.getContent());
        model.addAttribute("totalPages", alumnoPage.getTotalPages());
        model.addAttribute("totalAlumnos", alumnoPage.getTotalElements());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("keyword", currentKeyword);

        return "administrador/administrarAlumno";

    }

    @GetMapping("/estudiosSocieconomicos")
    public String estudiosSocioeconomicos(Model model, @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size,
                                @RequestParam("keyword") Optional<String> keyword) {
        int currentPage = page.orElse(0);
        int pageSize = size.orElse(10); // Valor por defecto (solicitudes que muestra)

        String currentKeyword = keyword.orElse("");

        Pageable pageable = PageRequest.of(currentPage, pageSize, Sort.by("nombre").ascending());

        Page<Alumno> alumnoPage = alumnoService.buscarAlumno(currentKeyword, pageable);


        model.addAttribute("alumnos", alumnoPage.getContent());
        model.addAttribute("totalPages", alumnoPage.getTotalPages());
        model.addAttribute("totalAlumnos", alumnoPage.getTotalElements());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("keyword", currentKeyword);

        return "administrador/todasSolicitudes";

    }

    @GetMapping("/solicitudAlumno")
    public String getSolicitudAlumno(@RequestParam("idAlumno") Integer idAlumno,
                                     Model model){
        Alumno alumno = alumnoService.getByIdAlumno(idAlumno);
        if(alumno == null){
            model.addAttribute("tipoError", "Alumno no encontrado");
            model.addAttribute("descError", "El alumno solicitado no se encuentra en nuestra base de datos");
            return "administrador/errorPagina"; // Redirige si el alumno no se encuentra
        }

        if (alumno.getEstadoFormularios().getFormDependienteEconomico() == null ||
                alumno.getEstadoFormularios().getFormMiFamilia() || alumno.getEstadoFormularios().getFormMisDatos() == null
                || alumno.getEstadoFormularios().getFormMisGatos() == null) {
            model.addAttribute("tipoError", "Formularios incompletos");
            model.addAttribute("descError", "El Alumno solicitado tiene formularios incompletos");
            return "administrador/errorPagina"; // Redirige si los formularios están incompletos
        }

        List<IngresoFamiliar> ingresosFamiliares = alumno.getFamilia().getIngresoFamiliar();

        double ingresoTotal = ingresosFamiliares.stream()
                .mapToDouble(IngresoFamiliar::getIngresoNeto)
                .sum();

        double gastoTotal = 0;

        gastoTotal += alumno.getFamilia().getGastosFam().getGastosAlimentacion();
        gastoTotal += alumno.getFamilia().getGastosFam().getGastoRenta();
        gastoTotal += alumno.getFamilia().getGastosFam().getGastoServicios();
        gastoTotal += alumno.getFamilia().getGastosFam().getGastoEscolares();
        gastoTotal += alumno.getFamilia().getGastosFam().getGastoRopa();
        gastoTotal += alumno.getFamilia().getGastosFam().getGastoTransporte();
        gastoTotal += alumno.getFamilia().getGastosFam().getGastoOtros();



        model.addAttribute("alumno", alumno);
        model.addAttribute("ingresoTotal", ingresoTotal);
        model.addAttribute("gastosTotales",gastoTotal);
        return "administrador/formResultado";
    }

    @PostMapping("/eliminarAlumno")
    @Transactional
    public String eliminarAlumno(@RequestParam Integer idAlumno,Model model) {
        Alumno alumnoExistente = alumnoService.getByIdAlumno(idAlumno);
        if(alumnoExistente == null){
            model.addAttribute("tipoError", "Alumno no encontrado");
            model.addAttribute("descError", "El alumno solicitado no se encuentra en nuestra base de datos");
            return "administrador/errorPagina"; // Redirige si el alumno no se encuentra
        }

        alumnoService.deleteAlumno(idAlumno);
        return "redirect:/administrador/alumnos";
    }

    @GetMapping("/actualizarAlumno")
    public String mostrarFormularioActualizacion(@RequestParam Integer idAlumno, Model model) {
        System.out.println(idAlumno);
        Alumno alumno = alumnoService.getByIdAlumno(idAlumno);

        if(alumno == null){
            model.addAttribute("tipoError", "Alumno no encontrado");
            model.addAttribute("descError", "El alumno solicitado no se encuentra en nuestra base de datos");
            return "administrador/errorPagina"; // Redirige si el alumno no se encuentra
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

        return "administrador/formActualizarAlumno";
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

    @GetMapping("/agregarAdministrador")
    public String agregarAdministrador(Model model) {
        model.addAttribute("administrador",new Administrador());
        return "administrador/formAgregarAdministrador";
    }

    @PostMapping("/guardarAdministrador")
    public String guardarAdministrador(Administrador administrador, Model model) {
        String usuarioCorreo = administrador.getUsuario().getUsername();
        // Busca si ya existe el usuario en la base de datos
        Usuario usuario = usuarioService.findByCorreo(usuarioCorreo);
        if (usuario == null) {
            // Si el usuario no existe, crea el usuario y el administrador
            usuario = new Usuario();
            usuario.setUsername(usuarioCorreo);
            usuario.setPassword("{noop}UNSIJ2024");
            usuario.setStatus(true);

            CatRol catRol = catRolService.findByIdRol(2);
            usuario.setCatRol(catRol);


            usuarioService.saveUsuario(usuario);
            administrador.setUsuario(usuario); // Asignar el usuario al administrador
            administradorService.guardarAdministrador(administrador);
        }else{
            // Si el usuario ya existe, envía un mensaje de error y vuelve al formulario de agregar administrador
            model.addAttribute("tipoError", "El Usuario ya existe");
            model.addAttribute("descError", "El correo que estas tratando de ingresar ya esta relacionado con un usuario");
            return "administrador/errorPagina"; // Redirige si el alumno no se encuentra
        }
        return "redirect:/administrador/administradores";
    }

    @GetMapping("/editarAdministrador")
    public String editarAdministrador(@RequestParam Integer idAdministrador, Model model) {
        Administrador administrador = administradorService.getByIdAdministrador(idAdministrador);

        if (administrador == null) {
            return "redirect:/administrador/ERROR";
        }

        // Remover {noop} del password
        if (administrador.getUsuario() != null && administrador.getUsuario().getPassword().startsWith("{noop}")) {
            administrador.getUsuario().setPassword(administrador.getUsuario().getPassword().substring(6));
        }

        model.addAttribute("administrador", administrador);

        return "administrador/formActualizarAdministrador";
    }

    @PostMapping("/actualizarAdministrador")
    @Transactional
    public String actualizarAdministrador(@RequestParam("idAdministrador") Integer idAdministrador,
                                          @ModelAttribute("administrador") Administrador administrador,
                                          @RequestParam("correoParam") String correoParam,
                                          @RequestParam("contraseniaParam") String contraseniaParam) {

        Administrador administradorExistente = administradorService.getByIdAdministrador(idAdministrador);

        if (administradorExistente == null) {
            return "redirect:/administrador/ERROR";
        }
        // Buscar el usuario existente en la base de datos
        Usuario usuario = usuarioService.findByCorreo(correoParam);

        String usuarioCorreo = administradorExistente.getUsuario().getUsername();
        String usuarioContrasenia = administradorExistente.getUsuario().getPassword();


        //si se cambio el correo o la contraseña se actualiza a el usuario
        if (!usuarioCorreo.equals(correoParam) || !usuarioContrasenia.equals(contraseniaParam)) {
            usuario.setUsername(usuarioCorreo);
            usuario.setPassword("{noop}" + contraseniaParam);
            usuarioService.saveUsuario(usuario);
            administradorExistente.setUsuario(usuario);
        }

        administradorExistente.setNombre(administrador.getNombre());
        administradorExistente.setApellidoP(administrador.getApellidoP());
        administradorExistente.setApellidoM(administrador.getApellidoM());

        administradorService.guardarAdministrador(administradorExistente);

        return "redirect:/administrador/administradores";
    }

    @PostMapping("/eliminarAdministrador")
    @Transactional
    public String eliminarAdministrador(@RequestParam Integer idAdministrador, Model model) {
        Administrador administradorExistente = administradorService.getByIdAdministrador(idAdministrador);
        if (administradorExistente == null) {
            model.addAttribute("tipoError", "Administrador no encontrado");
            model.addAttribute("descError", "El Administrador solicitado no se encuentra en nuestra base de datos");
            return "administrador/errorPagina"; // Redirige si el alumno no se encuentra
        }

        administradorService.deleteAdministrador(idAdministrador);
        return "redirect:/administrador/alumnos";
    }

    @GetMapping("/agregarAlumno")
    public String agregarAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        List<CatSemestre> semestres = catSemestreService.buscarTodos(); // Obtener los semestres desde el servicio
        List<CatCarrera> carreras = catCarreraService.buscarTodas(); // Obtener las carreras desde el servicio
        model.addAttribute("semestres", semestres); // Agregar los semestres al modelo
        model.addAttribute("carreras", carreras); // Agregar las carreras al modelo
        return "administrador/formAgregarAlumno";
    }
    @PostMapping("/guardarAlumno")
    public String guardarAlumno(Alumno alumno, @RequestParam("nombreGrupo") String nombreGrupo, Model model) {
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
            model.addAttribute("tipoError", "El Usuario ya existe");
            model.addAttribute("descError", "El correo que estas tratando de registrar ya existe en la base de datos y ya esta relacionado con un alumno");
            return "administrador/errorPagina";
        }

    }

    @GetMapping("/fechas")
    public String fechas(Model model) {
        List<CatCarrera> carrerasSinFecha = catCarreraService.buscarCarrerasSinFecha();
        List<FechasRegistradas> fechasRegistradas = fechasRegistradasService.getAllFechasRegistradas();

        // Filtrar carreras que ya tienen fecha asignada
        List<CatCarrera> carrerasDisponibles = new ArrayList<>();
        for (CatCarrera carrera : carrerasSinFecha) {
            boolean tieneFechaAsignada = false;
            for (FechasRegistradas fecha : fechasRegistradas) {
                if (fecha.getCarrera().getIdCatCarrera().equals(carrera.getIdCatCarrera())) {
                    tieneFechaAsignada = true;
                    break;
                }
            }
            if (!tieneFechaAsignada) {
                carrerasDisponibles.add(carrera);
            }
        }

        model.addAttribute("carreras", carrerasDisponibles);
        model.addAttribute("fechasRegistradas", fechasRegistradas);

        return "administrador/administrarFecha"; // Nombre del archivo HTML de Thymeleaf
    }



    @PostMapping("/guardarFecha")
    public String guardarFecha(@RequestParam(value = "carreraFecha", required = false) Integer idCatCarrera,
                               @RequestParam(value = "fechaInicio", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicioStr,
                               @RequestParam(value = "fechaFin", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFinStr,
                               Model model) {

        // Verificar si los campos de las fechas están vacíos
        if (fechaInicioStr == null || fechaFinStr == null) {
            model.addAttribute("errorMessage", "Las fechas de inicio y fin son obligatorias.");

            // Recargar los datos necesarios para la vista
            List<CatCarrera> carrerasSinFecha = catCarreraService.buscarCarrerasSinFecha();
            List<FechasRegistradas> fechasRegistradas = fechasRegistradasService.getAllFechasRegistradas();

            // Filtrar carreras que ya tienen fecha asignada
            List<CatCarrera> carrerasDisponibles = new ArrayList<>();
            for (CatCarrera carrera : carrerasSinFecha) {
                boolean tieneFechaAsignada = false;
                for (FechasRegistradas fecha : fechasRegistradas) {
                    if (fecha.getCarrera().getIdCatCarrera().equals(carrera.getIdCatCarrera())) {
                        tieneFechaAsignada = true;
                        break;
                    }
                }
                if (!tieneFechaAsignada) {
                    carrerasDisponibles.add(carrera);
                }
            }

            model.addAttribute("carreras", carrerasDisponibles);
            model.addAttribute("fechasRegistradas", fechasRegistradas);

            return "administrador/administrarFecha"; // Retornar a la vista con el mensaje de error
        }

        // Imprimir valores para depuración
        System.out.println("Received carreraFecha: " + idCatCarrera);
        System.out.println("Received fechaInicio: " + fechaInicioStr);
        System.out.println("Received fechaFin: " + fechaFinStr);

        // Valida si la fecha de inicio es mayor que la fecha de fin
        if (fechaInicioStr.after(fechaFinStr)) {
            model.addAttribute("errorMessage", "La fecha de inicio no puede ser mayor que la fecha de fin.");

            // Recargar los datos necesarios para la vista
            List<CatCarrera> carrerasSinFecha = catCarreraService.buscarCarrerasSinFecha();
            List<FechasRegistradas> fechasRegistradas = fechasRegistradasService.getAllFechasRegistradas();

            // Filtrar carreras que ya tienen fecha asignada
            List<CatCarrera> carrerasDisponibles = new ArrayList<>();
            for (CatCarrera carrera : carrerasSinFecha) {
                boolean tieneFechaAsignada = false;
                for (FechasRegistradas fecha : fechasRegistradas) {
                    if (fecha.getCarrera().getIdCatCarrera().equals(carrera.getIdCatCarrera())) {
                        tieneFechaAsignada = true;
                        break;
                    }
                }
                if (!tieneFechaAsignada) {
                    carrerasDisponibles.add(carrera);
                }
            }

            model.addAttribute("carreras", carrerasDisponibles);
            model.addAttribute("fechasRegistradas", fechasRegistradas);

            return "administrador/administrarFecha"; // Retornar a la vista con el mensaje de error
        }

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

        return "redirect:/administrador/fechas";
    }

    @PostMapping("/eliminarFecha")
    @Transactional
    public String eliminarFecha(@RequestParam("idFechasRegistradas") Integer idFecha,Model model) {
        FechasRegistradas fechaExistente = fechasRegistradasService.getByIdFechasRegistradas(idFecha);
        if (fechaExistente == null) {
                model.addAttribute("tipoError", "Fecha no encontrada");
                model.addAttribute("descError", "La fecha solicitada no se encuentra en nuestra base de datos");
                return "administrador/errorPagina"; // Redirige si la fecha no se encuentra
        }

        fechasRegistradasService.deleteFechasRegistradas(idFecha);
        return "redirect:/administrador/fechas";
    }



    @GetMapping("/actualizarFecha")
    public String editarFecha(@RequestParam Integer idFechasRegistradas, Model model) {
        System.out.println(idFechasRegistradas);
        FechasRegistradas fechasRegistradas = fechasRegistradasService.getByIdFechasRegistradas(idFechasRegistradas);

        if (fechasRegistradas == null) {
            model.addAttribute("tipoError", "No existen fehas registradas");
            model.addAttribute("descError", "No existen fehas registradas en la base de datos");
            return "administrador/errorPagina"; // Redirige si el alumno no se encuentra
        }


        model.addAttribute("fechaRegistrada", fechasRegistradas);

        return "administrador/administrarFecha";

    }

    @GetMapping("/obtenerFechas")
    public String obtenerFechas(Model model) {
        // Aquí obtienes las fechas desde tu servicio o repositorio
        List<FechasRegistradas> fechas = fechasRegistradasService.getAllFechasRegistradas(); // Ejemplo: suponiendo que tienes un servicio para manejar las fechas

        model.addAttribute("fechas", fechas);
        return "modal_fechas"; // Nombre de la plantilla Thymeleaf para mostrar las fechas en la modal
    }


    @PostMapping("/actualizarFecha")
    public String actualizarFecha(@RequestParam("idFechasRegistradas") Integer idFechasRegistradas,
                                  @RequestParam("fechaInicio") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaInicioStr,
                                  @RequestParam("fechaFin") @DateTimeFormat(pattern = "dd/MM/yyyy") Date fechaFinStr) {

        // Imprimir valores para depuración
        System.out.println("Received idFechasRegistradas: " + idFechasRegistradas);

        System.out.println("Received fechaInicio: " + fechaInicioStr);
        System.out.println("Received fechaFin: " + fechaFinStr);

        // Buscar la carrera por su id


        // Obtener la fecha registrada por su id
        FechasRegistradas fechaRegistrada = fechasRegistradasService.getByIdFechasRegistradas(idFechasRegistradas);
        if (fechaRegistrada == null) {
            throw new RuntimeException("No se encontró la fecha registrada para el id: " + idFechasRegistradas);
        }

        // Actualizar los valores de la fecha registrada

        fechaRegistrada.setFechaInicio(fechaInicioStr);
        fechaRegistrada.setFechaFin(fechaFinStr);

        // Guardar los cambios en la base de datos
        fechasRegistradasService.guardar(fechaRegistrada);

        return "redirect:/administrador/fechas"; // Redirigir a la vista de fechas administradas
    }

    @GetMapping("/getByIdFechasRegistradas/{idFecha}")
    @ResponseBody
    public FechasRegistradas getByIdFechasRegistradas(@PathVariable Integer idFecha){
        return fechasRegistradasService.getByIdFechasRegistradas(idFecha);
    }

    }


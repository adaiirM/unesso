package com.example.unesso.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatOcupacion;
import com.example.unesso.model.CatParentesco;
import com.example.unesso.model.Domicilio;
import com.example.unesso.model.EstadoFormularios;
import com.example.unesso.model.Familia;
import com.example.unesso.model.TutorEconomico;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.IAlumnoService;
import com.example.unesso.services.ICatEscolaridadService;
import com.example.unesso.services.ICatEstadoService;
import com.example.unesso.services.ICatMaterialViviendaService;
import com.example.unesso.services.ICatOcupacionService;
import com.example.unesso.services.ICatParentescoService;
import com.example.unesso.services.ICatSituacionViviendaFamiliarService;
import com.example.unesso.services.ICatTipoViviendaService;
import com.example.unesso.services.IDomicilioService;
import com.example.unesso.services.IEstadoFormulariosService;
import com.example.unesso.services.IFamiliaService;
import com.example.unesso.services.ITutorEconomicoService;
import com.example.unesso.services.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/alumno")
public class AlumnoController {
	
	@Value("${inesis.ruta.recibosLuz}")
	private String rutaRecibosLuz;
	
	@Autowired
	private ICatParentescoService serviceParentesco;
	
	@Autowired
	private ICatEstadoService serviceEstado;
	
	@Autowired
	private ICatEscolaridadService serviceEscolaridad;
	
	@Autowired
	private ICatTipoViviendaService serviceTipoVivienda;
	
	@Autowired
	private ICatSituacionViviendaFamiliarService serviceSituacionViviendaFamiliar;
	
	@Autowired
	private ICatMaterialViviendaService serviceMaterialVivienda;
	
	@Autowired
	public IUsuarioService serviceUsuario;
	
	@Autowired
	public IAlumnoService serviceAlumno;
	
	@Autowired
	public ICatOcupacionService serviceOcupacion;
	
	@Autowired 
	public ITutorEconomicoService serviceTutorEconomico;
	
	@Autowired
	public IDomicilioService serviceDomicilio;
	
	@Autowired
	public IFamiliaService serviceFamilia;
	
	@Autowired
	public IEstadoFormulariosService serviceEstadoFormularios;
	
	@GetMapping("/menuSolicitar")
	public String menuSolicitar(Authentication auth, Model model) {
		Alumno a = obtenerAlumnoSesion(auth);
		model.addAttribute("estadoFormularios", a.getEstadoFormularios());
		return "alumno/menuSolicitarBeca";
	}
	
	@GetMapping("/formMisGastos")
	public String formularioMisGastos(Authentication auth, Model model) {
		Alumno a = obtenerAlumnoSesion(auth);
		Familia f = new Familia();
		System.out.println("Entra");
		if(a.getFamilia() != null) {
			f = serviceFamilia.obtenerFamiliaPorId(a.getFamilia().getIdFamilia());
			// Obtener la fecha del objeto
	        Date fechaI = f.getGastosFam().getReciboLuz().getPeriodoInicio();
	        
	        // Convertir Date a LocalDate
	        LocalDate localDate = fechaI.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        	
	        // Formatear LocalDate a yyyy-MM-dd
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String fechaFormateadaI = localDate.format(formatter);
			System.out.println(fechaFormateadaI); 
			//String fechaFormateadaF = formatoDeseado.format(f.getGastosFam().getReciboLuz().getPeriodoFin());
			//System.out.println(fechaFormateadaI); 
			
			model.addAttribute("fechaFormateadaI", fechaFormateadaI);
			//model.addAttribute("fechaFormateadaF", fechaFormateadaF);
		} else {
			f.setIngresoFamiliar(new ArrayList<>());
		}
		
		System.out.println("Datos de familia a enviar a la bd: " + f);
		
		model.addAttribute("familia", f);
		return "alumno/formMisGastos";
	}
	
	@GetMapping("/formMiTutor")
	public String formularioTutor(Authentication auth, Model model) {
		TutorEconomico tutorEconomico = new TutorEconomico();
		Alumno a = obtenerAlumnoSesion(auth);
		
		if(a.getTutorEconomico() != null) {
			tutorEconomico = serviceTutorEconomico.obtenerPorId(a.getTutorEconomico().getIdTutorEconomico());
			System.out.println(tutorEconomico.toString());
			//System.out.println(tutorEconomico.getDomicilio().getCatLocalidad().getCatMunicipio().getCatEstado().getIdCatEstado());
		}
		
		List<CatEstado> listEstado = serviceEstado.listEstados();
		List<CatOcupacion> listOcupacion = serviceOcupacion.listaOcupaciones();
		
		model.addAttribute("tutorEconomico", tutorEconomico);
		model.addAttribute("estados", listEstado);
		model.addAttribute("ocupaciones", listOcupacion);
		model.addAttribute("alumno", a);
		return "alumno/formMiTutor";
	}
	
	@PostMapping("/guardarTutor")
	public String guardarDom(@RequestParam("accion") String accion, Authentication auth, Alumno alumno, BindingResult result) {
		/*if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			
			return "alumno/formTutor";
		}*/
		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno a = obtenerAlumnoSesion(auth);
		a.setGastoMensual(alumno.getGastoMensual());
		a.setDependeEconomicamente(alumno.getDependeEconomicamente());
		System.out.println("Datos del alumno de la sesion: " + alumno.toString());
		System.out.println("Accion: " + accion);
		
		if(a.getTutorEconomico() != null) {
			System.out.println("Tutor del formulario: " + alumno.getTutorEconomico());
			
			//Obtener el tutor de la base de datos mediante el id dentro del alumno
			TutorEconomico t =  serviceTutorEconomico.obtenerPorId(a.getTutorEconomico().getIdTutorEconomico());
			System.out.println("Tutor de la base de datos: " + t.toString());
			
			//Crear domicilio que almacena el domicilio de la base de datos
			Domicilio dommicilioBD = serviceDomicilio.buscarPorId(a.getTutorEconomico().getDomicilio().getIdDomicilio());
			
			//Crear objeto de domicilio para almacenar el domicilio proveniente del formulario
			Domicilio domicilioFormulario = alumno.getTutorEconomico().getDomicilio();
			
			//Asignar al domiclio del formulario el id del domiclio de la base de datos
			domicilioFormulario.setIdDomicilio(dommicilioBD.getIdDomicilio());
			
			//Asignar el id del tutor y el objeto del domicilio
			alumno.getTutorEconomico().setIdTutorEconomico(t.getIdTutorEconomico());
			alumno.getTutorEconomico().setDomicilio(domicilioFormulario);
			
			//Guardara en la bd
			t = alumno.getTutorEconomico();
			serviceDomicilio.guardarDomicilio(domicilioFormulario);
			serviceTutorEconomico.guardarTutor(t);
		}else {
			System.out.println("---------------------------------Entra----------------------------------");
			a.setTutorEconomico(alumno.getTutorEconomico());
			serviceTutorEconomico.guardarTutor(alumno.getTutorEconomico());
			serviceAlumno.guardarAlumno(a);
		}
		
		if(accion.equals("enviar")) {
			if(a.getEstadoFormularios() == null) {
				EstadoFormularios ef = new EstadoFormularios();
				ef.setFormDependienteEconomico(true);
				EstadoFormularios e = serviceEstadoFormularios.guardarEstadoFormularios(ef);
				a.setEstadoFormularios(e);
				serviceAlumno.guardarAlumno(a);
			} else {
				a.getEstadoFormularios().setFormDependienteEconomico(true);
				serviceAlumno.guardarAlumno(a);
			}
		}

		return "alumno/menuSolicitarBeca";
	}
	
	@PostMapping("/guardarGastos")
	public String guardarGastos(Authentication auth, Familia familia,  @RequestParam("archivoReciboLuz") MultipartFile multiPart) {
		System.out.println(familia.toString());
		System.out.print(multiPart);
		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno a = obtenerAlumnoSesion(auth);
		
		
		
		
		return "alumno/formMisGastos";
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
			List<CatParentesco> listaParentesco = serviceParentesco.listarParentescos();
			model.addAttribute("parentescos", listaParentesco);
			System.out.println(a);
			model.addAttribute("alumnoSesion", a);
		}
	}
	
	private Alumno obtenerAlumnoSesion(Authentication auth) {
		String correo = auth.getName();
		Usuario u = serviceUsuario.buscarPorCorreo(correo);
		return serviceAlumno.buscarPorUsuario(u);

	}
}

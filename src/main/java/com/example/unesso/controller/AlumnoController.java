package com.example.unesso.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.unesso.controller.services.MiFamiliaService;
import com.example.unesso.controller.services.MisDatosService;
import com.example.unesso.formsModel.FormMiFamilia;
import com.example.unesso.formsModel.FormMisDatos;
import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatMedios;
import com.example.unesso.model.CatMediosTransporte;
import com.example.unesso.model.CatOcupacion;
import com.example.unesso.model.CatParentesco;
import com.example.unesso.model.CatServicios;
import com.example.unesso.model.Domicilio;


import com.example.unesso.model.Familia;
import com.example.unesso.model.GastosFam;
import com.example.unesso.model.IngresoFamiliar;
import com.example.unesso.model.ReciboLuz;
import com.example.unesso.model.Trabajo;
import com.example.unesso.model.TutorEconomico;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.IAlumnoService;
import com.example.unesso.services.ICatCarreraService;
import com.example.unesso.services.ICatEscolaridadService;
import com.example.unesso.services.ICatEstadoCivilService;
import com.example.unesso.services.ICatEstadoService;
import com.example.unesso.services.ICatInternetService;
import com.example.unesso.services.ICatMaterialViviendaService;
import com.example.unesso.services.ICatMediosService;
import com.example.unesso.services.ICatMediosTransporteService;
import com.example.unesso.services.ICatOcupacionService;
import com.example.unesso.services.ICatParentescoService;
import com.example.unesso.services.ICatSemestreService;
import com.example.unesso.services.ICatServiciosService;
import com.example.unesso.services.ICatSituacionViviendaFamiliarService;
import com.example.unesso.services.ICatSituacionViviendaService;
import com.example.unesso.services.ICatTipoTransporteService;
import com.example.unesso.services.ICatTipoViviendaService;
import com.example.unesso.services.IDomicilioService;
import com.example.unesso.services.IEstadoFormulariosService;
import com.example.unesso.services.IFamiliaService;
import com.example.unesso.services.IGastosFamService;
import com.example.unesso.services.IReciboLuzService;

import com.example.unesso.services.ITrabajoService;
import com.example.unesso.services.ITutorEconomicoService;
import com.example.unesso.services.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/alumno")
public class AlumnoController {
	//Ruta del servidor donde se guardaran los archivos
	@Value("${unessi.ruta.recibos}")
	private String rutaRecibos;
	
	@Value("${unessi.ruta.comprobantes}")
	private String rutaComprobantes;
	
	@Value("${inesis.ruta.recibosLuz}")
	private String rutaRecibosLuz;

	@Autowired
	private ICatCarreraService catCarreraService;
	
	@Autowired
	private ICatEstadoService catEstadoService;
	
	@Autowired
	private ICatEstadoCivilService catEstadoCivilService;
	
	@Autowired
	private ICatMediosTransporteService catMediosTransporteService;
	
	@Autowired
	private ICatTipoTransporteService catTipoTransporteService;
	
	@Autowired
	private ICatMediosService catMediosService;
	
	@Autowired
	private ICatSemestreService iCatSemestreService ;
	
	@Autowired
	private ICatEscolaridadService catEscolaridadService ;
	
	
	@Autowired
	private ICatTipoViviendaService vatTipoViviendaService ;
	
	@Autowired
	private ICatSituacionViviendaFamiliarService catSituacionViviendaService ;
	
	@Autowired
	private ICatMaterialViviendaService catMaterialViviendaService ;
	
	@Autowired
	private ICatParentescoService catParentescoService ;
	
	@Autowired
	private ICatSituacionViviendaService catSituacionViviendaUniService ;
	
	@Autowired
	private ICatOcupacionService catOcupacionService ;

	@Autowired
	private ICatServiciosService catServiciosService;
	
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
	
	@Autowired
	public IGastosFamService serviceGastosFam;
	
	@Autowired
	public IReciboLuzService serviceReciboLuz;
	
	//Relizara las operaciones CRUD para el fromulario de miFamilia
	@Autowired
	private MiFamiliaService miFamiliaService;
	
	//Relizara las operaciones CRUD para el fromulario de misDatos
	@Autowired
	private MisDatosService misDatosService;
	
	@Autowired
	private ICatInternetService catInternetService;
	
	@Autowired 
	private ITrabajoService serviceTrabajo;
	
	@GetMapping("/menuSolicitar")
	public String menuSolicitar(Authentication auth, Model model) {
		Alumno a = obtenerAlumnoSesion(auth);
		model.addAttribute("estadoFormularios", a.getEstadoFormularios());
		return "alumno/menuSolicitarBeca";
	}
	
	@GetMapping("/menuAlumno")
	public String menuAlumno(Authentication auth, Model model) {
		
		return "alumno/menuSolicitarBeca";
	}

	@GetMapping("/comentariosSolicitud")
	public String comentariosSolicitud(Authentication auth, Model model) {

        return "alumno/comentariosSolicitud";
    }
	
	
	@GetMapping("/misDatos")
    public String crear(Model model, Authentication authentication) {
        FormMisDatos formMisDatos = misDatosService.getMisDatos(authentication);
        model.addAttribute("formMisDatos", formMisDatos);
        return "alumno/formMisDatos";
    }

    @PostMapping("/saveMisDatos")
    public String saveDatosPersonales(FormMisDatos datos, Authentication authentication, RedirectAttributes attributes) {
        misDatosService.saveDatosPersonales(datos, authentication);
        
        return "redirect:/alumno/menuSolicitar";
    }
	
	@GetMapping("/miFamilia")
	public String crearMiFamilia(Model model,Authentication authentication){
		FormMiFamilia formMiFamilia = miFamiliaService.getMiFamilia(authentication);
		model.addAttribute("formMiFamilia", formMiFamilia);	
		return "alumno/formMiFamilia";
	}
	
	
	@PostMapping("/saveMiFamilia")
	public String saveMiFamilia(@ModelAttribute FormMiFamilia datos,RedirectAttributes attributes,
			@RequestParam("file") MultipartFile[] files, Model model, Authentication authentication) {
		miFamiliaService.saveMiFamilia(datos, authentication, files);	
		return "redirect:/alumno/menuSolicitar";
	}
	
	
	@GetMapping("/formMisGastos")
	public String formularioMisGastos(Authentication auth, Model model) {
		Alumno a = obtenerAlumnoSesion(auth);
		Familia f = new Familia();
		System.out.println("Ob: " + a.getObservaciones());
		if(a.getFamilia() != null) {
			
			f = serviceFamilia.obtenerFamiliaPorId(a.getFamilia().getIdFamilia());
			System.out.println(f.toString());
			System.out.println("Ingreso familiar: " + f.getIngresoFamiliar());

			if(f.getGastosFam() != null) {
				if(f.getGastosFam().getReciboLuz() != null) {
					// Obtener la fecha del objeto
			        Date fechaI = f.getGastosFam().getReciboLuz().getPeriodoInicio();
			        Date fechaF = f.getGastosFam().getReciboLuz().getPeriodoFin();

			        // Convertir Date a LocalDate
			        LocalDate localDateI = fechaI.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			        LocalDate localDateF = fechaF.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			        // Formatear LocalDate a yyyy-MM-dd
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			        String fechaFormateadaI = localDateI.format(formatter);
			        String fechaFormateadaF = localDateF.format(formatter);
					System.out.println(fechaFormateadaI); 

					model.addAttribute("fechaFormateadaI", fechaFormateadaI);
					model.addAttribute("fechaFormateadaF", fechaFormateadaF);
				}
			}

			
		} else {
			f.setIngresoFamiliar(new ArrayList<>());
		}
		
		model.addAttribute(""
				+ "", a.getObservaciones());
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
		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno alumnoSesion = obtenerAlumnoSesion(auth);
		
		//Verificar cuando no fue seleecionada una opcion en los select 
		if(alumno.getTutorEconomico().getCatOcupacion().getIdCatOcupacion() == null) {
			alumno.getTutorEconomico().setCatOcupacion(null);
		}
		
		if(alumno.getTutorEconomico().getCatParentesco().getIdCatParentesco() == null) {
			alumno.getTutorEconomico().setCatParentesco(null);
		}
		
		if(alumno.getTutorEconomico().getDomicilio().getCatLocalidad().getIdCatLocalidad() == null) {
			alumno.getTutorEconomico().getDomicilio().setCatLocalidad(null);
		}
		
		//Verificar que el alumno tenga un trabajo 
		if(alumno.getTrabajo().getDomicilio().getCatLocalidad().getIdCatLocalidad() == null) {
			alumno.getTrabajo().getDomicilio().setCatLocalidad(null);
		}

		//Asignar el gasto mensual a alumno
		alumnoSesion.setGastoMensual(alumno.getGastoMensual());
		
		//Asignar si el alumno depende economicamente
		alumnoSesion.setDependeEconomicamente(alumno.getDependeEconomicamente());
		
		System.out.println("Daots del alumnoSesion: " + alumnoSesion.toString());
		
		//Verificar si el alumno tiene registrado un trabajo
		if(alumnoSesion.getTrabajo() == null) {
			//Verificar que el alumno tenga un trabajo 
			if (alumno.getTrabajo() != null) {
				alumno.getTrabajo().setAlumno(alumnoSesion);
			}	
			alumnoSesion.setTrabajo(alumno.getTrabajo());
			serviceAlumno.guardar(alumnoSesion);
			
			//Si ya tiene registrado uno, modificar
		} else {
			//Verificar que el usuario dependa economicamente
			if(alumno.getDependeEconomicamente().equals(false)) {
				
				// Si depende, guardar el domiclio y trabajo actualizados.
				Domicilio domicilioTrabajoDB = serviceDomicilio.buscarPorId(alumnoSesion.getTrabajo().getDomicilio().getIdDomicilio());
				Domicilio domicilioTrabajoForm = alumno.getTrabajo().getDomicilio();
				domicilioTrabajoForm.setIdDomicilio(domicilioTrabajoDB.getIdDomicilio());
				
				serviceDomicilio.guardar(domicilioTrabajoForm);
				
				//Actualizar datos del trabajo con los datos del formulario
				Trabajo trabajoDB = serviceTrabajo.buscarPorId(alumnoSesion.getTrabajo().getIdTrabajo());
				Trabajo trabajoForm = alumno.getTrabajo();
				trabajoForm.setIdTrabajo(trabajoDB.getIdTrabajo());
				trabajoForm.setAlumno(alumnoSesion);
				serviceTrabajo.guardarTrabajo(trabajoForm);
				
				//Si no depende, se borran los registros
			} else {
				
				Domicilio domicilioVacio = new Domicilio();	
				
				if(alumnoSesion.getTrabajo().getDomicilio().getIdDomicilio() == null) {
					domicilioVacio = null;
				} 
				
				domicilioVacio.setIdDomicilio(alumnoSesion.getTrabajo().getDomicilio().getIdDomicilio());
				serviceDomicilio.guardar(domicilioVacio);
				
				alumnoSesion.getTrabajo().setTelefono(null);
				alumnoSesion.getTrabajo().setNombreTrabajo(null);
				alumnoSesion.getTrabajo().setIngresoMensual(null);
				
				serviceAlumno.guardar(alumnoSesion);
			}
		}
		
		//Verificar si el alumno tiene relacionado un tutor
			//Si tiene uno, actualizar datos
		if(alumnoSesion.getTutorEconomico() != null) {
			
			//Actualizar datos del domiciliio del tutor con los datos del formulario
			Domicilio domicilioDB = serviceDomicilio.buscarPorId(alumnoSesion.getTutorEconomico().getDomicilio().getIdDomicilio());
			Domicilio domicilioForm = alumno.getTutorEconomico().getDomicilio();
			domicilioForm.setIdDomicilio(domicilioDB.getIdDomicilio());
			serviceDomicilio.guardar(domicilioForm);
			
			//Actualizar datos del tutor con los datos del formulario
			TutorEconomico tutorDB =  serviceTutorEconomico.obtenerPorId(alumnoSesion.getTutorEconomico().getIdTutorEconomico());
			TutorEconomico tutorForm = alumno.getTutorEconomico();
			tutorForm.setIdTutorEconomico(tutorDB.getIdTutorEconomico());
			serviceTutorEconomico.guardarTutor(tutorForm);
			
			//Si no tiene un tutor relacionado, crear uno
		} else {
			TutorEconomico tutorE = serviceTutorEconomico.guardarTutor(alumno.getTutorEconomico());			
			alumnoSesion.setTutorEconomico(tutorE);
			//serviceAlumno.guardar(alumnoSesion);
		}

		serviceAlumno.guardarAlumno(alumnoSesion);

		if(accion.equals("enviar")) {
			alumnoSesion.getEstadoFormularios().setFormDependienteEconomico(true);
			return "redirect:/alumno/miFamilia";
		} else {
			return "redirect:/alumno/menuSolicitar";
		}		
	}
	
	
	@PostMapping("/guardarGastos")
	public String guardarGastos(Authentication auth, Familia familia,  @RequestParam("archivoReciboLuz") MultipartFile multiPart, 
			@RequestParam("observaciones") String observacones) {
		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno alumnoSesion = obtenerAlumnoSesion(auth);
		
		
		if (!multiPart.isEmpty()) {
			System.out.print(multiPart);
		}
		
		System.out.println("Familia del formulario: " + familia.getIngresoFamiliar().toString());
		
		if(alumnoSesion.getFamilia() != null) {
			
			// Asociar la familia a cada ingreso familiar
	        if (familia.getIngresoFamiliar() != null) {
	            for (IngresoFamiliar ingreso : familia.getIngresoFamiliar()) {
	                ingreso.setFamilia(familia);
	            }	            
	        }
			
			familia.setIdFamilia(alumnoSesion.getFamilia().getIdFamilia());
			System.out.println("Antes del if" + alumnoSesion.getFamilia().getIdFamilia());
			
			
			if(alumnoSesion.getFamilia().getGastosFam() != null) {
				GastosFam gf = serviceGastosFam.buscarPorId(alumnoSesion.getFamilia().getGastosFam().getIdGastosFam());
				GastosFam gfEnviar = familia.getGastosFam();
				gfEnviar.setIdGastosFam(gf.getIdGastosFam());
				
				if(alumnoSesion.getFamilia().getGastosFam().getReciboLuz() != null) {
					
					System.out.println("Entra");
					ReciboLuz rb = serviceReciboLuz.buscarPorId(alumnoSesion.getFamilia().getGastosFam().getReciboLuz().getIdReciboLuz());
					ReciboLuz rbEnviar = familia.getGastosFam().getReciboLuz();
					
					if(rbEnviar.getPagoBimestral() == null) {
						rbEnviar.setPagoBimestral("0");
					}
					
					rbEnviar.setIdReciboLuz(rb.getIdReciboLuz());
					System.out.println(rbEnviar.toString());
					serviceReciboLuz.guardarReciboLuz(rbEnviar);
				}
				serviceGastosFam.guardarGastoFam(gfEnviar);
			}			
			
			serviceFamilia.guardarFamilia(familia);
		} else {
			Familia f = serviceFamilia.guardarFamilia(familia);
			
			// Asociar la familia a cada ingreso familiar
	        if (familia.getIngresoFamiliar() != null) {
	            for (IngresoFamiliar ingreso : familia.getIngresoFamiliar()) {
	                ingreso.setFamilia(familia);
	            }	            
	        }
			
			alumnoSesion.setFamilia(f);
			serviceAlumno.guardarAlumno(alumnoSesion);
		}
		
		alumnoSesion.setObservaciones(observacones);
		serviceAlumno.guardarAlumno(alumnoSesion);
		
		return "redirect:/alumno/menuSolicitar";
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
		
		model.addAttribute("carreras", catCarreraService.buscarTodas());
		model.addAttribute("catEstado", catEstadoService.buscarTodos());
		model.addAttribute("estadosCiviles", catEstadoCivilService.buscarTodos()); 
		model.addAttribute("catTipoTransporte", catTipoTransporteService.buscarTodos()); 
		model.addAttribute("catSemestre",iCatSemestreService.buscarTodos());
		model.addAttribute("catEscolaridad", catEscolaridadService.buscarTodas());
		model.addAttribute("catTipoVivienda", vatTipoViviendaService.buscarTodas());
		model.addAttribute("catSituacionViviendaFam", catSituacionViviendaService.buscarTodas());
		model.addAttribute("catMaterialVivienda",catMaterialViviendaService.buscarTodas());
		model.addAttribute("catPerentesco",catParentescoService.buscarTodos());
		model.addAttribute("catSituacionViviendaUni", catSituacionViviendaUniService.buscarTodas());
		model.addAttribute("catOcupacion",catOcupacionService.buscarTodas());
		model.addAttribute("catInternet",catInternetService.buscarTodos());
		 
		 //Lista de catMediosTransporte
		 List<CatMediosTransporte> mediosTransporte =  catMediosTransporteService.buscarTodos();
	        // Dividir la lista en sublistas de tres elementos
	        List<List<CatMediosTransporte>> gruposTransporte = 
	            IntStream.range(0, (mediosTransporte.size() + 2) / 3)
	                .mapToObj(i -> mediosTransporte.subList(i * 3, Math.min(i * 3 + 3, mediosTransporte.size())))
	                .collect(Collectors.toList());
	     model.addAttribute("gruposTransporte", gruposTransporte);
	     
	   //Lista de catServicios
		 List<CatServicios> catServicios =  catServiciosService.buscarTodos();
	        // Dividir la lista en sublistas de tres elementos
	        List<List<CatServicios>> gruposServicios = 
	            IntStream.range(0, (catServicios.size() + 2) / 3)
	                .mapToObj(i -> catServicios.subList(i * 3, Math.min(i * 3 + 3, catServicios.size())))
	                .collect(Collectors.toList());
	     model.addAttribute("catServicios", gruposServicios);
	     
	     
	     List<CatMedios> catMedios=  catMediosService.buscraTodos();
	     
	        // Dividir la lista en sublistas de tres elementos
	        List<List<CatMedios>> medios = 
	            IntStream.range(0, (catMedios.size() + 1) / 2)
	                .mapToObj(i -> catMedios.subList(i * 2, Math.min(i * 2 + 2, catMedios.size())))
	                .collect(Collectors.toList());

	     model.addAttribute("catMedios", medios);	
	}
	
	private Alumno obtenerAlumnoSesion(Authentication auth) {
		String correo = auth.getName();
		Usuario u = serviceUsuario.buscarPorCorreo(correo);
		return serviceAlumno.buscarPorUsuario(u);

	}
}

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
import com.example.unesso.model.EstadoFormularios;
import com.example.unesso.model.Familia;
import com.example.unesso.model.GastosFam;
import com.example.unesso.model.ReciboLuz;
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
		/*if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			
			return "alumno/formTutor";
		}*/
		
		//System.out.println("1. Alumno formulario: " + alumno.toString());
		
		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno alumnoSesion = obtenerAlumnoSesion(auth);
		
		//System.out.println("2. Alumno sesion: " + alumnoSesion.toString());
		
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
		
		//Asignar el gasto mensual a alumno
		alumnoSesion.setGastoMensual(alumno.getGastoMensual());
		
		//Asignar si el alumno depende economicamente
		alumnoSesion.setDependeEconomicamente(alumno.getDependeEconomicamente());
		
		
		//Verificar si el alumno tiene relacionado un tutor
			//Si tiene uno, actualizar datos
		if(alumnoSesion.getTutorEconomico() != null) {
			
			//Obtener el tutor de la base de datos mediante el id dentro del alumno
			TutorEconomico tutorDB =  serviceTutorEconomico.obtenerPorId(alumnoSesion.getTutorEconomico().getIdTutorEconomico());
			//System.out.println("Tutor de la base de datos: " + tutorDB.toString());
			
			//Verificar si el domicilio del tutor es igual al del alumno
			if(alumno.getTutorEconomico().getEsViviendaAlumno().equals(true)) {
				//Obtener el domicilio relacionado al alumno 
				Domicilio domAlumno = serviceDomicilio.buscarPorId(alumnoSesion.getDomicilio().getIdDomicilio());
				
				//Quitar los datos traidos de la base de datos
				tutorDB.setDomicilio(null);
				//Asignar el objeto obtenido del domiclio del alumno
				tutorDB.setDomicilio(domAlumno);
				
				//Guardara en la bd
				serviceDomicilio.guardarDomicilio(tutorDB.getDomicilio());
				
				//Si no es igual, actualizar el domicilio de la base de datos
			} else {
				//Crear domicilio que almacena el domicilio de la base de datos
				Domicilio dommicilioBD = serviceDomicilio.buscarPorId(alumnoSesion.getTutorEconomico().getDomicilio().getIdDomicilio());
				
				//Crear objeto de domicilio para almacenar el domicilio proveniente del formulario
				Domicilio domicilioFormulario = alumno.getTutorEconomico().getDomicilio();
				
				//Asignar al domiclio del formulario el id del domiclio de la base de datos. para que teber el id correspondiente y los nuevos datos
				domicilioFormulario.setIdDomicilio(dommicilioBD.getIdDomicilio());
				
				//Asignar el id del tutor y el objeto del domicilio
				alumno.getTutorEconomico().setIdTutorEconomico(tutorDB.getIdTutorEconomico());
				alumno.getTutorEconomico().setDomicilio(domicilioFormulario);
				
				tutorDB = alumno.getTutorEconomico();
				
				//Guardara en la bd
				serviceDomicilio.guardarDomicilio(domicilioFormulario);
			}
			
			serviceTutorEconomico.guardarTutor(tutorDB);
			
			//Si no tiene un tutor relacionado, crear uno
		} else {
			
			//Obtener el tutor de la base de datos mediante el id dentro del alumno
			TutorEconomico t =  serviceTutorEconomico.obtenerPorId(alumnoSesion.getTutorEconomico().getIdTutorEconomico());
			System.out.println("Tutor de la base de datos: " + t.toString());
				
			//Verificar si el domicilio del tutor es igual al del alumno
			if(alumno.getTutorEconomico().getEsViviendaAlumno().equals(true)) {
				
				//Buscar el el domiclio por el id del alumno de la sesion para encontrar el domiclio asociado
				Domicilio domAlumno = serviceDomicilio.buscarPorId(alumnoSesion.getDomicilio().getIdDomicilio());
				
				//Crear objeto para guardar los datos del tutor del formulario
				TutorEconomico tutorEconomicoForm = alumno.getTutorEconomico();
				//Quitar los datos traidos del formulario
				tutorEconomicoForm.setDomicilio(null);
				
				//Asignar el objeto obtenido del domiclio del alumno
				tutorEconomicoForm.setDomicilio(domAlumno);
				
				//Actualizar el tutor del alumno del formulario
				alumno.setTutorEconomico(tutorEconomicoForm);
			}
			
			//Guardar el nuevo tutor 
			serviceTutorEconomico.guardarTutor(alumno.getTutorEconomico());
			//Actualizar el alumno de la base de datos
			serviceAlumno.guardarAlumno(alumnoSesion);
		}
		
		
		if(accion.equals("enviar")) {
			if(alumnoSesion.getEstadoFormularios() == null) {
				EstadoFormularios ef = new EstadoFormularios();
				ef.setFormDependienteEconomico(true);
				EstadoFormularios e = serviceEstadoFormularios.guardarEstadoFormularios(ef);
				alumnoSesion.setEstadoFormularios(e);
				serviceAlumno.guardarAlumno(alumnoSesion);
			} else {
				alumnoSesion.getEstadoFormularios().setFormDependienteEconomico(false);
				if(alumnoSesion.getTutorEconomico().getCatOcupacion() != null) {
					alumnoSesion.getTutorEconomico();
				}
				serviceAlumno.guardarAlumno(alumnoSesion);
			}
		}

		return "redirect:/alumno/menuSolicitar";
	}
	
	private void actualizarDomicilio(Alumno alumno) {
		
	}
	
	@PostMapping("/guardarGastos")
	public String guardarGastos(Authentication auth, Familia familia,  @RequestParam("archivoReciboLuz") MultipartFile multiPart, 
			@RequestParam("observaciones") String observacones) {
		if (!multiPart.isEmpty()) {
			System.out.print(multiPart);

		}
		
		System.out.println("Familia del formulario: " + familia.toString());
		System.out.println(observacones);
		
		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno a = obtenerAlumnoSesion(auth);
		
		if(a.getFamilia() != null) {
			
			familia.setIdFamilia(a.getFamilia().getIdFamilia());
			System.out.println("Antes del if" + a.getFamilia().getIdFamilia());
			
			
			if(a.getFamilia().getGastosFam() != null) {
				GastosFam gf = serviceGastosFam.buscarPorId(a.getFamilia().getGastosFam().getIdGastosFam());
				GastosFam gfEnviar = familia.getGastosFam();
				gfEnviar.setIdGastosFam(gf.getIdGastosFam());
				
				if(a.getFamilia().getGastosFam().getReciboLuz() != null) {
					System.out.println("Entra");
					ReciboLuz rb = serviceReciboLuz.buscarPorId(a.getFamilia().getGastosFam().getReciboLuz().getIdReciboLuz());
					ReciboLuz rbEnviar = familia.getGastosFam().getReciboLuz();
					rbEnviar.setIdReciboLuz(rb.getIdReciboLuz());
					System.out.println(rbEnviar.toString());
					serviceReciboLuz.guardarReciboLuz(rbEnviar);
				}
				serviceGastosFam.guardarGastoFam(gfEnviar);
			}			
			
			serviceFamilia.guardarFamilia(familia);
		} else {
			Familia f = serviceFamilia.guardarFamilia(familia);
			a.setFamilia(f);
			serviceAlumno.guardarAlumno(a);
		}
		
		a.setObservaciones(observacones);
		serviceAlumno.guardarAlumno(a);
		
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

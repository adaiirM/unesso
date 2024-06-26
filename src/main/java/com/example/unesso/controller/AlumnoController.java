package com.example.unesso.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.unesso.controller.services.MiFamiliaService;
import com.example.unesso.controller.services.DependienteEconomicoService;
import com.example.unesso.controller.services.MisDatosService;
import com.example.unesso.controller.services.MisGastosIngresosService;
import com.example.unesso.formsModel.FormMiFamilia;
import com.example.unesso.formsModel.FormMisDatos;
import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatMedios;
import com.example.unesso.model.CatMediosTransporte;
import com.example.unesso.model.CatParentesco;
import com.example.unesso.model.CatServicios;
import com.example.unesso.model.Familia;
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
	private DependienteEconomicoService serviceDependienteEconomicoService;
	
	@Autowired
	private MisGastosIngresosService serviceGastosIngresos;
	
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
		serviceGastosIngresos.getMisGastosIngresos(auth, model);
		return "alumno/formMisGastos";
	}
	
	@GetMapping("/formMiTutor")
	public String formularioTutor(Authentication auth, Model model) {
		serviceDependienteEconomicoService.getMiTutor(auth, model);
		return "alumno/formMiTutor";
	}
	
	@PostMapping("/guardarTutor")
	public String guardarDom(@RequestParam("accion") String accion, Authentication auth, Alumno alumno) {
		serviceDependienteEconomicoService.saveDependienteEconomico(auth, accion, alumno);
		return "redirect:/alumno/menuSolicitar";
	}
	
	@PostMapping("/guardarGastos")
	public String guardarGastos(@RequestParam("accion") String accion, Authentication auth, Familia familia,  @RequestParam("archivoReciboLuz") MultipartFile multiPart, 
								@RequestParam("observaciones") String observacones) {
		serviceGastosIngresos.saveMisGastosIngresos(accion, auth, familia, multiPart, observacones);
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

package com.example.unesso.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.unesso.controller.services.MisDatosService;
import com.example.unesso.formsModel.*;
import com.example.unesso.model.*;
import com.example.unesso.services.*;


@Controller
@RequestMapping(value="/alumno")
public class AlumnoController {
	
	//Ruta del servidor donde se guardaran los archivos
	@Value("${unessi.ruta.recibos}")
	private String rutaRecibos;
	
	@Value("${unessi.ruta.comprobantes}")
	private String rutaComprobantes;
	
	
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
	private CatMediosService catMediosService;
	
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
	private CatServiciosService catServiciosService;
	
	//Relizara las operaciones CRUD para el fromulario de misDatos
	@Autowired
	private MisDatosService misDatosService;
	

	
	@GetMapping("/misDatos")
    public String crear(Model model, Authentication authentication) {
        FormMisDatos formMisDatos = misDatosService.getMisDatos(authentication);
        model.addAttribute("formMisDatos", formMisDatos);
        return "formMisDatos";
    }

    @PostMapping("/saveMisDatos")
    public String saveDatosPersonales(FormMisDatos datos, Authentication authentication, RedirectAttributes attributes) {
        misDatosService.saveDatosPersonales(datos, authentication);
        
        return "menuSolicitarBeca";
    }

	
	
	
	
	//Se establecen modelos por defecto
	@ModelAttribute
	public void setGenericos(Model model) {		
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
	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	public List<Integer> arrayMediosTrasladoTolistIntegerConver( List<MediosTraslado> arrayMediosTraslado) {
		List<Integer> lista = new ArrayList<Integer>();
		CatMediosTransporte catMediosTransportes = new CatMediosTransporte();
		for (MediosTraslado medio : arrayMediosTraslado) {
			System.out.println("El medio es: " +medio);
		    	catMediosTransportes = medio.getCatMediosTransporte();
		    	lista.add(catMediosTransportes.getIdCatMediosTransporte());
		}	
		return lista;		
	}
	
	
	
	
}
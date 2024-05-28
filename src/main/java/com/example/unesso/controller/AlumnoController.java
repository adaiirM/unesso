package com.example.unesso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatOcupacion;
import com.example.unesso.model.CatParentesco;
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
import com.example.unesso.services.ITutorEconomicoService;
import com.example.unesso.services.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/alumno")
public class AlumnoController {
	
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
	
	@GetMapping("/menuSolicitar")
	public String menuSolicitar() {
		return "alumno/menuSolicitarBeca";
	}
	
	@GetMapping("/formMiFamilia")
	public String formularioFamilia(Model model) {
		model.addAttribute("escolaridades", serviceEscolaridad.listarEscolaridades());
		model.addAttribute("situacionViviendaFamiliar", serviceSituacionViviendaFamiliar.listarSituacionviviendafamiliar());
		model.addAttribute("tipoVivienda", serviceTipoVivienda.listarTipoVivienda());
		model.addAttribute("materialVivienda", serviceMaterialVivienda.listarMaterialVivienda());
		return "alumno/formMiFamilia";
	}
	
	@GetMapping("/formMisGastos")
	public String formularioMisGastos(Model model) {
		Familia f = new Familia();
		f.setIngresoFamiliar(new ArrayList<>());
		model.addAttribute("familia", f);
		return "alumno/formMisGastos";
	}
	
	@GetMapping("/formMiTutor")
	public String formularioTutor(Model model) {
		List<CatEstado> listEstado = serviceEstado.listEstados();
		List<CatOcupacion> listOcupacion = serviceOcupacion.listaOcupaciones();
		model.addAttribute("tutorEconomico", new TutorEconomico());
		model.addAttribute("estados", listEstado);
		model.addAttribute("ocupaciones", listOcupacion);
		return "alumno/formMiTutor";
	}
	
	@PostMapping("/guardarTutor")
	public String guardarDom(TutorEconomico tutor, BindingResult result) {
		/*if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			
			return "alumno/formTutor";
		}*/
		
		System.out.println(tutor.getCatOcupacion());
		
		//Recuperar datos de sesion para conocer el registro del alumno y asignarle el id de tutor al alumno
		
		serviceTutorEconomico.guardarTutor(tutor);
		return "alumno/formMiTutor";
	}
	
	@PostMapping("/guardarGastos")
	public String guardarGastos(Familia familia) {
		System.out.println(familia.toString());
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
}

package com.example.unesso.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatOcupacion;
import com.example.unesso.model.Domicilio;
import com.example.unesso.model.Trabajo;
import com.example.unesso.model.TutorEconomico;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.IAlumnoService;
import com.example.unesso.services.ICatEstadoService;
import com.example.unesso.services.ICatOcupacionService;
import com.example.unesso.services.IDomicilioService;
import com.example.unesso.services.IEstadoFormulariosService;
import com.example.unesso.services.IFamiliaService;
import com.example.unesso.services.IGastosFamService;
import com.example.unesso.services.IReciboLuzService;
import com.example.unesso.services.ITrabajoService;
import com.example.unesso.services.ITutorEconomicoService;
import com.example.unesso.services.IUsuarioService;

@Service
public class DependienteEconomicoService {
	
	@Autowired
	private ICatEstadoService serviceEstado;
	
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
	
	@Autowired 
	private ITrabajoService serviceTrabajo;
	
	public void getMiTutor(Authentication auth, Model model) {
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
	}
	
	public void saveDependienteEconomico(Authentication auth, String accion, Alumno alumno) {
		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno alumnoSesion = obtenerAlumnoSesion(auth);
		
		System.out.println("DATOS: " + alumno);
		
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


		if(accion.equals("enviar")) {
			alumnoSesion.getEstadoFormularios().setFormDependienteEconomico(true);
			serviceAlumno.guardarAlumno(alumnoSesion);
		} else {
			serviceAlumno.guardarAlumno(alumnoSesion);
		}
	}
	
	private Alumno obtenerAlumnoSesion(Authentication auth) {
		String correo = auth.getName();
		Usuario u = serviceUsuario.buscarPorCorreo(correo);
		return serviceAlumno.buscarPorUsuario(u);

	}
}

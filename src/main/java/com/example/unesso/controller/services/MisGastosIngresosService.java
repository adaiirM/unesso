package com.example.unesso.controller.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Familia;
import com.example.unesso.model.GastosFam;
import com.example.unesso.model.IngresoFamiliar;
import com.example.unesso.model.ReciboLuz;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.IAlumnoService;
import com.example.unesso.services.ICatOcupacionService;
import com.example.unesso.services.IDomicilioService;
import com.example.unesso.services.IEstadoFormulariosService;
import com.example.unesso.services.IFamiliaService;
import com.example.unesso.services.IGastosFamService;
import com.example.unesso.services.IIngresoFamiliarService;
import com.example.unesso.services.IReciboLuzService;
import com.example.unesso.services.ITutorEconomicoService;
import com.example.unesso.services.IUsuarioService;
import com.example.unesso.util.Utileria;


@Service
public class MisGastosIngresosService {
	
	@Value("${inesis.ruta.recibosLuz}")
	private String rutaRecibosLuz;
	
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
	private IIngresoFamiliarService serviceIngresoFam;
	
	public void getMisGastosIngresos(Authentication auth, Model model) {
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
	}
	
	public void saveMisGastosIngresos(String accion, Authentication auth, Familia familia, MultipartFile multiPart, String observacones) {

		//Recuperar datos de sesion para conocer el alumno de la sesión
		Alumno alumnoSesion = obtenerAlumnoSesion(auth);
		Familia familiaDB = new Familia();
		
		System.out.println("FAMILIA: " + familia.getIngresoFamiliar());
		List<IngresoFamiliar> ingresoFamiliarDB = new ArrayList<>();
		
		if(alumnoSesion.getFamilia().getIngresoFamiliar() != null) {
			ingresoFamiliarDB = alumnoSesion.getFamilia().getIngresoFamiliar();
		}
		
		if(alumnoSesion.getFamilia() != null) {
			//Recuperar datos de la base de datos de la familia
			familiaDB = serviceFamilia.obtenerFamiliaPorId(alumnoSesion.getFamilia().getIdFamilia());
		} 
			
		//Verificar que el alumno tenga un objeto familia
		if(familiaDB != null) {
			familiaDB.setNumPersonasAportan(familia.getNumPersonasAportan());
			
			System.out.println("Datos de ingreso DB: " + ingresoFamiliarDB);
			System.out.println("Datos de ingreso form: " + familia.getIngresoFamiliar());

			if(!alumnoSesion.getFamilia().getIngresoFamiliar().isEmpty()) {
				Boolean nuevasPersonasAportan = false;
				//Verificar si se ingresaron nuevas personas 
				for(IngresoFamiliar ingreso: familia.getIngresoFamiliar()) {
					if(ingreso.getIdIngresoFamiliar() == null) {
						nuevasPersonasAportan = true;
					}
				}
				
				System.out.println("Se ingresaron nuevas personas: " + nuevasPersonasAportan + ", " + familiaDB.getIdFamilia());

				
				//Si se agregraron nuevas personas
				if(nuevasPersonasAportan.equals(true)) {
					System.out.print("quee " + alumnoSesion.getFamilia().getIngresoFamiliar());
					for(IngresoFamiliar ingreso : alumnoSesion.getFamilia().getIngresoFamiliar()) {
						serviceIngresoFam.eliminar(ingreso.getIdIngresoFamiliar());
						alumnoSesion.getFamilia().getIngresoFamiliar().remove(ingreso);
					}
				} else {
					for(IngresoFamiliar ingreso : familia.getIngresoFamiliar()) {
						
						ingreso.setFamilia(familiaDB);
					}
					familiaDB.setIngresoFamiliar(familia.getIngresoFamiliar());
					serviceFamilia.guardarFamilia(familiaDB);
				}
			
				
			}else {
				if(familia.getIngresoFamiliar() != null) {
					for(IngresoFamiliar ingreso: familia.getIngresoFamiliar()) {
						ingreso.setFamilia(familiaDB);
					}
					
					familiaDB.setIngresoFamiliar(familia.getIngresoFamiliar());
				}
				
			}
			
			//Si el pago bimestral no contiene nada, guardar un 0
			if(familia.getGastosFam().getReciboLuz().getPagoBimestral().equals("")) {
				familia.getGastosFam().getReciboLuz().setPagoBimestral("0");
				familia.getGastosFam().getReciboLuz().setPagoPromedioMes("0");
			}
			
			if(alumnoSesion.getFamilia().getGastosFam() != null) {
				//Obtener datos de gastosFam de la base de datos
				GastosFam gastosFamDB = serviceGastosFam.buscarPorId(alumnoSesion.getFamilia().getGastosFam().getIdGastosFam());
				//Guaradar los datos del formulario
				GastosFam gastosFamForm = familia.getGastosFam();
				
				//Asignar el id de la base datos a los nuevos datos
				gastosFamForm.setIdGastosFam(gastosFamDB.getIdGastosFam());

				//Verificar el alumno ya tiene un recibo de luz registrado
				if(alumnoSesion.getFamilia().getGastosFam().getReciboLuz() != null) {
					//Obtener datos del reciboLuz de la base de datos
					ReciboLuz reciboLuzDB = serviceReciboLuz.buscarPorId(alumnoSesion.getFamilia().getGastosFam().getReciboLuz().getIdReciboLuz());
					//Guaradar los datos del formulario
					ReciboLuz reciboLuzForm = familia.getGastosFam().getReciboLuz();
					
					System.out.println("Datos del recibo de luz: " + reciboLuzForm.toString());
					
					if (!multiPart.isEmpty()) {
						String nombreArchivo = Utileria.guardarArchivo(multiPart, rutaRecibosLuz);
						if (nombreArchivo != null){ // La imagen si se subio
							// Procesamos la variable nombreImagen
							reciboLuzForm.setNombreArchivo(nombreArchivo);
							reciboLuzForm.setNombreOriginal(multiPart.getOriginalFilename());
						}
					}
					
					//Asignar el id de la base datos a los nuevos datos
					reciboLuzForm.setIdReciboLuz(reciboLuzDB.getIdReciboLuz());
					
					//Actualizar reciboLuz en la base de datos
					serviceReciboLuz.guardarReciboLuz(reciboLuzForm);
				} 
				//Actualizar gastosFam en la base de datos
				serviceGastosFam.guardarGastoFam(gastosFamForm);
			}else {
				familiaDB.setGastosFam(familia.getGastosFam());
				serviceFamilia.guardarFamilia(familiaDB);
			}
		}
		
		if(accion.equals("enviar")) {
			alumnoSesion.getEstadoFormularios().setFormMisGatos(true);
		}
		
	}
	
	private Alumno obtenerAlumnoSesion(Authentication auth) {
		String correo = auth.getName();
		Usuario u = serviceUsuario.buscarPorCorreo(correo);
		return serviceAlumno.buscarPorUsuario(u);

	}
}

package com.example.unesso.controller.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.unesso.formsModel.FormMisDatos;
import com.example.unesso.services.*;
import com.example.unesso.model.*;

@Service
public class MisDatosService {

    @Autowired
    private IAlumnoService alumnoService;
    @Autowired
    private IInfoViviendaService infoViviendaService;
    @Autowired
    private ITransporteService transporteService;
    @Autowired
    private IDomicilioService domicilioService;
    @Autowired
    private IMediosTrasladoService mediosTrasladoService;
    @Autowired
    private IUsuarioService usuarioService;

    public FormMisDatos getMisDatos(Authentication authentication) {
        
        FormMisDatos formMisDatos = new FormMisDatos();

		//Obtiene el correo del usuario que se logeo
		String username = authentication.getName();
		//System.out.println(username);
		
		//Se obtiene usuario pormedio del correo
		Usuario usuario = usuarioService.buscarPorCorreo(username);
		System.out.println(usuario);
		
		//Se obtiene alumno pormedio del atributo idUser de usuario
		Alumno alumno = alumnoService.buscarAlumnoPorIdUsuario(usuario.getIdUser());
		
		System.out.println("Este es el alumno" + alumno );
		System.out.println(alumno);
		formMisDatos.setAlumno(alumno);
		
		
		InfoVivienda infoVivienda = new InfoVivienda();
		Transporte transporte = new Transporte();
		List<MediosTraslado> arrayMediosTraslado = mediosTrasladoService.buscarPorIdAlumno(alumno.getIdAlumno());
		List<Integer> arrayIdMediosTraslado = new ArrayList<>();
		Domicilio domicilio = new Domicilio();
		CatSituacionVivienda catSituacionVivienda = new CatSituacionVivienda() ;
		
		if(alumno.getDomicilio() != null) {
			domicilio = alumno.getDomicilio();
			formMisDatos.setDomicilio(domicilio);
		}
		
		if(alumno.getInfoVivienda() != null) {
			infoVivienda = alumno.getInfoVivienda();
			System.out.print("Aqui se muestra: " + infoVivienda);
			formMisDatos.setInfoVivienda(infoVivienda);
		}
		
		if(alumno.getTransporte() != null) {
			transporte = alumno.getTransporte() ;
			formMisDatos.setTransporte(transporte);
		}
		
		if(!arrayMediosTraslado.isEmpty()) {
			arrayIdMediosTraslado = arrayMediosTrasladoTolistIntegerConver(arrayMediosTraslado);
			formMisDatos.setMediosTraslado(arrayIdMediosTraslado);
		}

        return formMisDatos;
    }

    public void saveDatosPersonales(FormMisDatos datos, Authentication authentication) {
    	//Se declaran los objetos para las operaciones CRUD
    			InfoVivienda infoVivienda = new InfoVivienda();
    			Transporte transporte = new Transporte();
    			Alumno alumno = new Alumno();
    			List<Integer> arrayIdMediosTraslado = new ArrayList<>();
    			List<MediosTraslado> arrayMediosTraslado = new ArrayList<>();
    			Domicilio domicilio = new Domicilio();
    			
    			//Se inicializan
    			alumno= datos.getAlumno();	
    			infoVivienda = datos.getInfoVivienda();
    			transporte= datos.getTransporte();
    			arrayIdMediosTraslado = datos.getMediosTraslado();
    			domicilio = datos.getDomicilio();
    			
    			// Registro/actualización de datos
    			
    			if(infoVivienda != null) {		
    				if(infoVivienda.getCatSituacionVivienda() != null) {
    					if(infoVivienda.getCatSituacionVivienda().getIdCatSituacionVivienda() == 3) {
    						InfoVivienda infoViviendaAux = new InfoVivienda();
    						if(infoVivienda.getIdInfoVivienda() != null) {
    							infoViviendaAux.setIdInfoVivienda(infoVivienda.getIdInfoVivienda());
    						}
    						infoViviendaAux.setCatSituacionVivienda(infoVivienda.getCatSituacionVivienda());
    						infoVivienda = infoViviendaAux;
    					}
    				}
    				
    				infoVivienda = infoViviendaService.guardar(infoVivienda);
    				alumno.setInfoVivienda(infoVivienda);
    			}
    			
    			if( transporte!= null ) {
    				if(alumno.getTieneVehiculo() != null ) {
    					if(alumno.getTieneVehiculo() != false) {
    						if(transporte.getCatTipoTransporte().getIdCatTipoTransporte() == null) {
    							Transporte t = new Transporte();
    							t.setAnio(transporte.getAnio());
    							t.setMarca(transporte.getMarca());
    							t.setModelo(transporte.getModelo());
    							if(transporte.getIdTransporte() != null) {
    								t.setIdTransporte(transporte.getIdTransporte());
    							}
    							transporte = t;
    						}
    						transporte = transporteService.guardar(transporte);
    						alumno.setTransporte(transporte);
    					}
    				}		
    			}
    			
    			//Guardar Datos del domicilio
    			if(domicilio != null) {
    				
    				if(domicilio.getCatLocalidad().getIdCatLocalidad() == null) {
    					Domicilio dom = new Domicilio();
    					Integer id = domicilio.getIdDomicilio() != null ? domicilio.getIdDomicilio() : null;
    					if(id != null) {
    						dom.setIdDomicilio(id);
    					}
    					dom.setCalle(domicilio.getCalle());
    					dom.setColoniaBarrio(domicilio.getColoniaBarrio());
    					dom.setNumero(domicilio.getNumero());
    					domicilio = dom;
    				}
    				domicilio = domicilioService.guardar(domicilio);
    				alumno.setDomicilio(domicilio);
    			}
    			
    			
    			if(datos.getAlumno() != null) {	
    				
    				alumno = alumnoService.guardar(alumno);
    			}
    			
    			
    			
    			List <MediosTraslado> mediosTraslado = mediosTrasladoService.buscarPorIdAlumno(alumno.getIdAlumno());
    			
    			if(!arrayIdMediosTraslado.isEmpty()) {
    				arrayMediosTraslado = listIntegerConverArrayMediosTraslado(arrayIdMediosTraslado, alumno);
    				
    				if(mediosTraslado != null ) {
    					List<MediosTraslado> elementosParaEliminar = new ArrayList<>();
    					List<MediosTraslado> elementosParaAgregar = new ArrayList<>();

    					for (MediosTraslado medioTraslado : mediosTraslado) {
    					    boolean encontrado = false;
    					
    					    for (MediosTraslado medioTrasladoLista : arrayMediosTraslado) {
    					        if (medioTraslado.getIdMediosTraslado() == medioTrasladoLista.getIdMediosTraslado()) {
    					            encontrado = true;
    					            break;
    					        }
    					    }

    					    if (!encontrado) {
    					    	mediosTrasladoService.eliminar(medioTraslado);
    					    }			    
    					    
    					}
    					
    					for (MediosTraslado medioTrasladoLista : arrayMediosTraslado) {
    					    boolean encontrado = false;
    					
    					    for (MediosTraslado medioTraslado : mediosTraslado) {
    					        if ( medioTrasladoLista.getIdMediosTraslado() == medioTraslado.getIdMediosTraslado()) {
    					            encontrado = true;
    					            break;
    					        }
    					    }

    					    if (!encontrado) {
    					        elementosParaAgregar.add(medioTrasladoLista);
    					        medioTrasladoLista.setAlumno(alumno);
    					        mediosTrasladoService.guardar(medioTrasladoLista);
    					    }			    
    					    
    					}
    					
    				}else {
    					mediosTrasladoService.guardarTodos(arrayMediosTraslado);
    				}
    				
    			}else if(arrayIdMediosTraslado.isEmpty() && !mediosTraslado.isEmpty() ) {
    				mediosTrasladoService.eliminarTodos(mediosTraslado);
    			}
    }

  





    public List<MediosTraslado> listIntegerConverArrayMediosTraslado( List<Integer> arrayIdMediosTraslado,Alumno alumno) {
		List<MediosTraslado> arrayMediosTraslado = new ArrayList<MediosTraslado>();

	    for (Integer medio : arrayIdMediosTraslado) {
	        MediosTraslado medioTraslado = new MediosTraslado(); // Crear una nueva instancia en cada iteración
	        CatMediosTransporte catMediosTransporte = new CatMediosTransporte();
	        catMediosTransporte.setIdCatMediosTransporte(medio);
	        medioTraslado.setCatMediosTransporte(catMediosTransporte);
	        medioTraslado.setAlumno(alumno);
	        arrayMediosTraslado.add(medioTraslado);
	    }
	    return arrayMediosTraslado;	
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


    @InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
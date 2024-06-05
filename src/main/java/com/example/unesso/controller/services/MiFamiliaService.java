package com.example.unesso.controller.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.unesso.formsModel.FormMiFamilia;
import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatMedios;
import com.example.unesso.model.CatServicios;
import com.example.unesso.model.Domicilio;
import com.example.unesso.model.Familia;
import com.example.unesso.model.Hermanos;
import com.example.unesso.model.InfoFamilia;
import com.example.unesso.model.MediosEstudios;
import com.example.unesso.model.ServiciosVivienda;
import com.example.unesso.model.TutorEconomico;
import com.example.unesso.model.Usuario;
import com.example.unesso.model.ViviendaFamiliar;
import com.example.unesso.services.*;
import com.example.unesso.util.ArchiveUtils;

@Service
public class MiFamiliaService {
	@Value("${unessi.ruta.comprobantes}")
	private String rutaComprobantes;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IAlumnoService alumnoService;
	
	
	@Autowired
	private IDomicilioService domicilioService ;
	
	@Autowired
	private IMediosEstudiosService mediosEstudiosService ;
	
	@Autowired
	private IInfoFamiliaService infoFamiliaService ;
	
	@Autowired
	private IHermanosService hermanosService ;
	
	@Autowired
	private IFamiliaService familiaService;
	
	@Autowired
	private IViviendaFamiliarService viviendaFamiliarService;
	
	@Autowired
	private IServiciosViviendaService serviciosViviendaService;
	
	
	public FormMiFamilia getMiFamilia(Authentication authentication) {
        FormMiFamilia formMiFamilia = new FormMiFamilia();
		
		//Obtiene el correo del usuario que se logeo
		String username = authentication.getName();
		//System.out.println(username);
		
		//Se obtiene usuario pormedio del correo
		Usuario usuario = usuarioService.buscarPorCorreo(username);
		System.out.println(usuario);
		
		//Se obtiene alumno pormedio del atributo idUser de usuario
		Alumno alumno = alumnoService.buscarAlumnoPorIdUsuario(usuario.getIdUser());
		
		System.out.println("Este es el alumno" + alumno );
		formMiFamilia.setAlumno(alumno);
		
		TutorEconomico tutor = alumno.getTutor();
		formMiFamilia.setTutor(tutor);
		
		Familia familia = alumno.getFamilia() != null ? alumno.getFamilia() : new Familia();
		System.out.println("la familia es: " + familia);
		Domicilio domicilio = familia.getDomicilio() != null ? familia.getDomicilio() : new Domicilio();
		InfoFamilia infoFamilia = familia.getInfoFamilia() != null ? familia.getInfoFamilia() : new InfoFamilia();
		ViviendaFamiliar viviendaFamilia = familia.getViviendaFamilia() != null ? familia.getViviendaFamilia() : new ViviendaFamiliar();	
		List<Hermanos> listHermanos = familia.getHermanos() != null ? familia.getHermanos() : new ArrayList<>();
		List<MediosEstudios> medios = alumno.getMediosEstudios();
		List<ServiciosVivienda> serviciosViviendaActuales = serviciosViviendaService.buscarServiciosViviendaPorIdViviendaFamiiar(viviendaFamilia.getIdViviendaFamilia());

		
		List<Integer> idMediosEstudios = medios != null
				? arrayMediosEstudiosTrasladoToArrayInteger( medios)
				: new ArrayList<>();
		
		List<Integer> idServiciosVivienda = arrayServiciosViviendaToArrayInteger(serviciosViviendaActuales);
		
		if( !idServiciosVivienda.isEmpty()) {
			formMiFamilia.setServiciosVivienda(idServiciosVivienda);
		}
		
		if(!idMediosEstudios.isEmpty()) {
			formMiFamilia.setMediosEstudios(idMediosEstudios);
		}
		
		if(familia != null) {
			formMiFamilia.setFamilia(familia);
		}
		
		if(domicilio != null) {
			formMiFamilia.setDomicilio(domicilio);
		}
		
		if(infoFamilia != null) {
			formMiFamilia.setInfoFamilia(infoFamilia);
		}
		
		if(viviendaFamilia !=  null) {
			formMiFamilia.setViviendaFamiliar(viviendaFamilia);
		}
		
		if(!listHermanos.isEmpty()) {
			int contador = listHermanos.size();
			for(int i = 1 ; i <= 3 ; i++ ) {
				if(i > contador) {
					listHermanos.add(new Hermanos());
				}
			}
			
			formMiFamilia.setHermanos(listHermanos);
		}else {
			for (int i = 1; i <= 3; i++) {
		    	Hermanos hermano = new Hermanos();
		    	System.out.println(hermano);
		    	formMiFamilia.addHermano(hermano);
		    }
		}
				
		return formMiFamilia;
		
	}
	
	
	public void saveMiFamilia(FormMiFamilia datos, Authentication authentication,MultipartFile[] files) {
		//Obtiene el correo del usuario que se logeo
		String username = authentication.getName();
		//System.out.println(username);
		
		//Se obtiene usuario pormedio del correo
		Usuario usuario = usuarioService.buscarPorCorreo(username);
		System.out.println(usuario);
		
		//Se obtiene alumno pormedio del atributo idUser de usuario
		Alumno alumno = alumnoService.buscarAlumnoPorIdUsuario(usuario.getIdUser());
		
		Domicilio domicilio = datos.getDomicilio();
		Familia familia = datos.getFamilia();
		System.out.println("la familia es: " + familia);
		InfoFamilia infoFamilia = datos.getInfoFamilia();
		ViviendaFamiliar viviendaFamilia = datos.getViviendaFamiliar();	
		List<Hermanos> listHermanos = new ArrayList<>();
		List<Integer> mediosEstudiosId = datos.getMediosEstudios();
		List<Integer> serviciosViviendaId = datos.getServiciosVivienda();
		
		for (Integer i : mediosEstudiosId) {
			System.out.println("El id es: " + i);
		}
	
		if (infoFamilia == null) {
		    infoFamilia = new InfoFamilia();
		} else {
			InfoFamilia infoFamDatosParaInsetar = new InfoFamilia();
			
			
			//Verigicar si es un dato a editar o insertar
			if( infoFamilia.getIdInfoFamilia() != null ) {
				infoFamDatosParaInsetar.setIdInfoFamilia(infoFamilia.getIdInfoFamilia());
			}
			
			
		    // Verificar y guardar escolaridad del padre si es transitorio
		    if ( infoFamilia.getEscolaridadPadre().getIdCatEscolaridad() != null ) {
		    	infoFamDatosParaInsetar.setEscolaridadPadre(infoFamilia.getEscolaridadPadre());
		    }

		    // Verificar y guardar escolaridad de la madre si es transitorio
		    if ( infoFamilia.getEscolaridadMadre().getIdCatEscolaridad()!= null) {
		    	infoFamDatosParaInsetar.setEscolaridadMadre(infoFamilia.getEscolaridadMadre());
		    }

		    // Verificar y asignar los campos de hermanos
		    if (infoFamilia.getHermanosDejoEstudio() != null || infoFamilia.getHermanosEstudiando() != null
		            || infoFamilia.getHermanosLicenciatura() != null || infoFamilia.getNumHermanos() != null) {
		        
		    	infoFamDatosParaInsetar.setHermanosDejoEstudio(infoFamilia.getHermanosDejoEstudio());
		    	infoFamDatosParaInsetar.setHermanosEstudiando(infoFamilia.getHermanosEstudiando());
		    	infoFamDatosParaInsetar.setHermanosLicenciatura(infoFamilia.getHermanosLicenciatura());
		    	infoFamDatosParaInsetar.setNumHermanos(infoFamilia.getNumHermanos());

		        
		    }
		    System.out.println("infoFamDatosParaInsertar es: " + infoFamDatosParaInsetar  );
		    
		    infoFamilia = infoFamiliaService.guardar(infoFamDatosParaInsetar);
		}
		
	
		
		
		
		if (viviendaFamilia == null) {
		    viviendaFamilia = new ViviendaFamiliar();
		} else {
		    ViviendaFamiliar viviendaFamDatosParaInsertar = new ViviendaFamiliar();
		    
		    if(viviendaFamilia.getIdViviendaFamilia() != null) {
		    	viviendaFamDatosParaInsertar.setIdViviendaFamilia(viviendaFamilia.getIdViviendaFamilia());
		    }

		    // Verificar y guardar el tipo de vivienda si es transitorio
		    if ( viviendaFamilia.getCatTipoVivienda().getIdCatTipoVivienda() != null) {
		        viviendaFamDatosParaInsertar.setCatTipoVivienda(viviendaFamilia.getCatTipoVivienda());
		    }

		    // Verificar y guardar el material de vivienda si es transitorio
		    if ( viviendaFamilia.getCatMaterialVivienda().getIdCatMaterialVivienda() != null) {
		        viviendaFamDatosParaInsertar.setCatMaterialVivienda(viviendaFamilia.getCatMaterialVivienda());
		    }

		    // Verificar y guardar la situación de vivienda familiar si es transitorio
		    if (viviendaFamilia.getCatSituacionViviendaFamiliar().getIdCatSituacionViviendaFamiliar() != null) {
		        viviendaFamDatosParaInsertar.setCatSituacionViviendaFamiliar(viviendaFamilia.getCatSituacionViviendaFamiliar());
		    }

		    // Verificar y asignar el número de personas que habitan
		    if (viviendaFamilia.getNumPersonasHabitan() != null) {
		        viviendaFamDatosParaInsertar.setNumPersonasHabitan(viviendaFamilia.getNumPersonasHabitan());
		    }
		    System.out.println("viviendaFamDatosParaInsertar es: " + viviendaFamDatosParaInsertar  );

		    viviendaFamilia=viviendaFamiliarService.guardar(viviendaFamDatosParaInsertar);
		}
		
	

		registrarMediosEstudios ( mediosEstudiosId,  alumno);
		

		List<ServiciosVivienda> serviciosViviendaActuales = serviciosViviendaService.buscarServiciosViviendaPorIdViviendaFamiiar(viviendaFamilia.getIdViviendaFamilia());

		
	    if (!serviciosViviendaId.isEmpty()) {
	        List<ServiciosVivienda> nuevosServiciosVivienda= listIntegerConvertToArrayServiciosVivienda(serviciosViviendaId, viviendaFamilia);
	        boolean encontrado = false;
	        if (nuevosServiciosVivienda != null ) {
	        	
	            for (ServiciosVivienda servicioActual : serviciosViviendaActuales) {
	                 encontrado = false;
	                
	                for (ServiciosVivienda nuevoServicioVivienda : nuevosServiciosVivienda) {
	                    
	                	if (servicioActual.getCatServicios().getIdCatServicios().equals(nuevoServicioVivienda.getCatServicios().getIdCatServicios())) {
	                        encontrado = true;
	                        break;
	                    }
	                }

	                if (!encontrado) {
	                	serviciosViviendaService.eliminar(servicioActual);
	                }
	            }
	            serviciosViviendaActuales = serviciosViviendaService.buscarServiciosViviendaPorIdViviendaFamiiar(viviendaFamilia.getIdViviendaFamilia());
	            
	            for (ServiciosVivienda nuevoServicioVivienda : nuevosServiciosVivienda) {
	            	encontrado = false;
	            	for (ServiciosVivienda servicioActual : serviciosViviendaActuales) {
	                    if (nuevoServicioVivienda.getCatServicios().getIdCatServicios().equals(servicioActual.getCatServicios().getIdCatServicios())) {
	                        encontrado = true;
	                        break;
	                    }
	                }

	                if (!encontrado) {
	                	nuevoServicioVivienda.setViviendaFamilia(viviendaFamilia);
	                	serviciosViviendaService.guardar(nuevoServicioVivienda);
	                }
	            }
	        } else {
	        	serviciosViviendaService.guardarTodos(nuevosServiciosVivienda);
	        }
	    } else if (serviciosViviendaId == null || serviciosViviendaId.isEmpty()) {
	        if (serviciosViviendaActuales != null && !serviciosViviendaActuales.isEmpty()) {
	        	serviciosViviendaService.eliminarTodos(serviciosViviendaActuales);
	        }
	    }
		
	    
		
		
		if (domicilio == null) {
		    domicilio = new Domicilio();
		} else {
		    Domicilio domicilioDatosParaInsertar = new Domicilio();
		    
		    if( domicilio.getIdDomicilio() != null ) {
		    	domicilioDatosParaInsertar.setIdDomicilio(domicilio.getIdDomicilio());
		    }

		    // Verificar y guardar la localidad si es transitorio
		    if (domicilio.getCatLocalidad().getIdCatLocalidad() != null) {
		        domicilioDatosParaInsertar.setCatLocalidad(domicilio.getCatLocalidad());
		    }

		    // Verificar y asignar los campos de domicilio
		    if (domicilio.getColoniaBarrio() != null || domicilio.getCalle() != null 
		    		|| domicilio.getNumero() != null ) {
		        domicilioDatosParaInsertar.setColoniaBarrio(domicilio.getColoniaBarrio());
		        domicilioDatosParaInsertar.setCalle(domicilio.getCalle());
		        domicilioDatosParaInsertar.setNumero(domicilio.getNumero());
		    }
		    
		    domicilio = domicilioService.guardar(domicilioDatosParaInsertar);
		}		
		
		
		
		if(familia == null) {
			familia = new Familia();
		}
		System.out.println(familia);
		familia.setInfoFamilia(infoFamilia);
		familia.setDomicilio(domicilio);
		familia.setViviendaFamilia(viviendaFamilia);
		familia = familiaService.guardar(familia);
		
		
		for(int i = 0; i < datos.getHermanos().size(); i++) {
			Hermanos hermano = datos.getHermanos().get(i);
			System.out.println(hermano.getNombreEscuela());
			MultipartFile file = files[i];
			if( hermano.getIdHermanos() != null ) {
				if( hermano.getNombreEscuela().isEmpty() && hermano.getNombreHermanos().isEmpty() && hermano.getGrado().isEmpty()
						&& hermano.getNombreTipoComprobante().isEmpty() ) {
					hermanosService.eliminar(hermano);
				}
			}
			
			if( !hermano.getNombreEscuela().isEmpty() || !hermano.getNombreHermanos().isEmpty() || !hermano.getGrado().isEmpty()
					|| !hermano.getNombreTipoComprobante().isEmpty() ) {
				
				hermano.setFamilia(familia);
				
				if ( !file.isEmpty() && hermano.getNombreTipoComprobante()!= null ) {
	                String nombreArchivo = ArchiveUtils.guardarComprobanteEstudio(file, rutaComprobantes);
	                String nombreArchivoOriginal = file.getOriginalFilename();
	                if ( nombreArchivo != null ) {
	                	System.out.println(nombreArchivo);
	                	hermano.setNombreArchivoOriginal(nombreArchivoOriginal);
	                	hermano.setRutaArchivoComprobante(nombreArchivo); // Supongamos que tienes un campo para almacenar el nombre del archivo en Hermanos
	                }
	            }		
				Hermanos hermanoSave = hermanosService.guardar(hermano);
				listHermanos.add(hermanoSave);
				System.out.println(hermanoSave);
			}else {
				System.out.println("No insertado");
			}
		}
		if(alumnoDatos.getCatInternet().getIdCatInternet() != null) {
			alumno.setCatInternet(alumnoDatos.getCatInternet());
		}
		alumno.setFamilia(familia);
		alumnoService.guardar(alumno);
	}
	
	

	private List<MediosEstudios> listIntegerConvertArrayMediosEstudios( List<Integer> arrayIdMediosTraslado,Alumno alumno) {
		List<MediosEstudios> arrayMediosTraslado = new ArrayList<MediosEstudios>();
	 
	    for (Integer medio : arrayIdMediosTraslado) {
	    	MediosEstudios medioTraslado = new MediosEstudios(); // Crear una nueva instancia en cada iteración
	    	CatMedios catMediosTransporte = new CatMedios();
	        catMediosTransporte.setIdCatMedios(medio);
	        medioTraslado.setCatMedios(catMediosTransporte);
	        medioTraslado.setAlumno(alumno);
	        System.out.println("El medio es: " + medioTraslado);
	        arrayMediosTraslado.add(medioTraslado);
	    }
	    return arrayMediosTraslado;	
	}

	private List<Integer> arrayMediosEstudiosTrasladoToArrayInteger( List<MediosEstudios> arrayMediosTraslado) {
		List<Integer> lista = new ArrayList<Integer>();
		for (MediosEstudios medio : arrayMediosTraslado) {
		    	lista.add(medio.getCatMedios().getIdCatMedios());
		}	
		return lista;		
	}
	private List<ServiciosVivienda> listIntegerConvertToArrayServiciosVivienda( List<Integer> arrayIdCatServiciosVivienda,ViviendaFamiliar alumno) {
		List<ServiciosVivienda> arrayServiciosVivienda = new ArrayList<>();
	 
	    for (Integer medio : arrayIdCatServiciosVivienda) {
	    	System.out.println("El id es: " + medio);
	    	ServiciosVivienda servicios = new ServiciosVivienda(); // Crear una nueva instancia en cada iteración
	    	CatServicios catServicios = new CatServicios();
	    	catServicios.setIdCatServicios(medio);
	    	servicios.setCatServicios(catServicios);
	    	servicios.setViviendaFamilia(alumno);
	    	arrayServiciosVivienda.add(servicios);
	    }
	    return arrayServiciosVivienda;	
	}
	
	private List<Integer> arrayServiciosViviendaToArrayInteger( List<ServiciosVivienda> arrayServiciosVivienda) {
		List<Integer> lista = new ArrayList<Integer>();
		for (ServiciosVivienda medio : arrayServiciosVivienda) {
		    	lista.add(medio.getCatServicios().getIdCatServicios());
		}	
		return lista;		
	}
	
	public void registrarMediosEstudios (List<Integer> mediosEstudiosId, Alumno alumno){

		List<MediosEstudios> mediosEstudiosActuales = mediosEstudiosService.buscarPotIdAlumno(alumno.getIdAlumno());

	    if (!mediosEstudiosId.isEmpty()) {
	        List<MediosEstudios> nuevosMediosEstudios = listIntegerConvertArrayMediosEstudios(mediosEstudiosId, alumno);
	        boolean encontrado = false;
	        if (mediosEstudiosActuales != null ) {
	            for (MediosEstudios medioEstudioActual : mediosEstudiosActuales) {
	                 encontrado = false;
	                
	                for (MediosEstudios nuevoMedioEstudio : nuevosMediosEstudios) {
	                    if (medioEstudioActual.getIdMediosEstudio().equals(nuevoMedioEstudio.getIdMediosEstudio())) {
	                        encontrado = true;
	                        
	                        break;
	                    }
	                }

	                if (!encontrado) {
	                    mediosEstudiosService.eliminar(medioEstudioActual);
	                }
	            }
	            mediosEstudiosActuales = mediosEstudiosService.buscarPotIdAlumno(alumno.getIdAlumno());
	            for (MediosEstudios nuevoMedioEstudio : nuevosMediosEstudios) {
	            	for (MediosEstudios medioEstudioActual : mediosEstudiosActuales) {
	                    if (nuevoMedioEstudio.getIdMediosEstudio().equals(medioEstudioActual.getIdMediosEstudio())) {
	                        encontrado = true;
	                        break;
	                    }
	                }

	                if (!encontrado) {
	                    nuevoMedioEstudio.setAlumno(alumno);
	                    mediosEstudiosService.guardar(nuevoMedioEstudio);
	                }
	            }
	        } else {
	            mediosEstudiosService.guardarTodos(nuevosMediosEstudios);
	        }
	    } else if (mediosEstudiosId == null || mediosEstudiosId.isEmpty()) {
	        if (mediosEstudiosActuales != null && !mediosEstudiosActuales.isEmpty()) {
	            mediosEstudiosService.eliminarTodos(mediosEstudiosActuales);
	        }
	    }
		
	}
	
	

}

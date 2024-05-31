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
        String username = authentication.getName();
        Usuario usuario = usuarioService.buscarPorCorreo(username);
        Alumno alumno = alumnoService.buscarAlumnoPorIdUsuario(usuario.getIdUser());

        FormMisDatos formMisDatos = new FormMisDatos();
        formMisDatos.setAlumno(alumno);

        if (alumno.getDomicilio() != null) {
            formMisDatos.setDomicilio(alumno.getDomicilio());
        }

        if (alumno.getInfoVivienda() != null) {
            formMisDatos.setInfoVivienda(alumno.getInfoVivienda());
        }

        if (alumno.getTransporte() != null) {
            formMisDatos.setTransporte(alumno.getTransporte());
        }

        List<MediosTraslado> arrayMediosTraslado = mediosTrasladoService.buscarPorIdAlumno(alumno.getIdAlumno());
        if (!arrayMediosTraslado.isEmpty()) {
            List<Integer> arrayIdMediosTraslado = arrayMediosTrasladoTolistIntegerConver(arrayMediosTraslado);
            formMisDatos.setMediosTraslado(arrayIdMediosTraslado);
        }

        return formMisDatos;
    }

    public void saveDatosPersonales(FormMisDatos datos, Authentication authentication) {
        Alumno alumno = datos.getAlumno();
        InfoVivienda infoVivienda = datos.getInfoVivienda();
        Transporte transporte = datos.getTransporte();
        List<Integer> arrayIdMediosTraslado = datos.getMediosTraslado();
        Domicilio domicilio = datos.getDomicilio();

        if (infoVivienda != null) {
            infoVivienda = handleInfoVivienda(infoVivienda);
            infoVivienda = infoViviendaService.guardar(infoVivienda);
            alumno.setInfoVivienda(infoVivienda);
        }

        if (transporte != null && Boolean.TRUE.equals(alumno.getTieneVehiculo())) {
            transporte = handleTransporte(transporte);
            transporte = transporteService.guardar(transporte);
            alumno.setTransporte(transporte);
        }

        if (domicilio != null) {
            domicilio = handleDomicilio(domicilio);
            domicilio = domicilioService.guardar(domicilio);
            alumno.setDomicilio(domicilio);
        }

        if (alumno != null) {
            alumno = alumnoService.guardar(alumno);
        }

        handleMediosTraslado(alumno, arrayIdMediosTraslado);
    }

    private InfoVivienda handleInfoVivienda(InfoVivienda infoVivienda) {
        if (infoVivienda.getCatSituacionVivienda() != null && infoVivienda.getCatSituacionVivienda().getIdCatSituacionVivienda() == 3) {
            InfoVivienda infoViviendaAux = new InfoVivienda();
            if (infoVivienda.getIdInfoVivienda() != null) {
                infoViviendaAux.setIdInfoVivienda(infoVivienda.getIdInfoVivienda());
            }
            infoViviendaAux.setCatSituacionVivienda(infoVivienda.getCatSituacionVivienda());
            return infoViviendaAux;
        }
        return infoVivienda;
    }

    private Transporte handleTransporte(Transporte transporte) {
        if (transporte.getCatTipoTransporte().getIdCatTipoTransporte() == null) {
            Transporte t = new Transporte();
            t.setAnio(transporte.getAnio());
            t.setMarca(transporte.getMarca());
            t.setModelo(transporte.getModelo());
            if (transporte.getIdTransporte() != null) {
                t.setIdTransporte(transporte.getIdTransporte());
            }
            return t;
        }
        return transporte;
    }

    private Domicilio handleDomicilio(Domicilio domicilio) {
        if (domicilio.getCatLocalidad().getIdCatLocalidad() == null) {
            Domicilio dom = new Domicilio();
            if (domicilio.getIdDomicilio() != null) {
                dom.setIdDomicilio(domicilio.getIdDomicilio());
            }
            dom.setCalle(domicilio.getCalle());
            dom.setColoniaBarrio(domicilio.getColoniaBarrio());
            dom.setNumero(domicilio.getNumero());
            return dom;
        }
        return domicilio;
    }

    private void handleMediosTraslado(Alumno alumno, List<Integer> arrayIdMediosTraslado) {
        List<MediosTraslado> mediosTraslado = mediosTrasladoService.buscarPorIdAlumno(alumno.getIdAlumno());

        if (!arrayIdMediosTraslado.isEmpty()) {
            List<MediosTraslado> arrayMediosTraslado = listIntegerConverArrayMediosTraslado(arrayIdMediosTraslado, alumno);

            if (mediosTraslado != null) {
                for (MediosTraslado medioTraslado : mediosTraslado) {
                    if (arrayMediosTraslado.stream().noneMatch(m -> m.getIdMediosTraslado().equals(medioTraslado.getIdMediosTraslado()))) {
                        mediosTrasladoService.eliminar(medioTraslado);
                    }
                }

                for (MediosTraslado medioTrasladoLista : arrayMediosTraslado) {
                    if (mediosTraslado.stream().noneMatch(m -> m.getIdMediosTraslado().equals(medioTrasladoLista.getIdMediosTraslado()))) {
                        medioTrasladoLista.setAlumno(alumno);
                        mediosTrasladoService.guardar(medioTrasladoLista);
                    }
                }
            } else {
                mediosTrasladoService.guardarTodos(arrayMediosTraslado);
            }
        } else if (!mediosTraslado.isEmpty()) {
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

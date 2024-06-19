package com.example.unesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.CatMunicipio;
import com.example.unesso.model.Domicilio;
import com.example.unesso.model.Usuario;
import com.example.unesso.services.ICatEstadoService;
import com.example.unesso.services.ICatLocalidadService;
import com.example.unesso.services.ICatMunicipioService;
import com.example.unesso.services.IDomicilioService;

@Controller
@RequestMapping(value="/domicilio")
public class DomicilioController {
	
	@Autowired
	private ICatEstadoService serviceEstado;
	
	@Autowired
	private ICatMunicipioService serviceMunicipio;
	
	@Autowired
	private ICatLocalidadService serviceLocalidad;

	@Autowired
	private IDomicilioService serviceDomicilio;
	
	
	@GetMapping("/obtenerMunicipiosPorEstado")
	@ResponseBody
	public List<CatMunicipio> obtenerMunicipiosPorEstado(@RequestParam("estadoId") Integer estadoId) {
		CatEstado estado = serviceEstado.estadoPorId(estadoId);
		return serviceMunicipio.listaMunicipiosPorEstado(estado);
	}
	 
	 
	@GetMapping("/obtenerLocalidadesPorMunicipio")
	@ResponseBody
	public List<CatLocalidad> obtenerLocalidadesPorMunicipio(@RequestParam("municipioId") Integer municipioId) {
		CatMunicipio municipio = serviceMunicipio.municipioPorId(municipioId);
		return serviceLocalidad.listaLocalidadesPorMunicipio(municipio);
	}
	 
	@GetMapping("/obtenerCodigoPostalPorLocalidad")
	@ResponseBody
	public CatCodigoPostal obtenerCodigoPostalPorLocalidad(@RequestParam("localidadId") Integer localidadId) {
		CatLocalidad localidad = serviceLocalidad.buscarPorId(localidadId);
		System.out.println(localidad.getCatCodigoPostal());
		return localidad.getCatCodigoPostal();
	}
	
	@PostMapping("/guardarDomicilio")
	public String guardarDomicilio(Domicilio domiclio) {
		System.out.println(domiclio.toString());
		return "menuAlumno";
	}
	
	
}

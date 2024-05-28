package com.example.unesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.CatMunicipio;
import com.example.unesso.services.ICatCodigoPostalService;
import com.example.unesso.services.ICatEstadoService;
import com.example.unesso.services.ICatLocalidadService;
import com.example.unesso.services.ICatMunicipioService;

@Controller
@RequestMapping(value="/direccion")
public class DireccionController {
	@Autowired
	private ICatMunicipioService catMunicipioService;
	
	@Autowired
	private ICatLocalidadService catLocalidadService;
	
	@Autowired
	private ICatCodigoPostalService catCodigoPostalService;
	
	@Autowired
	private ICatEstadoService catEstadoService;
	
	
	/**
	 * Obtiene los municipios de un estado
	 * @param estadoId ide del estado
	 * @return List<CatMunicipio> con los municipios de un estado
	 */
	@GetMapping("/municipiosById/{estadoId}")
    @ResponseBody // Add this annotation
    public List<CatMunicipio> getMunicipiosById(@PathVariable Integer estadoId) {
        return catMunicipioService.municipiosPorIdCatEstado(estadoId);
    }
	
	/**
	 * Obtiene las localidades de un municipio
	 * @param municipioId es el id del municipio
	 * @return List<CatLocalidad> lista de las localidades del municipio
	 */
	@GetMapping("/localidadesById/{municipioId}")
    @ResponseBody
    public List<CatLocalidad> getLocalidadesById(@PathVariable Integer municipioId) {
		for(CatLocalidad cat: catLocalidadService.localidadesPorIdCatMunicipio(municipioId) ) {
			System.out.println(cat);
		}
        return  catLocalidadService.localidadesPorIdCatMunicipio(municipioId);
    }
	
	/**
	 * Obtiene el código postal de una localidad
	 * @param localidadId es el id de la localidad
	 * @return CatCodigoPostal
	 */
	@GetMapping("/codigoPostalById/{localidadId}")
    @ResponseBody
    public CatCodigoPostal getCodigoPostalById(@PathVariable Integer localidadId) {
		//System.out.println(catCodigoPostalService.cpPorLocalidad(localidadId).getNumeroCodigoPostal());
		
        return  catCodigoPostalService.cpPorLocalidad(localidadId);
    }
	
	
	/**
	 * Recupera el municipio en base al id de una localidad
	 * @param localidadId
	 * @return CatMunicipio
	 */
	@GetMapping("/municipioByIdLocalidad/{localidadId}")
    @ResponseBody
    public CatMunicipio getMunicipioByIdLocalidad(@PathVariable Integer localidadId) {
		System.out.println("idMuni"+catLocalidadService.municipioPorIdCatLocalidad(localidadId) );
        return  catLocalidadService.municipioPorIdCatLocalidad(localidadId);
    }
	
	
	/**
	 * Recupera el estado en base al id de un municipio
	 * @param municipioId
	 * @return
	 */
	@GetMapping("/estadoByIdMunicipio/{municipioId}")
    @ResponseBody
    public CatEstado getEstadoByIdMunicipio(@PathVariable Integer municipioId) {
        return catMunicipioService.estadoPorIdCatMunicipio(municipioId);
    }

	 
}

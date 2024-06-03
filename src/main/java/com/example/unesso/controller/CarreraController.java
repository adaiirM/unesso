package com.example.unesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.unesso.model.CatCarrera;
import com.example.unesso.model.CatGrupo;
import com.example.unesso.model.CatSemestre;
import com.example.unesso.services.ICatCarreraService;
import com.example.unesso.services.ICatGrupoService;
import com.example.unesso.services.ICatSemestreService;

@Controller
@RequestMapping(value="/carrera")
public class CarreraController {
	@Autowired
	private ICatSemestreService catSemestreService ;
	
	@Autowired
	private ICatCarreraService catCarreraService ;
	
	@Autowired
	private ICatGrupoService catGrupoService;
	
	@GetMapping("/grupoByIdCarreraAndByIdSemestre/{idCarrera}/{semestreId}")
	@ResponseBody
	public CatGrupo getGrupoByIdCarreraAndByIdSemestre(@PathVariable Integer idCarrera, @PathVariable Integer semestreId) {
	    return catGrupoService.grupoPorIdCatCarreraAndIdCatSemestre(idCarrera, semestreId);
	}
	
	@GetMapping("/carreraByIdGrupo/{idGrupo}")
	@ResponseBody
	public CatCarrera getCarreraByIdGrupo(@PathVariable Integer idGrupo) {
	    return catGrupoService.carreraPorGrupo(idGrupo);
	}
	
	@GetMapping("/semestreByIdGrupo/{idGrupo}")
	@ResponseBody
	public CatSemestre getsemestreByIdGrupo(@PathVariable Integer idGrupo) {
	    return catGrupoService.carSemestrePorGrupo(idGrupo);
	}
	

}

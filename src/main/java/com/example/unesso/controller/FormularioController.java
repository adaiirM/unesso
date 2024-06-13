package com.example.unesso.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatMunicipio;
import com.example.unesso.model.EstadoFormularios;
import com.example.unesso.services.IAlumnoService;
import com.example.unesso.services.IEstadoFormulariosService;

@Controller
@RequestMapping(value="/formulario")
public class FormularioController {
	@Autowired
	private IEstadoFormulariosService estadoFormulariosService ;
	@Autowired
    private IAlumnoService alumnoService;

	@GetMapping("/marcarFormularioRealizado/{idAlumno}")
	public ResponseEntity<Map<String, Boolean>> marcarFormularioRealizado(@PathVariable Integer idAlumno) {
	    Map<String, Boolean> response = new HashMap<>();
	    try {
	        // Realizar inserción en la base de datos para marcar el formulario como realizado
	        Alumno alumno = alumnoService.buscarAlumnoPorIdUsuario(idAlumno);
	        EstadoFormularios estadoFormulario = alumno.getEstadoFormularios();
	        estadoFormulario.setFormMisDatos(true);
	        estadoFormulariosService.guardar(estadoFormulario);

	        // Devolver una respuesta de éxito
	        response.put("success", true);
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        // Manejar cualquier excepción y devolver una respuesta de error
	        response.put("success", false);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	@GetMapping("/marcarMiFamiliaRealizado/{idAlumno}")
	public ResponseEntity<Map<String, Boolean>> marcarMiFamiliaRealizado(@PathVariable Integer idAlumno) {
	    Map<String, Boolean> response = new HashMap<>();
	    try {
	        // Realizar inserción en la base de datos para marcar el formulario como realizado
	        Alumno alumno = alumnoService.buscarAlumnoPorIdUsuario(idAlumno);
	        EstadoFormularios estadoFormulario = alumno.getEstadoFormularios();
	        estadoFormulario.setFormMiFamilia(true);
	        estadoFormulariosService.guardar(estadoFormulario);

	        // Devolver una respuesta de éxito
	        response.put("success", true);
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        // Manejar cualquier excepción y devolver una respuesta de error
	        response.put("success", false);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	
}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Alumno;
import com.example.unesso.repository.AlumnoRepository;
import com.example.unesso.services.IAlumnoService;

/**
 * Clase de servicio para operaciones relacionadas con usuarios, implementada con JPA.
 * Implementa los metodos de consulta a la Base de Datos
 */
@Service
@Primary
public class AlumnoServiceJPA implements  IAlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepo;

	/**
     * Obtiene el Alumno en base al idUsuario.
     * @param idUsuario del usuario logeado
     * @return Alumno al que pertenece el idUsuario
     */
	@Override
	public Alumno buscarAlumnoPorIdUsuario(Integer idUsuario) {
		return alumnoRepo.findByUsuario_IdUsuario(idUsuario);
	}

	@Override
	public Alumno guardar(Alumno alumno) {
		return alumnoRepo.save(alumno);
	}

	@Override
	public Alumno buscarPorIdAlumno(Integer idAlumno) {
		return alumnoRepo.findByIdAlumno(idAlumno);
	}

}

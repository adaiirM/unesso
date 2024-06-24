package com.example.unesso.services;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de alumnos en el sistema.
 */
public interface IAlumnoService {
	Alumno buscarPorUsuario(Usuario usuario);
	void guardarAlumno(Alumno alumno);
	Alumno buscarAlumnoPorIdUsuario (Integer idUsuario);
	Alumno getByIdAlumno(Integer idAlumno);
	Alumno guardar (Alumno alumno);
	List<Alumno> getAllAlumnos();
	Page<Alumno> buscarAlumno(String keyword, Pageable pageable);
}

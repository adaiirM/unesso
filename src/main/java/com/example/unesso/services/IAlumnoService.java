package com.example.unesso.services;

import com.example.unesso.model.Alumno;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de alumnos en el sistema.
 */
public interface IAlumnoService {
	Alumno buscarAlumnoPorIdUsuario (Integer idUsuario);
	Alumno guardar (Alumno alumno);
}

package com.example.unesso.services;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de alumnos en el sistema.
 */
public interface IAlumnoService {
	Alumno buscarPorUsuario(Usuario usuario);
}

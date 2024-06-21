package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;

import java.util.List;

@Description("Esta clase realiza operaciones CRUD en la entidad alumno de la Base de datos unesso") 
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	Alumno findByUsuario(Usuario usuario);
	Alumno findByUsuario_IdUsuario(Integer idUsuario);
	Alumno findByIdAlumno(Integer idAlumno);
	List<Alumno> findAll();
}

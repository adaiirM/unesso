package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Alumno;

@Description("Esta clase realiza operaciones CRUD en la entidad alumno de la Base de datos unesso") 
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}

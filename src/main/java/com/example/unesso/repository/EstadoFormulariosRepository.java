package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.EstadoFormularios;

@Description("Esta clase realiza operaciones CRUD en la entidad estadoFormulario de la Base de datos unesso") 
public interface EstadoFormulariosRepository extends JpaRepository<EstadoFormularios, Integer>{

}
package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatSituacionTrabajo;

@Description("Esta clase realiza operaciones CRUD en la entidad catSituacionTrabajo de la Base de datos unesso") 
public interface CatSituacionTrabajoRepository extends JpaRepository<CatSituacionTrabajo, Integer> {

}

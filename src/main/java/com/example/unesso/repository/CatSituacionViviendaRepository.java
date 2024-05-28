package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatSituacionVivienda;

@Description("Esta clase realiza operaciones CRUD en la entidad catSituacionVivienda de la Base de datos unesso") 
public interface CatSituacionViviendaRepository extends JpaRepository<CatSituacionVivienda, Integer> {

}

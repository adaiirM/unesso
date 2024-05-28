package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatSituacionViviendaFamiliar;

@Description("Esta clase realiza operaciones CRUD en la entidad catSituacionViviendaFamiliar de la Base de datos unesso") 
public interface CatSituacionViviendaFamiliarRepository extends JpaRepository<CatSituacionViviendaFamiliar, Integer> {

}

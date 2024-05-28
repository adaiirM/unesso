package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.ViviendaFamiliar;

@Description("Esta clase realiza operaciones CRUD en la entidad viviendaFamilia de la Base de datos unesso") 
public interface ViviendaFamiliarRepository extends JpaRepository<ViviendaFamiliar, Integer> {

}

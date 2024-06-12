package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatMaterialVivienda;

@Description("Esta clase realiza operaciones CRUD en la entidad catMaterialVivienda de la Base de datos unesso") 
public interface CatMaterialViviendaRepository extends JpaRepository<CatMaterialVivienda, Integer> {

}

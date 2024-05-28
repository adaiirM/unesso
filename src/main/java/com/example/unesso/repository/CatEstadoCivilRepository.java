package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatEstadoCivil;

@Description("Esta clase realiza operaciones CRUD en la entidad CatEstadoCivil de la Base de datos unesso") 
public interface CatEstadoCivilRepository extends JpaRepository<CatEstadoCivil, Integer> {

}

package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatMedios;

@Description("Esta clase realiza operaciones CRUD en la entidad CatMedios de la Base de datos unesso") 
public interface CatMediosTransporteRepository extends JpaRepository<CatMedios, Integer> {

}

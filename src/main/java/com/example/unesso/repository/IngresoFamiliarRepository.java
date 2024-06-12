package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.IngresoFamiliar;

@Description("Esta clase realiza operaciones CRUD en la entidad ingresoFamilia de la Base de datos unesso") 
public interface IngresoFamiliarRepository extends JpaRepository<IngresoFamiliar, Integer> {

}

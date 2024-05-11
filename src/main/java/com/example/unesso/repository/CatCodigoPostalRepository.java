package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatCodigoPostal;

@Description("Esta clase realiza operaciones CRUD en la entidad CatCodigoPostal de la Base de datos unesso") 
public interface CatCodigoPostalRepository extends JpaRepository<CatCodigoPostal, Integer> {

}

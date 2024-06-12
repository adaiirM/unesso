package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatRol;

@Description("Esta clase realiza operaciones CRUD en la entidad catRol de la Base de datos unesso") 
public interface CatRolRepository extends JpaRepository<CatRol, Integer> {

}

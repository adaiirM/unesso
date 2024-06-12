package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatServicios;

@Description("Esta clase realiza operaciones CRUD en la entidad catServicios de la Base de datos unesso") 
public interface CatServiciosRepository extends JpaRepository<CatServicios, Integer> {

}

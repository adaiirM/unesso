package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatLocalidad;


@Description("Esta clase realiza operaciones CRUD en la entidad catLocalidad de la Base de datos unesso") 
public interface CatLocalidadRepository extends JpaRepository<CatLocalidad, Integer> {

}

package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatCarrera;

@Description("Esta clase realiza operaciones CRUD en la entidad CatCarrera de la Base de datos unesso") 
public interface CatCarreraRepository extends JpaRepository<CatCarrera, Integer> {

}

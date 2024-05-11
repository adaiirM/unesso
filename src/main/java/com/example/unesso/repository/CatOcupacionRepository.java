package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatOcupacion;

@Description("Esta clase realiza operaciones CRUD en la entidad catOcupacion de la Base de datos unesso") 
public interface CatOcupacionRepository extends JpaRepository<CatOcupacion, Integer> {

}

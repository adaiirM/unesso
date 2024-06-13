package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatSemestre;


@Description("Esta clase realiza operaciones CRUD en la entidad catSemestre de la Base de datos unesso") 
public interface CatSemestreRepository extends JpaRepository<CatSemestre, Integer> {

}

package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatGrupo;


@Description("Esta clase realiza operaciones CRUD en la entidad CatGrupo de la Base de datos unesso") 
public interface CatGrupoRepository extends JpaRepository<CatGrupo, Integer> {

}

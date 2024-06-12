package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatTipoVivienda;

@Description("Esta clase realiza operaciones CRUD en la entidad catTipoVivienda de la Base de datos unesso") 
public interface CatTipoViviendaRepository extends JpaRepository<CatTipoVivienda, Integer> {

}

package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatMunicipio;

@Description("Esta clase realiza operaciones CRUD en la entidad CatMunicipio de la Base de datos unesso") 
public interface CatMunicipioRepository extends JpaRepository<CatMunicipio, Integer> {

}

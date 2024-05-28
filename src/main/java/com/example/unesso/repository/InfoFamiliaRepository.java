package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.InfoFamilia;

@Description("Esta clase realiza operaciones CRUD en la entidad infoFamilia de la Base de datos unesso") 
public interface InfoFamiliaRepository extends JpaRepository<InfoFamilia, Integer> {

}

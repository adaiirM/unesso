package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.GastosFam;

@Description("Esta clase realiza operaciones CRUD en la entidad gastosFam de la Base de datos unesso") 
public interface GastosFamRepository extends JpaRepository<GastosFam, Integer> {

}

package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Transporte;

@Description("Esta clase realiza operaciones CRUD en la entidad transporte de la Base de datos unesso") 
public interface TransporteRepository extends JpaRepository<Transporte, Integer> {

}

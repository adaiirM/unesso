package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Domicilio;

@Description("Esta clase realiza operaciones CRUD en la entidad domicilio de la Base de datos unesso") 
public interface DomicilioRepository extends JpaRepository<Domicilio, Integer> {

}

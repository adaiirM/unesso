package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Trabajo;

@Description("Esta clase realiza operaciones CRUD en la entidad trabajo de la Base de datos unesso") 
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {

}

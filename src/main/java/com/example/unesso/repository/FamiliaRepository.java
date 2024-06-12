package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Familia;

@Description("Esta clase realiza operaciones CRUD en la entidad familia de la Base de datos unesso") 
public interface FamiliaRepository extends JpaRepository<Familia, Integer> {

}

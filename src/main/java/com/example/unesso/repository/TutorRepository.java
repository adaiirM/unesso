package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Tutor;


@Description("Esta clase realiza operaciones CRUD en la entidad tutor de la Base de datos unesso") 
public interface TutorRepository extends JpaRepository<Tutor, Integer> {

}

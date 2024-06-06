package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.TutorEconomico;


/**
 * Esta clase realiza operaciones CRUD en la entidad tutor de la Base de datos unesso
 */
public interface TutorRepository extends JpaRepository<TutorEconomico, Integer> {

}

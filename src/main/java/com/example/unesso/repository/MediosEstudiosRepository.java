package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.MediosEstudios;

@Description("Esta clase realiza operaciones CRUD en la entidad mediosEstudios de la Base de datos unesso") 
public interface MediosEstudiosRepository extends JpaRepository<MediosEstudios, Integer> {

}

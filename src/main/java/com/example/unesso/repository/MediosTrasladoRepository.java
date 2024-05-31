package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.MediosTraslado;

@Description("Esta clase realiza operaciones CRUD en la entidad mediosTraslado de la Base de datos unesso") 
public interface MediosTrasladoRepository extends JpaRepository<MediosTraslado, Integer> {

}

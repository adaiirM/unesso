package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.ReciboLuz;

@Description("Esta clase realiza operaciones CRUD en la entidad reciboLuz de la Base de datos unesso") 
public interface ReciboLuzRepository extends JpaRepository<ReciboLuz, Integer> {

}

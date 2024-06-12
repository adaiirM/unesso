package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatInternet;

@Description("Esta clase realiza operaciones CRUD en la entidad CatInternet de la Base de datos unesso") 
public interface CatInternetRepository extends JpaRepository<CatInternet, Integer> {

}

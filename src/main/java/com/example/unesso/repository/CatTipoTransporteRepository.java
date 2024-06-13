package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatTipoTransporte;

@Description("Esta clase realiza operaciones CRUD en la entidad catTipoTransporte de la Base de datos unesso") 
public interface CatTipoTransporteRepository extends JpaRepository<CatTipoTransporte, Integer> {

}

package com.example.unesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatMediosTransporte;

/**
 * Esta clase realiza operaciones CRUD en la entidad CatMedios de la Base de datos unesso
 */
public interface CatMediosTransporteRepository extends JpaRepository<CatMediosTransporte, Integer> {

}

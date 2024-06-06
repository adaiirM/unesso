package com.example.unesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.CatEstado;

/**
 * Esta clase realiza operaciones CRUD en la entidad CatEstado de la Base de datos unesso
 */
public interface CatEstadoRepository extends JpaRepository<CatEstado, Integer> {
	


}

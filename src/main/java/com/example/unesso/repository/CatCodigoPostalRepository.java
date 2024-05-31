package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatLocalidad;

/**
 * Esta clase realiza operaciones CRUD en la entidad CatCodigoPostal de la Base de datos unesso") 
 */
public interface CatCodigoPostalRepository extends JpaRepository<CatCodigoPostal, Integer> {
	@Query("SELECT cl.catCodigoPostal FROM CatLocalidad cl WHERE cl.idCatLocalidad = :idCatLocalidad")
	CatCodigoPostal codigoPostalPorIdCatLocalidad(@Param("idCatLocalidad") Integer idCatLocalidad);
	
	

	
}

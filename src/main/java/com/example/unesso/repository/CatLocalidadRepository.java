package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.CatMunicipio;


/**
 * Esta clase realiza operaciones CRUD en la entidad catLocalidad de la Base de datos unesso
 */
public interface CatLocalidadRepository extends JpaRepository<CatLocalidad, Integer> {
	//Recupera las localidades por el minicipio
		List<CatLocalidad> findLocalidadesByCatMunicipio_IdCatMunicipio(Integer idCatMunicipio);
	
		//Recupera el municipio por la localidad
		@Query("SELECT cl.catMunicipio FROM CatLocalidad cl WHERE cl.idCatLocalidad = :idLocalidad")
		CatMunicipio municipioPorLocalidad(@Param("idLocalidad") Integer idLocalidad);
		
}

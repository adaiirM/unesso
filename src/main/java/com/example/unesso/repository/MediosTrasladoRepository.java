package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.MediosTraslado;

/**
 * Esta clase realiza operaciones CRUD en la entidad mediosTraslado de la Base de datos unesso 
 */
public interface MediosTrasladoRepository extends JpaRepository<MediosTraslado, Integer> {
	
	@Query("SELECT mt FROM MediosTraslado mt WHERE mt.alumno.idAlumno = :idAlumno")
    List<MediosTraslado> buscar(@Param("idAlumno") Integer idAlumno);
    
	

}

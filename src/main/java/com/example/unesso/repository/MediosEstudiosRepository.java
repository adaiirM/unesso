package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.MediosEstudios;

/**
 * Esta clase realiza operaciones CRUD en la entidad mediosEstudios de la Base de datos unesso
 */
public interface MediosEstudiosRepository extends JpaRepository<MediosEstudios, Integer> {
	  @Query("SELECT m FROM MediosEstudios m WHERE m.alumno.idAlumno = :idAlumno")
	  List<MediosEstudios> findMediosEstudiosByAlumnoId(@Param("idAlumno") Integer idAlumno);

}

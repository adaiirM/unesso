package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.ServiciosVivienda;

@Description("Esta clase realiza operaciones CRUD en la entidad serviciosVivienda de la Base de datos unesso") 
public interface ServiciosViviendaRepository extends JpaRepository<ServiciosVivienda, Integer> {
	@Query("SELECT sv FROM ServiciosVivienda sv WHERE sv.viviendaFamiliar.id = :idViviendaFamilia")
    List<ServiciosVivienda> findByViviendaFamiliarId(@Param("idViviendaFamilia") Integer idViviendaFamilia);

}

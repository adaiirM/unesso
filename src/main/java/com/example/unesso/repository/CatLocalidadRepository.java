package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.CatMunicipio;


@Description("Esta clase realiza operaciones CRUD en la entidad catLocalidad de la Base de datos unesso") 
public interface CatLocalidadRepository extends JpaRepository<CatLocalidad, Integer> {
	List<CatLocalidad> findByCatMunicipio(CatMunicipio municipio);
	

}

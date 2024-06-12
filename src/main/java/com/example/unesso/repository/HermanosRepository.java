package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Hermanos;

@Description("Esta clase realiza operaciones CRUD en la entidad hermanos de la Base de datos unesso") 
public interface HermanosRepository extends JpaRepository<Hermanos, Integer> {
	List<Hermanos> findByFamiliaIdFamilia(Integer idFamilia);
}

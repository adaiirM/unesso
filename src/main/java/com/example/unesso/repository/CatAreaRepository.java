package com.example.unesso.repository;

import com.example.unesso.model.CatArea;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

@Description("Esta clase realiza operaciones CRUD en la entidad CatArea de la Base de datos ineis")
public interface CatAreaRepository extends JpaRepository<CatArea,Integer> {

}

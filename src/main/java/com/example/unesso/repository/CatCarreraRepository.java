package com.example.unesso.repository;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatGrupo;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.CatCarrera;

@Description("Esta clase realiza operaciones CRUD en la entidad CatCarrera de la Base de datos unesso") 
public interface CatCarreraRepository extends JpaRepository<CatCarrera, Integer> {
    CatCarrera findByCarrera(String carrera);

}

package com.example.unesso.repository;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.FechasRegistradas;
import com.example.unesso.services.db.FechasRegistradasServiceJPA;
import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

@Description("Esta clase realiza operaciones CRUD de fechas")
public interface FechasRegistradasRepository extends JpaRepository<FechasRegistradas, Integer> {
    FechasRegistradas findByIdFechasRegistradas(Integer idFechasRegistradas);

    //FechasRegistradas findByIdFechasRegistradas(Integer idFechasRegistradas);
    List<FechasRegistradas> findAll();

}

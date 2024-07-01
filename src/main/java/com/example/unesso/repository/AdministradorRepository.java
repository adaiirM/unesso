package com.example.unesso.repository;

import com.example.unesso.model.Administrador;
import com.example.unesso.model.Alumno;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Description("Esta clase realiza operaciones CRUD en la entidad administrador de la Base de datos inesis")
public interface AdministradorRepository extends JpaRepository<Administrador,Integer> {
    Page<Administrador> findBynombreContainingIgnoreCase(String keyword, Pageable pageable);
    Administrador findByIdAdministrador(Integer idAdministrador);
}

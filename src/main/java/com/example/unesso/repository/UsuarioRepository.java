package com.example.unesso.repository;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unesso.model.Usuario;

@Description("Esta clase realiza operaciones CRUD en la entidad user de la Base de datos unesso") 
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

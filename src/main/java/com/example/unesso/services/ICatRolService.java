package com.example.unesso.services;


import com.example.unesso.model.CatRol;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatRol en el sistema.
 */
public interface ICatRolService {
    CatRol findByIdRol(Integer id);
}

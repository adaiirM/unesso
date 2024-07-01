package com.example.unesso.services;

import com.example.unesso.model.Administrador;
import com.example.unesso.model.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAdministradorService {
    void guardarAdministrador(Administrador administrador);
    void deleteAdministrador(Integer idAdministrador);
    Page<Administrador> buscarAdministrador(String keyword, Pageable pageable);
    Administrador getByIdAdministrador(Integer idAdministrador);
}

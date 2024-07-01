package com.example.unesso.services.db;

import com.example.unesso.model.Administrador;
import com.example.unesso.repository.AdministradorRepository;
import com.example.unesso.services.IAdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AdministradorServiceJPA implements IAdministradorService {
    @Autowired
    private AdministradorRepository administradorRepository;

    @Override
    public void guardarAdministrador(Administrador administrador) {
        administradorRepository.save(administrador);
    }

    @Override
    public void deleteAdministrador(Integer idAdministrador) {
        administradorRepository.deleteById(idAdministrador);
    }

    @Override
    public Page<Administrador> buscarAdministrador(String keyword, Pageable pageable) {
        if (keyword == null || keyword.isEmpty()) {
            return administradorRepository.findAll(pageable);
        } else {
            return administradorRepository.findBynombreContainingIgnoreCase(keyword, pageable);
        }
    }

    @Override
    public Administrador getByIdAdministrador(Integer idAdministrador) {
        return administradorRepository.findByIdAdministrador(idAdministrador);
    }
}

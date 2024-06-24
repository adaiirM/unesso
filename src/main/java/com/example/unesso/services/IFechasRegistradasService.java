package com.example.unesso.services;

import com.example.unesso.model.FechasRegistradas;

import java.util.List;

public interface IFechasRegistradasService {
    void guardarFechas(FechasRegistradas fechasRegistradas);

    abstract FechasRegistradas getByIdFechasRegistradas(Integer idFechasRegistradas);
    FechasRegistradas guardar (FechasRegistradas fechasRegistradas);
    List<FechasRegistradas> getAllFechasRegistradas();

    List<FechasRegistradas> findAll();
}

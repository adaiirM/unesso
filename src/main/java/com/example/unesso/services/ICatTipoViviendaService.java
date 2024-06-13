package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatTipoVivienda;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatTipoVivienda en el sistema.
 */
public interface ICatTipoViviendaService {
	List<CatTipoVivienda> listarTipoVivienda();
	List<CatTipoVivienda> buscarTodas();
}

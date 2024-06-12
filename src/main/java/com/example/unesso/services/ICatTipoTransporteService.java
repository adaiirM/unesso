package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatTipoTransporte;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatTipoTransporte en el sistema.
 */
public interface ICatTipoTransporteService {
	List<CatTipoTransporte> buscarTodos();
}

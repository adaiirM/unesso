package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatMediosTransporte;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatMediosTransporte en el sistema.
 */
public interface ICatMediosTransporteService {
	List<CatMediosTransporte> buscarTodos();
}

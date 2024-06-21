package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatMaterialVivienda;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatMaterialVivienda en el sistema.
 */
public interface ICatMaterialViviendaService {
	List<CatMaterialVivienda> listarMaterialVivienda();
	List<CatMaterialVivienda> buscarTodas();
}

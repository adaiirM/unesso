package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatParentesco;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatParentesco en el sistema.
 */
public interface ICatParentescoService {
	List<CatParentesco> buscarTodos();
}

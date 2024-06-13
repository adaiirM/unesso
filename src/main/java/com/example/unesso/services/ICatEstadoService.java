package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatEstado;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatEstado en el sistema.
 */
public interface ICatEstadoService {
	List<CatEstado> listEstados();
	CatEstado estadoPorId(Integer id);
	List<CatEstado> buscarTodos();
}

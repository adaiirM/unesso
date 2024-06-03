package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatServicios;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatServicios  en el sistema.
 */
public interface ICatServiciosService {
	List<CatServicios> buscarTodos ();
}

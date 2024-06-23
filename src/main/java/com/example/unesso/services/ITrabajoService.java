package com.example.unesso.services;

import com.example.unesso.model.Trabajo;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de trabajoService en el sistema.
 */
public interface ITrabajoService {
	Trabajo buscarPorId(Integer id);
	Trabajo guardarTrabajo(Trabajo trabajo);
}

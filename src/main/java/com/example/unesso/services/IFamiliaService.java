package com.example.unesso.services;

import com.example.unesso.model.Familia;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de familia en el sistema.
 */
public interface IFamiliaService {
	Familia obtenerFamiliaPorId(Integer id);
	Familia guardarFamilia(Familia familia);
	Familia guardar(Familia familia);
}

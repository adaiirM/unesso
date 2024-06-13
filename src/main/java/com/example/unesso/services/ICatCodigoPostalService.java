package com.example.unesso.services;

import com.example.unesso.model.CatCodigoPostal;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de catCodigoPostal en el sistema.
 */
public interface ICatCodigoPostalService {
	CatCodigoPostal buscarPorId(Integer idCatCodigoPostal);
	CatCodigoPostal cpPorLocalidad(Integer idCatLocalidad);
}

package com.example.unesso.services;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.Domicilio;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de domicilio en el sistema.
 */
public interface IDomicilioService {
	Domicilio guardarDomicilio(Domicilio domicilio);
	CatCodigoPostal buscarPorLocalidad(CatLocalidad catLocalidad);
	Domicilio buscarPorId(Integer id);
	Domicilio guardar(Domicilio domicilio);
}

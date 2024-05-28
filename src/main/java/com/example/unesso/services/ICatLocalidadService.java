package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatLocalidad;
import com.example.unesso.model.CatMunicipio;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatLocalidad en el sistema.
 */
public interface ICatLocalidadService {
	List<CatLocalidad> localidadesPorIdCatMunicipio(Integer idCatMunicipio);
	//CatCodigoPostal cpPorLocalidad(Integer idCatLocalidad);
	CatMunicipio municipioPorIdCatLocalidad(Integer idCatLocalidad);

}

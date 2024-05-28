package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatMunicipio;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatMunicipio en el sistema.
 */
public interface ICatMunicipioService {
	List<CatMunicipio> listaMunicipiosPorEstado(CatEstado estado);
	CatMunicipio municipioPorId(Integer id);
}

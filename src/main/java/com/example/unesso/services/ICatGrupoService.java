package com.example.unesso.services;

import com.example.unesso.model.CatCarrera;
import com.example.unesso.model.CatGrupo;
import com.example.unesso.model.CatSemestre;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de CatGrupo en el sistema.
 */
public interface ICatGrupoService {
	CatGrupo grupoPorIdCatCarreraAndIdCatSemestre(Integer idCatCarrera, Integer idCatSemestre);
	CatCarrera carreraPorGrupo(Integer idCatGrupo);
	CatSemestre carSemestrePorGrupo(Integer idGrupo);
	CatGrupo findByNombreGrupo(String nombreGrupo);
}

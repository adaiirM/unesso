package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatMediosTransporte;
import com.example.unesso.model.MediosTraslado;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de mediosTraslado en el sistema.
 */
public interface IMediosTrasladoService {
	MediosTraslado guardar(MediosTraslado medios);
	List<MediosTraslado> guardarTodos(List<MediosTraslado> medios);
	List<MediosTraslado> buscarPorIdAlumno(Integer idAlumno);
	void eliminar(MediosTraslado medios);
	void eliminarTodos(List<MediosTraslado> medios);
}

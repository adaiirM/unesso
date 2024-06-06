package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.MediosEstudios;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de mediosEstudios en el sistema.
 */
public interface MediosEstudiosService {
	MediosEstudios guardar(MediosEstudios medios);
	List<MediosEstudios> guardarTodos (List<MediosEstudios> medios);
	List<MediosEstudios> buscarPotIdAlumno (Integer idAlumno);
	void eliminar(MediosEstudios mediosEstudios);
	void eliminarTodos(List<MediosEstudios> mediosEstudios);
}

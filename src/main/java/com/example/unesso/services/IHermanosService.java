package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.Hermanos;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de hermanos en el sistema.
 */
public interface IHermanosService {
	Hermanos guardar(Hermanos hermano);
	List<Hermanos> guardarTodos(List<Hermanos> lista);
	List<Hermanos> buscarPorIdFamilia(Integer IdFamilia);
	void eliminar(Hermanos hermano);

}

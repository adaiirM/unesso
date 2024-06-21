package com.example.unesso.services;
import java.util.List;

import com.example.unesso.model.CatInternet;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de catInternet en el sistema.
 */
public interface ICatInternetService {
	List<CatInternet> buscarTodos();
}

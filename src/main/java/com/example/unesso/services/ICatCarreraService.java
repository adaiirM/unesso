package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.CatCarrera;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de catCarrera en el sistema.
 */
@Service
@Primary
public interface ICatCarreraService {
	List <CatCarrera> buscarTodas();


	CatCarrera findByIdCatCarrera(Integer idCatCarrera);

    CatCarrera findByNombreCarrera(String nombreCarrera);

	CatCarrera findById(Integer id);
}

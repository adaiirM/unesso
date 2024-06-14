package com.example.unesso.services;

import com.example.unesso.model.Familia;
import com.example.unesso.model.GastosFam;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de gastosFam en el sistema.
 */
public interface IGastosFamService {
	GastosFam buscarPorId(Integer idGastosFam);
	GastosFam guardarGastoFam(GastosFam gastoFam);
}

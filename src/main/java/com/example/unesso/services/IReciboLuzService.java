package com.example.unesso.services;

import com.example.unesso.model.ReciboLuz;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de reciboLuz en el sistema.
 */
public interface IReciboLuzService {
	ReciboLuz buscarPorId(Integer idReciboLuz);
	ReciboLuz guardarReciboLuz(ReciboLuz reciboLuz);
}

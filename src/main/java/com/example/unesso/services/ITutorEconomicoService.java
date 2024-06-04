package com.example.unesso.services;

import com.example.unesso.model.TutorEconomico;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de tutor en el sistema.
 */
public interface ITutorEconomicoService {
	TutorEconomico guardarTutor(TutorEconomico tutor);
	TutorEconomico obtenerPorId(Integer idTutor);
}

package com.example.unesso.services;

import java.util.List;

import com.example.unesso.model.ServiciosVivienda;

/**
 * Description: Interfaz que define operaciones relacionadas con la gestión de serviciosVivienda en el sistema.
 */
public interface IServiciosViviendaService {
	ServiciosVivienda guardar ( ServiciosVivienda serviciosVivienda );
	List<ServiciosVivienda> guardarTodos ( List<ServiciosVivienda> serviciosVivienda );
	void eliminar ( ServiciosVivienda serviciosVivienda );
	void eliminarTodos ( List<ServiciosVivienda> serviciosVivienda );
	List<ServiciosVivienda> buscarServiciosViviendaPorIdViviendaFamiiar(Integer idViviendaFamiliar);

}

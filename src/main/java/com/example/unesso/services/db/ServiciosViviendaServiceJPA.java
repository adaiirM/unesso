package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.ServiciosVivienda;
import com.example.unesso.repository.ServiciosViviendaRepository;
import com.example.unesso.services.ServiciosViviendaService;

@Service
@Primary
public class ServiciosViviendaServiceJPA implements ServiciosViviendaService {
	@Autowired
	private ServiciosViviendaRepository serviciosViviendaRepo;

	@Override
	public ServiciosVivienda guardar(ServiciosVivienda serviciosVivienda) {
		return serviciosViviendaRepo.save(serviciosVivienda);
	}

	@Override
	public List<ServiciosVivienda> guardarTodos(List<ServiciosVivienda> serviciosVivienda) {
		return serviciosViviendaRepo.saveAll(serviciosVivienda);
	}

	@Override
	public void eliminar(ServiciosVivienda serviciosVivienda) {
		serviciosViviendaRepo.delete(serviciosVivienda);
	}

	@Override
	public void eliminarTodos(List<ServiciosVivienda> serviciosVivienda) {
		serviciosViviendaRepo.deleteAll(serviciosVivienda);
	}

	@Override
	public List<ServiciosVivienda> buscarServiciosViviendaPorIdViviendaFamiiar(Integer idViviendaFamiliar) {
		return serviciosViviendaRepo.findByViviendaFamiliarId(idViviendaFamiliar);
	}
}

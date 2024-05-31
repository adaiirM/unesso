package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Hermanos;
import com.example.unesso.repository.HermanosRepository;
import com.example.unesso.services.IHermanosService;

@Service
@Primary
public class HermanosServiceJPA implements IHermanosService {
	@Autowired
	private HermanosRepository hermanosRepo;

	@Override
	public Hermanos guardar(Hermanos hermano) {
		return hermanosRepo.save(hermano);
	}

	@Override
	public List<Hermanos> guardarTodos(List<Hermanos> lista) {
		return hermanosRepo.saveAll(lista);
	}

	@Override
	public List<Hermanos> buscarPorIdFamilia(Integer IdFamilia) {
		return hermanosRepo.findByFamiliaIdFamilia(IdFamilia);
	}

	@Override
	public void eliminar(Hermanos hermano) {
		hermanosRepo.delete(hermano);	
	}
}

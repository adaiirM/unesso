package com.example.unesso.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatEstado;
import com.example.unesso.repository.CatEstadoRepository;
import com.example.unesso.services.ICatEstadoService;

@Service
@Primary
public class CatEstadoServiceJPA implements ICatEstadoService{
	@Autowired
	private CatEstadoRepository catEstadoRepo;

	@Override
	public List<CatEstado> listEstados() {
		return catEstadoRepo.findAll();
	}

	@Override
	public CatEstado estadoPorId(Integer id) {
		Optional<CatEstado> op = catEstadoRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	
	/**
     * Obtiene todos los estados de la base de datos
     * @return List<CatEstado> lista con todos los estados encontrados.
     */
	@Override
	public List<CatEstado> buscarTodos() {
		return catEstadoRepo.findAll();
	}
}

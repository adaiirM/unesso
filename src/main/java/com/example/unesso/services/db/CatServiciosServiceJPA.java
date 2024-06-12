package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatServicios;
import com.example.unesso.repository.CatSemestreRepository;
import com.example.unesso.repository.CatServiciosRepository;
import com.example.unesso.services.ICatServiciosService;

@Service
@Primary
public class CatServiciosServiceJPA implements ICatServiciosService {
	@Autowired
	private CatServiciosRepository catServiciosRepository;
	
	@Override
	public List<CatServicios> buscarTodos() {
		return catServiciosRepository.findAll();
	}

}

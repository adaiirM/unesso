package com.example.unesso.services.db;

import com.example.unesso.model.CatDistrito;
import com.example.unesso.repository.CatDistritoRepository;
import com.example.unesso.services.ICatDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatDistritoServiceJPA implements ICatDistritoService {
	@Autowired
	private CatDistritoRepository catDistritoRepo;

	@Override
	public CatDistrito distritoPorIdRegion(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

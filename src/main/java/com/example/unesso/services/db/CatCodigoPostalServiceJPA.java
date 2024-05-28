package com.example.unesso.services.db;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatCodigoPostal;
import com.example.unesso.model.CatEstado;
import com.example.unesso.repository.CatCodigoPostalRepository;
import com.example.unesso.services.ICatCodigoPostalService;


@Service
@Primary
public class CatCodigoPostalServiceJPA implements ICatCodigoPostalService{
	
	@Autowired
	private CatCodigoPostalRepository catCodigoPostalRepo;
	
	@Override
	public CatCodigoPostal buscarPorId(Integer idCatCodigoPostal) {
		Optional<CatCodigoPostal> op = catCodigoPostalRepo.findById(idCatCodigoPostal);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}


}

package com.example.unesso.services.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.GastosFam;
import com.example.unesso.repository.GastosFamRepository;
import com.example.unesso.services.IGastosFamService;

@Service
@Primary
public class GastosFamServiceJPA implements IGastosFamService {
	@Autowired
	private GastosFamRepository gastosFamRepo;


	@Override
	public GastosFam guardarGastoFam(GastosFam gastoFam) {
		return gastosFamRepo.save(gastoFam);
	}


	@Override
	public GastosFam buscarPorId(Integer idGastosFam) {
		Optional<GastosFam> op = gastosFamRepo.findById(idGastosFam);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

}

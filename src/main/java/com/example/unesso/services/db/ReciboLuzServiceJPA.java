package com.example.unesso.services.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.ReciboLuz;
import com.example.unesso.repository.ReciboLuzRepository;
import com.example.unesso.services.IReciboLuzService;

@Service
@Primary
public class ReciboLuzServiceJPA implements IReciboLuzService {
	@Autowired
	private ReciboLuzRepository reciboLuzRepo;

	@Override
	public ReciboLuz buscarPorId(Integer idReciboLuz) {
		Optional<ReciboLuz> op = reciboLuzRepo.findById(idReciboLuz);
		if(op.isPresent()) {
			return op.get();
		}
		return null;	
	}

	@Override
	public ReciboLuz guardarReciboLuz(ReciboLuz reciboLuz) {
		return reciboLuzRepo.save(reciboLuz);
	}
	
	
}

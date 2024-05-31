package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.MediosEstudios;
import com.example.unesso.repository.MediosEstudiosRepository;
import com.example.unesso.services.IMediosEstudiosService;

@Service
@Primary
public class MediosEstudiosServiceJPA implements IMediosEstudiosService {
	@Autowired
	private MediosEstudiosRepository mediosEstudiosRepo;

	@Override
	public MediosEstudios guardar(MediosEstudios medios) {
		return mediosEstudiosRepo.save(medios);
	}

	@Override
	public List<MediosEstudios> guardarTodos(List<MediosEstudios> medios) {
		return mediosEstudiosRepo.saveAll(medios);
	}

	@Override
	public List<MediosEstudios> buscarPotIdAlumno(Integer idAlumno) {
		return mediosEstudiosRepo.findMediosEstudiosByAlumnoId(idAlumno);
	}

	@Override
	public void eliminar(MediosEstudios mediosEstudios) {
		mediosEstudiosRepo.delete(mediosEstudios);
		
	}

	@Override
	public void eliminarTodos(List<MediosEstudios> mediosEstudios) {
		mediosEstudiosRepo.deleteAllInBatch(mediosEstudios);
		
	}

	

	
	
}

package com.example.unesso.services.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.InfoFamilia;
import com.example.unesso.repository.InfoFamiliaRepository;
import com.example.unesso.services.InfoFamiliaService;


@Service
@Primary
public class InfoFamiliaServiceJPA implements InfoFamiliaService {
	@Autowired
	private InfoFamiliaRepository infoFamiliaRepo;

	@Override
	public InfoFamilia guardar(InfoFamilia infoFamilia) {
		return infoFamiliaRepo.save(infoFamilia);
	}
}

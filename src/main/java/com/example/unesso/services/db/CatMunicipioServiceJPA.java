package com.example.unesso.services.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatMunicipio;
import com.example.unesso.repository.CatMunicipioRepository;
import com.example.unesso.services.ICatMunicipioService;

@Service
@Primary
public class CatMunicipioServiceJPA implements ICatMunicipioService {
	@Autowired
	private CatMunicipioRepository catMunicipioRepo;

	@Override
	public List<CatMunicipio> listaMunicipiosPorEstado(CatEstado estado) {
		return catMunicipioRepo.findByCatEstado(estado);
	}

	@Override
	public CatMunicipio municipioPorId(Integer id) {
		Optional<CatMunicipio> op = catMunicipioRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
	@Override
	public List<CatMunicipio> municipiosPorIdCatEstado(Integer idCatEstado) {
		return catMunicipioRepo.findMunicipiosByCatEstado_IdCatEstado(idCatEstado);
	}

	@Override
	public CatEstado estadoPorIdCatMunicipio(Integer idCatMunicipio) {
		return catMunicipioRepo.obtenerEstadoPorIdMunicipio(idCatMunicipio);
	}
}

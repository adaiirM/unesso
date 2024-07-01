package com.example.unesso.services.db;

import com.example.unesso.model.CatDistrito;
import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatMunicipio;
import com.example.unesso.model.CatRegion;
import com.example.unesso.repository.CatMunicipioRepository;
import com.example.unesso.services.ICatMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
	@Override
	public CatRegion regionPorIdMinucipio(Integer idCatRegion) {
		return catMunicipioRepo.findRegionByMunicipioId(idCatRegion);
	}

	@Override
	public CatDistrito distritoPorIdMunicipio(Integer idMunicipio) {
		return catMunicipioRepo.findDistritoByMunicipioId(idMunicipio);
	}
}

package com.example.unesso.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.CatMediosTransporte;
import com.example.unesso.model.MediosTraslado;
import com.example.unesso.repository.MediosTrasladoRepository;
import com.example.unesso.services.IMediosTrasladoService;

@Service
@Primary
public class MediosTrasladoServiceJPA implements IMediosTrasladoService{
	@Autowired
	private MediosTrasladoRepository mediosTrasladoRepo;

	/**
	 * Registra un medio de traslado, en caso de ya existir lo actualiza
	 * @param MediosTraslado si no tiene el id lo registra, de lo contrario lo actualiza
	 * @return MediosTraslado es el objeto registrado, si se registro devuelve el id del nuevo registro
	 */
	@Override
	public MediosTraslado guardar(MediosTraslado medios) {
		return mediosTrasladoRepo.save(medios);
	}

	@Override
	public List<MediosTraslado> guardarTodos(List<MediosTraslado> medios) {
		return mediosTrasladoRepo.saveAll(medios);
	}

	@Override
	public List<MediosTraslado> buscarPorIdAlumno(Integer idAlumno) {
		return mediosTrasladoRepo.buscar(idAlumno);
	}

	@Override
	public void eliminar(MediosTraslado medios) {
		mediosTrasladoRepo.delete(medios);
	}

	@Override
	public void eliminarTodos(List<MediosTraslado> medios) {
		mediosTrasladoRepo.deleteAll(medios);
		
	}
	
}

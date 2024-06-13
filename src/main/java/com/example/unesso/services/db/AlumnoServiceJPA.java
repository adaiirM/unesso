package com.example.unesso.services.db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;
import com.example.unesso.repository.AlumnoRepository;
import com.example.unesso.services.IAlumnoService;


@Service
@Primary
public class AlumnoServiceJPA implements  IAlumnoService {
	@Autowired
	private AlumnoRepository alumnoRepo;

	@Override
	public Alumno buscarPorUsuario(Usuario usuario) {
		/*Optional<Alumno> op = alumnoRepo.findByUsuario(usuario);
		if(op.isPresent()) {
			return op.get();
		}
		return null;*/
		return alumnoRepo.findByUsuario(usuario);
	}

	@Override
	public void guardarAlumno(Alumno alumno) {
		alumnoRepo.save(alumno);
	}
	
	/**
     * Obtiene el Alumno en base al idUsuario.
     * @param idUsuario del usuario logeado
     * @return Alumno al que pertenece el idUsuario
     */
	@Override
	public Alumno buscarAlumnoPorIdUsuario(Integer idUsuario) {
		return alumnoRepo.findByUsuario_IdUsuario(idUsuario);
	}

	@Override
	public Alumno guardar(Alumno alumno) {
		return alumnoRepo.save(alumno);
	}

}

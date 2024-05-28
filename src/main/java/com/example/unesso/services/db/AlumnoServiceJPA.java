package com.example.unesso.services.db;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatEstado;
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

}

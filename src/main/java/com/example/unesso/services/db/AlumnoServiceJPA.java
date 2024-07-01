package com.example.unesso.services.db;

import com.example.unesso.model.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.unesso.repository.AlumnoRepository;
import com.example.unesso.services.AlumnoService;
import com.example.unesso.model.Alumno;
import com.example.unesso.model.Usuario;
import com.example.unesso.repository.AlumnoRepository;
import com.example.unesso.services.IAlumnoService;

import java.util.List;


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
	public Alumno getByIdAlumno(Integer idAlumno) {
		return alumnoRepo.findByIdAlumno(idAlumno);
	}

	@Override
	public Alumno guardar(Alumno alumno) {
		return alumnoRepo.save(alumno);
	}

	@Override
	public Alumno alumnoPorIdAlumno(Integer idAlumno) {
		return alumnoRepo.findByIdAlumno(idAlumno);
	}

	@Override
	public List<Alumno> getAllAlumnos() {
		return alumnoRepo.findAll();
	}

	@Override
	public Page<Alumno> buscarAlumno(String keyword, Pageable pageable) {
		if (keyword == null || keyword.isEmpty()) {
			return alumnoRepo.findAll(pageable);
		} else {
			return alumnoRepo.findByNombreContainingIgnoreCase(keyword, pageable);
		}
	}


	public void saveAlumno(Alumno alumno) {
		alumnoRepo.save(alumno);
	}
	public void deleteAlumno(Integer idAlumno) {
		alumnoRepo.deleteById(idAlumno);
	}

}

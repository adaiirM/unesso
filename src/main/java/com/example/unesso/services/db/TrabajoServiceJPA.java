package com.example.unesso.services.db;


import java.util.Optional;

>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.example.unesso.model.ReciboLuz;
import com.example.unesso.model.Trabajo;
import com.example.unesso.repository.CatEscolaridadRepository;
import com.example.unesso.repository.TrabajoRepository;
import com.example.unesso.services.ITrabajoService;

@Service
@Primary
public class TrabajoServiceJPA implements ITrabajoService {
	@Autowired
	private TrabajoRepository trabajoRepo;

	@Override
	public Trabajo buscarPorId(Integer id) {
		Optional<Trabajo> op = trabajoRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public Trabajo guardarTrabajo(Trabajo trabajo) {
		return trabajoRepo.save(trabajo);
	}
>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
}

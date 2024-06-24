package com.example.unesso.services.db;

import com.example.unesso.model.FechasRegistradas;
import com.example.unesso.repository.FechasRegistradasRepository;
import com.example.unesso.services.IFechasRegistradasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class FechasRegistradasServiceJPA implements IFechasRegistradasService {
    @Autowired
    private FechasRegistradasRepository fechasRegistradasRepository;

    // Método para guardar fechas registradas

    @Override
    public void guardarFechas(FechasRegistradas fechasRegistradas) {
        fechasRegistradasRepository.save(fechasRegistradas);

    }
    public void saveFechasRegistradas(FechasRegistradas fechasRegistradas) {
        fechasRegistradasRepository.save(fechasRegistradas);
    }


    @Override
    public FechasRegistradas guardar(FechasRegistradas fechasRegistradas) {
        return fechasRegistradasRepository.save(fechasRegistradas);
    }

    @Override
    public List<FechasRegistradas> getAllFechasRegistradas() {
        return fechasRegistradasRepository.findAll();
    }
    @Override
    public List<FechasRegistradas> findAll() {
        return fechasRegistradasRepository.findAll();
    }

    @Override
    public FechasRegistradas getByIdFechasRegistradas(Integer idFechasRegistradas) {
        return fechasRegistradasRepository.findByIdFechasRegistradas(idFechasRegistradas);
    }

    public void deleteFechasRegistradas(Integer idFechasRegistradas) {
        fechasRegistradasRepository.deleteById(idFechasRegistradas);
    }
}

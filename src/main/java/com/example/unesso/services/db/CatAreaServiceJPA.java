package com.example.unesso.services.db;

import com.example.unesso.model.CatArea;
import com.example.unesso.repository.CatAreaRepository;
import com.example.unesso.services.ICatAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CatAreaServiceJPA implements ICatAreaService {
    @Autowired
    private CatAreaRepository catAreaRepository;

    @Override
    public List<CatArea> getCatAreas() {
        return catAreaRepository.findAll();
    }

    @Override
    public CatArea getCatAreaById(Integer idCatArea) {
        return catAreaRepository.findById(idCatArea).orElse(null);
    }
}

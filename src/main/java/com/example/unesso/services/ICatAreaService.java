package com.example.unesso.services;

import com.example.unesso.model.CatArea;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public interface ICatAreaService {
    List<CatArea> getCatAreas();
    CatArea getCatAreaById(Integer idCatArea);
}

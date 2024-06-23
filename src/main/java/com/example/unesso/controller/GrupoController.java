package com.example.unesso.controller;
import com.example.unesso.model.CatGrupo;
import com.example.unesso.services.db.CatGrupoServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrupoController {

    @Autowired
    private CatGrupoServiceJPA catGrupoService;

    @GetMapping("/obtenerGrupo")
    @ResponseBody
    public CatGrupo obtenerGrupo(@RequestParam("idCarrera") int idCarrera, @RequestParam("idSemestre") int idSemestre) {
        return catGrupoService.grupoPorIdCatCarreraAndIdCatSemestre(idCarrera, idSemestre);
    }
}

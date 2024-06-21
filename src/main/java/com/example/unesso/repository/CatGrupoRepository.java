package com.example.unesso.repository;


import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.CatCarrera;
import com.example.unesso.model.CatGrupo;
import com.example.unesso.model.CatSemestre;


/**
 * Esta clase realiza operaciones CRUD en la entidad CatGrupo de la Base de datos unesso") 
 */
public interface CatGrupoRepository extends JpaRepository<CatGrupo, Integer> {
	/**
	 * Este metodo obtiene un grupo en base al semestre y carrera
	 * @param idCatCarrera es el id de la carrera
	 * @param idCatSemestre es el id del semestre
	 * @return CatGrupo es el grupo o null en caso de no encontrar nada
	 */
    @Query("SELECT cg FROM CatGrupo cg WHERE cg.catCarrera.idCatCarrera = :idCatCarrera AND cg.catSemestre.idCatSemestre = :idCatSemestre")
    CatGrupo findByCarreraAndSemestre(@Param("idCatCarrera") Integer idCatCarrera, @Param("idCatSemestre") Integer idCatSemestre);


    /**
     * Obtiene la carrera en base al id del grupo
     * @param idCatGrupo
     * @return CatCarrera o null en caso de no encontrar nada
     */
    @Query("SELECT cg.catCarrera FROM CatGrupo cg WHERE cg.idCatGrupo = :idCatGrupo")
    CatCarrera findCarreraByIdCatGrupo(@Param("idCatGrupo") Integer idCatGrupo);
    
    
    /**
     * Obtiene el semestre en base al id del grupo
     * @param idCatGrupo
     * @return CatSemestre o null en caso de no encontrar nada
     */
    @Query("SELECT cg.catSemestre FROM CatGrupo cg WHERE cg.idCatGrupo = :idCatGrupo")
    CatSemestre findSemestreByIdCatGrupo(@Param("idCatGrupo") Integer idCatGrupo);

    //metodo para obtener el grupo por el nombre del grupo
    CatGrupo findByNombreGrupo(String nombreGrupo);
}

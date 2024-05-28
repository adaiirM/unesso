package com.example.unesso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatMunicipio;

/**
 * "Esta clase realiza operaciones CRUD en la entidad CatMunicipio de la Base de datos unesso") 
 */
public interface CatMunicipioRepository extends JpaRepository<CatMunicipio, Integer> {
	//Recupera los municipios de un estado
	List<CatMunicipio> findMunicipiosByCatEstado_IdCatEstado(Integer idCatEstado);
	
	@Query("SELECT cm.catEstado FROM CatMunicipio cm WHERE cm.idCatMunicipio = :idMunicipio")
	CatEstado obtenerEstadoPorIdMunicipio(@Param("idMunicipio") Integer idMunicipio);

}

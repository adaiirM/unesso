package com.example.unesso.repository;

import java.util.List;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.unesso.model.CatEstado;
import com.example.unesso.model.CatMunicipio;

@Description("Esta clase realiza operaciones CRUD en la entidad CatMunicipio de la Base de datos unesso") 
public interface CatMunicipioRepository extends JpaRepository<CatMunicipio, Integer> {
	List<CatMunicipio> findByCatEstado(CatEstado estado);
	//Recupera los municipios de un estado
	List<CatMunicipio> findMunicipiosByCatEstado_IdCatEstado(Integer idCatEstado);
	
	@Query("SELECT cm.catEstado FROM CatMunicipio cm WHERE cm.idCatMunicipio = :idMunicipio")
	CatEstado obtenerEstadoPorIdMunicipio(@Param("idMunicipio") Integer idMunicipio);
}

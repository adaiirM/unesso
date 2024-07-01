package com.example.unesso.repository;

import com.example.unesso.model.CatDistrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CatDistritoRepository extends JpaRepository<CatDistrito, Integer> {
	 @Query("SELECT d FROM CatDistrito d WHERE d.catRegion.idCatRegion = :regionId")
	 List<CatDistrito> findDistritosByRegionId(@Param("regionId") Integer regionId);
}

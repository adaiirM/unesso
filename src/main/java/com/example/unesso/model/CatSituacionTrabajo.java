package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catSituacionTrabajo")
public class CatSituacionTrabajo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatSituacionTrabajo;
	
	private String nombreSituacionTrabajo;
	
	
	public Integer getIdCatSituacionTrabajo() {
		return idCatSituacionTrabajo;
	}
	
	public void setIdCatSituacionTrabajo(Integer idCatSituacionTrabajo) {
		this.idCatSituacionTrabajo = idCatSituacionTrabajo;
	}
	
	public String getNombreSituacionTrabajo() {
		return nombreSituacionTrabajo;
	}
	
	public void setNombreSituacionTrabajo(String nombreSituacionTrabajo) {
		this.nombreSituacionTrabajo = nombreSituacionTrabajo;
	}
	
	
	@Override
	public String toString() {
		return "CatSituacionTrabajo [idCatSituacionTrabajo=" + idCatSituacionTrabajo + ", nombreSituacionTrabajo="
				+ nombreSituacionTrabajo + "]";
	}
	
	

}

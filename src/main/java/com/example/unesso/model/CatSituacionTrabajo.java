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
	private Integer idCatSituacion;
	
	private String nombreSituacionTrabajo;
	
	
	public Integer getIdCatSituacion() {
		return idCatSituacion;
	}
	
	public void setIdCatSituacion(Integer idCatSituacion) {
		this.idCatSituacion = idCatSituacion;
	}
	
	public String getNombreSituacionTrabajo() {
		return nombreSituacionTrabajo;
	}
	
	public void setNombreSituacionTrabajo(String nombreSituacionTrabajo) {
		this.nombreSituacionTrabajo = nombreSituacionTrabajo;
	}
	
	
	@Override
	public String toString() {
		return "CatSituacionTrabajo [idCatSituacionTrabajo=" + idCatSituacion + ", nombreSituacionTrabajo="
				+ nombreSituacionTrabajo + "]";
	}
	
	

}

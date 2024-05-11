package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catOcupacion")
public class CatOcupacion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatOcupacion;
	
	private String nombreOcupacion;

	
	
	public Integer getIdCatOcupacion() {
		return idCatOcupacion;
	}

	public void setIdCatOcupacion(Integer idCatOcupacion) {
		this.idCatOcupacion = idCatOcupacion;
	}

	public String getNombreOcupacion() {
		return nombreOcupacion;
	}

	public void setNombreOcupacion(String nombreOcupacion) {
		this.nombreOcupacion = nombreOcupacion;
	}

	
	
	@Override
	public String toString() {
		return "CatOcupacion [idCatOcupacion=" + idCatOcupacion + ", nombreOcupacion=" + nombreOcupacion + "]";
	}
	

	
	
}

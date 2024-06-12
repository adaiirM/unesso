package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catEscolaridad")
public class CatEscolaridad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatEscolaridad;
	
	private String nombreEscolaridad;
	
	

	public Integer getIdCatEscolaridad() {
		return idCatEscolaridad;
	}

	public void setIdCatEscolaridad(Integer idCatEscolaridad) {
		this.idCatEscolaridad = idCatEscolaridad;
	}

	public String getNombreEscolaridad() {
		return nombreEscolaridad;
	}

	public void setNombreEscolaridad(String nombreEscolaridad) {
		this.nombreEscolaridad = nombreEscolaridad;
	}

	@Override
	public String toString() {
		return "CatEscolaridad [idCatEscolaridad=" + idCatEscolaridad + ", nombreEscolaridad=" + nombreEscolaridad
				+ "]";
	}
	
	

}

package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catMedios")
public class CatMedios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatMedios;
	
	private String nombreMedios;

	
	
	public Integer getIdCatMedios() {
		return idCatMedios;
	}

	public void setIdCatMedios(Integer idCatMedios) {
		this.idCatMedios = idCatMedios;
	}

	public String getNombreMedios() {
		return nombreMedios;
	}

	public void setNombreMedios(String nombreMedios) {
		this.nombreMedios = nombreMedios;
	}
	
	

	@Override
	public String toString() {
		return "CatMedios [idCatMedios=" + idCatMedios + ", nombreMedios=" + nombreMedios + "]";
	}
	
	

}

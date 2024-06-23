package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catMediosTransporte")
public class CatMediosTransporte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatMediosTransporte;
	
	private String nombreMediosTransporte;

	
	
	
	public Integer getIdCatMediosTransporte() {
		return idCatMediosTransporte;
	}

	public void setIdCatMediosTransporte(Integer idCatMediosTransporte) {
		this.idCatMediosTransporte = idCatMediosTransporte;
	}

	public String getNombreMediosTransporte() {
		return nombreMediosTransporte;
	}

	public void setNombreMediosTransporte(String nombreMediosTransporte) {
		this.nombreMediosTransporte = nombreMediosTransporte;
	}

	
	
	@Override
	public String toString() {
		return "CatMediosTransporte [idCatMediosTransporte=" + idCatMediosTransporte + ", nombreMediosTransporte="
				+ nombreMediosTransporte + "]";
	}
	
	

}

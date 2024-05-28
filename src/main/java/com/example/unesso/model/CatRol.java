package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catRol")
public class CatRol {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatRol;
	
	private String nombreRol;
	
	
	public Integer getIdCatRol() {
		return idCatRol;
	}
	public void setIdCatRol(Integer idCatRol) {
		this.idCatRol = idCatRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	
	
	@Override
	public String toString() {
		return "CatRol [idCatRol=" + idCatRol + ", nombreRol=" + nombreRol + "]";
	}
	
	
}

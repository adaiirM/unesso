package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catInternet")
public class CatInternet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatInternet;
	
	private String nombreInternet;
	
	
	
	
	public Integer getIdCatInternet() {
		return idCatInternet;
	}
	public void setIdCatInternet(Integer idCatInternet) {
		this.idCatInternet = idCatInternet;
	}
	public String getNombreInternet() {
		return nombreInternet;
	}
	public void setNombreInternet(String nombreInternet) {
		this.nombreInternet = nombreInternet;
	}
	@Override
	public String toString() {
		return "CatInternet [idCatInternet=" + idCatInternet + ", nombreInternet=" + nombreInternet + "]";
	}
	
	
	
}

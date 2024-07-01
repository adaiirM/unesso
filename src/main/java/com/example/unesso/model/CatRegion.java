package com.example.unesso.model;

import jakarta.persistence.*;

@Entity
@Table(name="catRegion")
public class CatRegion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatRegion;
	private String nombreRegion;
	
	public Integer getIdCatRegion() {
		return idCatRegion;
	}
	public void setIdCatRegion(Integer idCatRegion) {
		this.idCatRegion = idCatRegion;
	}
	public String getNombreRegion() {
		return nombreRegion;
	}
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}
		
}

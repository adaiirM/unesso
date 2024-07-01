package com.example.unesso.model;

import jakarta.persistence.*;

@Entity
@Table(name="catDistrito")
public class CatDistrito {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatDistrito;
	
	@OneToOne
	@JoinColumn(name="idCatRegion")
	private CatRegion catRegion;
	
	private String nombreDistrito;

	public Integer getIdCatDistrito() {
		return idCatDistrito;
	}

	public void setIdCatDistrito(Integer idCatDistrito) {
		this.idCatDistrito = idCatDistrito;
	}

	public CatRegion getCatRegion() {
		return catRegion;
	}

	public void setCatRegion(CatRegion catRegion) {
		this.catRegion = catRegion;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}
	
	
	
	
}

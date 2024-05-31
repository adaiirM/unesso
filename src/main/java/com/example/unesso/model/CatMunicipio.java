package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="catMunicipio")
public class CatMunicipio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatMunicipio;
	
	@OneToOne
	@JoinColumn(name="idCatEstado")
	private CatEstado catEstado;
	
	private String nombreMunicipio;

	public Integer getIdCatMunicipio() {
		return idCatMunicipio;
	}

	public void setIdCatMunicipio(Integer idCatMunicipio) {
		this.idCatMunicipio = idCatMunicipio;
	}

	public CatEstado getCatEstado() {
		return catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	@Override
	public String toString() {
		return "CatMunicipio [idCatMunicipio=" + idCatMunicipio + ", catEstado=" + catEstado + ", nombreMunicipio="
				+ nombreMunicipio + "]";
	}

	

	
	
}

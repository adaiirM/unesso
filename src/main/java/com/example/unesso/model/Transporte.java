package com.example.unesso.model;

import java.time.Year;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transporte")
public class Transporte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTransporte;
	
	@OneToOne
	@JoinColumn(name="idCatTipoTransporte")
	private CatTipoTransporte catTipoTransporte;
	

	
	private String marca;
	
	private String modelo;
	
	private Year anio;

	
	public Integer getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(Integer idTransporte) {
		this.idTransporte = idTransporte;
	}

	public CatTipoTransporte getCatTipoTransporte() {
		return catTipoTransporte;
	}

	public void setCatTipoTransporte(CatTipoTransporte catTipoTransporte) {
		this.catTipoTransporte = catTipoTransporte;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Year getAnio() {
		return anio;
	}

	public void setAnio(Year anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Transporte [idTransporte=" + idTransporte + ", catTipoTransporte=" + catTipoTransporte + ", alumno="
				+ ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + "]";
	}
	
	
	

}

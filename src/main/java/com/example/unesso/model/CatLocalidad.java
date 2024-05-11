package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="catLocalidad")
public class CatLocalidad {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatLocalidad;
	
 	@OneToOne
 	@JoinColumn(name="idCatMunicipio")
 	private CatMunicipio catMunicipio;
 	
 	@OneToOne
 	@JoinColumn(name="idCatCodigoPostal")
	private CatCodigoPostal catCodigoPostal;	
	 
	private String nombreLocalidad;


	
	
	public Integer getIdCatLocalidad() {
		return idCatLocalidad;
	}


	public void setIdCatLocalidad(Integer idCatLocalidad) {
		this.idCatLocalidad = idCatLocalidad;
	}


	public CatMunicipio getCatMunicipio() {
		return catMunicipio;
	}


	public void setCatMunicipio(CatMunicipio catMunicipio) {
		this.catMunicipio = catMunicipio;
	}


	public CatCodigoPostal getCatCodigoPostal() {
		return catCodigoPostal;
	}


	public void setCatCodigoPostal(CatCodigoPostal catCodigoPostal) {
		this.catCodigoPostal = catCodigoPostal;
	}


	public String getNombreLocalidad() {
		return nombreLocalidad;
	}


	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}


	@Override
	public String toString() {
		return "CatLocalidad [idCatLocalidad=" + idCatLocalidad + ", catMunicipio=" + catMunicipio
				+ ", catCodigoPostal=" + catCodigoPostal + ", nombreLocalidad=" + nombreLocalidad + "]";
	}
	
	

}

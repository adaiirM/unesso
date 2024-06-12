package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="domicilio")
public class Domicilio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDomicilio;
	
	@OneToOne
	@JoinColumn(name="idCatLocalidad")
	private CatLocalidad catLocalidad;
	
	private String coloniaBarrio;
	
	private String calle;
	
	private Integer numero;

	public Integer getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public CatLocalidad getCatLocalidad() {
		return catLocalidad;
	}

	public void setCatLocalidad(CatLocalidad catLocalidad) {
		this.catLocalidad = catLocalidad;
	}

	public String getColoniaBarrio() {
		return coloniaBarrio;
	}

	public void setColoniaBarrio(String coloniaBarrio) {
		this.coloniaBarrio = coloniaBarrio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
	@Override
	public String toString() {
		return "Domicilio [idDomicilio=" + idDomicilio + ", catLocalidad=" + catLocalidad + ", coloniaBarrio="
				+ coloniaBarrio + ", calle=" + calle + ", numero=" + numero + "]";
	}
	

}

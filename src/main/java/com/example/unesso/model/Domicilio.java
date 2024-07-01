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
	
	private String coloniaBarrio;
	
	private String calle;
	
	private String numero;

	private String region;

	private String distrito;
	@OneToOne
	@JoinColumn(name="idCatLocalidad")
	private CatLocalidad catLocalidad;

	public Integer getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public CatLocalidad getCatLocalidad() {
		return catLocalidad;
	}

	public void setCatLocalidad(CatLocalidad catLocalidad) {
		this.catLocalidad = catLocalidad;
	}

	@Override
	public String toString() {
		return "Domicilio{" +
				"idDomicilio=" + idDomicilio +
				", coloniaBarrio='" + coloniaBarrio + '\'' +
				", calle='" + calle + '\'' +
				", numero='" + numero + '\'' +
				", region='" + region + '\'' +
				", distrito='" + distrito + '\'' +
				", catLocalidad=" + catLocalidad +
				'}';
	}
}

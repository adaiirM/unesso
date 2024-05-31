package com.example.unesso.model;

import java.util.Date;

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
	
	@OneToOne
	@JoinColumn(name="idAlumno")
	private Alumno alumno;
	
	private String marca;
	
	private String modelo;
	
	private Date anio;

	
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

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
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

	public Date getAnio() {
		return anio;
	}

	public void setAnio(Date anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Transporte [idTransporte=" + idTransporte + ", catTipoTransporte=" + catTipoTransporte + ", alumno="
				+ alumno + ", marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + "]";
	}
	
	
	

}

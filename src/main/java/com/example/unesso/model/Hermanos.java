package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="hermanos")
public class Hermanos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idHermanos;
	
	@OneToOne
	@JoinColumn(name="idFamilia")
	private Familia Familia;
	
	private String nombreHermanos;
	
	private Integer edad;
	
	private String nombreEscuela;
	
	private String grado;
	

	public Integer getIdHermanos() {
		return idHermanos;
	}

	public void setIdHermanos(Integer idHermanos) {
		this.idHermanos = idHermanos;
	}

	public Familia getFamilia() {
		return Familia;
	}

	public void setFamilia(Familia familia) {
		Familia = familia;
	}

	public String getNombreHermanos() {
		return nombreHermanos;
	}

	public void setNombreHermanos(String nombreHermanos) {
		this.nombreHermanos = nombreHermanos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNombreEscuela() {
		return nombreEscuela;
	}

	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	@Override
	public String toString() {
		return "Hermanos [idHermanos=" + idHermanos + ", Familia=" + Familia + ", nombreHermanos=" + nombreHermanos
				+ ", edad=" + edad + ", nombreEscuela=" + nombreEscuela + ", grado=" + grado + "]";
	}
	
	

}

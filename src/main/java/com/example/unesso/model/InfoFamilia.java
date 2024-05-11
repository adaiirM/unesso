package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="infoFamilia")
public class InfoFamilia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idInfoFamilia;
	
	private Integer numHermanos;
	
	private Integer hermanosEstudiando;
	
	private Integer hermanosDejoEstudio;
	
	private Integer hermanosLicenciatura;
	
	@OneToOne
	@JoinColumn(name="escolaridadPadre")
	private CatEscolaridad catEscolaridadPadre;
	
	@OneToOne
	@JoinColumn(name="escolaridadMadre")
	private CatEscolaridad catEscolaridadMadre;
	

	public Integer getIdInfoFamilia() {
		return idInfoFamilia;
	}

	public void setIdInfoFamilia(Integer idInfoFamilia) {
		this.idInfoFamilia = idInfoFamilia;
	}

	public Integer getNumHermanos() {
		return numHermanos;
	}

	public void setNumHermanos(Integer numHermanos) {
		this.numHermanos = numHermanos;
	}

	public Integer getHermanosEstudiando() {
		return hermanosEstudiando;
	}

	public void setHermanosEstudiando(Integer hermanosEstudiando) {
		this.hermanosEstudiando = hermanosEstudiando;
	}

	public Integer getHermanosDejoEstudio() {
		return hermanosDejoEstudio;
	}

	public void setHermanosDejoEstudio(Integer hermanosDejoEstudio) {
		this.hermanosDejoEstudio = hermanosDejoEstudio;
	}

	public Integer getHermanosLicenciatura() {
		return hermanosLicenciatura;
	}

	public void setHermanosLicenciatura(Integer hermanosLicenciatura) {
		this.hermanosLicenciatura = hermanosLicenciatura;
	}

	public CatEscolaridad getCatEscolaridadPadre() {
		return catEscolaridadPadre;
	}

	public void setCatEscolaridadPadre(CatEscolaridad catEscolaridadPadre) {
		this.catEscolaridadPadre = catEscolaridadPadre;
	}

	public CatEscolaridad getCatEscolaridadMadre() {
		return catEscolaridadMadre;
	}

	public void setCatEscolaridadMadre(CatEscolaridad catEscolaridadMadre) {
		this.catEscolaridadMadre = catEscolaridadMadre;
	}

	@Override
	public String toString() {
		return "InfoFamilia [idInfoFamilia=" + idInfoFamilia + ", numHermanos=" + numHermanos + ", hermanosEstudiando="
				+ hermanosEstudiando + ", hermanosDejoEstudio=" + hermanosDejoEstudio + ", hermanosLicenciatura="
				+ hermanosLicenciatura + ", catEscolaridadPadre=" + catEscolaridadPadre + ", catEscolaridadMadre="
				+ catEscolaridadMadre + "]";
	}
	
	
	
	
	
	
}

package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mediosEstudio")
public class MediosEstudios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMediosEstudios;
	
	@OneToOne
	@JoinColumn(name="idCatMedios")
	private CatMedios catMedios;
	
	@OneToOne
	@JoinColumn(name="idAlumno")
	private Alumno alumno;
	
	@OneToOne
	@JoinColumn(name="idCatInternet")
	private CatInternet catInternet;

	
	
	public Integer getIdMediosEstudio() {
		return idMediosEstudios;
	}

	public void setIdMediosEstudio(Integer idMediosEstudio) {
		this.idMediosEstudios = idMediosEstudio;
	}

	public CatMedios getCatMedios() {
		return catMedios;
	}

	public void setCatMedios(CatMedios catMedios) {
		this.catMedios = catMedios;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public CatInternet getCatInternet() {
		return catInternet;
	}

	public void setCatInternet(CatInternet catInternet) {
		this.catInternet = catInternet;
	}

	@Override
	public String toString() {
		return "MediosEstudio [idMediosEstudio=" + idMediosEstudios + ", catMedios=" + catMedios + ", alumno=" + alumno
				+ ", catInternet=" + catInternet + "]";
	}
	
	
	

}

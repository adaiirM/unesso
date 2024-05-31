package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="catGrupo")
public class CatGrupo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatGrupo;
	
	@OneToOne
	@JoinColumn(name="idCatCarrera")
	private CatCarrera catCarrera;
	
	@OneToOne 
	@JoinColumn(name="idCatSemestre")
	private CatSemestre catSemestre;
	
	private String nombreGrupo;
	


	public Integer getIdCatGrupo() {
		return idCatGrupo;
	}


	public void setIdCatGrupo(Integer idCatGrupo) {
		this.idCatGrupo = idCatGrupo;
	}


	public CatCarrera getCatCarrera() {
		return catCarrera;
	}


	public void setCatCarrera(CatCarrera catCarrera) {
		this.catCarrera = catCarrera;
	}


	public CatSemestre getCatSemestre() {
		return catSemestre;
	}


	public void setCatSemestre(CatSemestre catSemestre) {
		this.catSemestre = catSemestre;
	}


	public String getNombreGrupo() {
		return nombreGrupo;
	}


	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}


	@Override
	public String toString() {
		return "CatGrupo [idCatGrupo=" + idCatGrupo + ", catCarrera=" + catCarrera + ", catSemestre=" + catSemestre
				+ ", nombreGrupo=" + nombreGrupo + "]";
	}

	
	
}

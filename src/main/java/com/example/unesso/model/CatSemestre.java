package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catSemestre")
public class CatSemestre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatSemestre;
	
	private String nombreSemestre;
	

	public Integer getIdCatSemestre() {
		return idCatSemestre;
	}

	public void setIdCatSemestre(Integer idCatSemestre) {
		this.idCatSemestre = idCatSemestre;
	}

	public String getNombreSemestre() {
		return nombreSemestre;
	}

	public void setNombreSemestre(String nombreSemestre) {
		this.nombreSemestre = nombreSemestre;
	}
	

	@Override
	public String toString() {
		return "CatSemestre [idCatSemestre=" + idCatSemestre + ", nombreSemestre=" + nombreSemestre + "]";
	}
	
	

}
